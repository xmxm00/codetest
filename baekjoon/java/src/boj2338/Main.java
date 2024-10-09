package boj2338;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
    static String a, b;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/boj2338/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        System.out.println(add(a, b));
        System.out.println(subtract(a, b));
        System.out.println(multiply(a, b));
    }

    private static String makeZeroString(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<length; i++) {
            sb.append("0");
        }

        return sb.toString();
    }

    private static String multiply(String a, String b) {
        StringBuilder sb = new StringBuilder();
        boolean isNegativeA = isNegative(a);
        boolean isNegativeB = isNegative(b);
        if(isNegativeA || isNegativeB) {
            if(isNegativeA && isNegativeB) {
                a = a.substring(1);
                b = b.substring(1);
            } else {
                sb.append("-");
                if(isNegativeA) {
                    a = a.substring(1);
                } else  {
                    b = b.substring(1);
                }
            }
        }
        List<String> memo = new ArrayList<>(10);
        String tmp = "0";
        for(int i=0; i<10; i++) {
            memo.add(tmp);
            tmp = add(tmp, a);
        }
        String result = "0";
        int j=0;
        for(int i=b.length()-1; i>=0; i--) {
            int memoIdx = Integer.parseInt(b.substring(i, i + 1));
            String subResult = memo.get(memoIdx) + makeZeroString(j++);
            result = add(result, subResult);
        }
        if(result.equals("0")) {
            return result;
        } else {
            sb.append(result);
            return sb.toString();
        }
    }

    private static boolean isNegative(String s) {
        return s.charAt(0) == '-';
    }

    private static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        long subA;
        long subB;
        boolean isNegativeA = isNegative(a);
        boolean isNegativeB = isNegative(b);
        // Long 이용해서 크게크게 잘라나가기. Long = 8byte = 64bit = 16 * 1_000_000_000_000_000_000. 18개씩 끊어서 진행
        if(isNegativeA || isNegativeB) {
            if(isNegativeA && isNegativeB) {
                a = a.substring(1, a.length());
                b = b.substring(1, b.length());
                sb.append('-');
            } else if(isNegativeA) {
                return subtract(b, a.substring(1));
            } else if(isNegativeB) {
                return subtract(a, b.substring(1));
            }
        }

        Stack<String> stack = new Stack<>();
        if(a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int diff = a.length() - b.length();
        if(diff > 0) {
            String prefix = makeZeroString(diff);
            b = prefix + b;
        }
        int beginIndex = a.length();
        int endIndex = beginIndex;
        int addFromPrev = 0;
        for(beginIndex = beginIndex - 18; beginIndex>=0; beginIndex -= 18) {
            subA = Long.parseLong(a.substring(beginIndex, endIndex));
            subB = Long.parseLong(b.substring(beginIndex, endIndex));
            String subResult = (subA+subB+addFromPrev) + "";
            if(subResult.length() > 18) {
                addFromPrev = 1;
                subResult = subResult.substring(1);
            } else {
                addFromPrev = 0;
            }
            String prefix = makeZeroString(18 - subResult.length());;
            stack.push(prefix+subResult);
            endIndex = beginIndex;
        }
        if(endIndex != 0) {
            subA = Long.parseLong(a.substring(0, endIndex));
            subB = Long.parseLong(b.substring(0, endIndex));
            String subResult = (subA+subB+addFromPrev) + "";
            stack.push(subResult);
        } else if(addFromPrev != 0) {
            sb.append("1");
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static String subtract(String a, String b) {
        StringBuilder sb = new StringBuilder();
        long subA;
        long subB;
        boolean isNegativeA = isNegative(a);
        boolean isNegativeB = isNegative(b);
        if(isNegativeA || isNegativeB) {
            if(isNegativeA && isNegativeB) {
                a = a.substring(1);
                b = b.substring(1);
                String tmp = a;
                a = b;
                b = tmp;
            } else if (isNegativeA) {
                return "-" + add(a.substring(1), b);
            } else if (isNegativeB) {
                return add(a, b.substring(1));
            }
        }
        int diff = Math.abs(a.length() - b.length());
        if(diff > 0) {
            String prefix = makeZeroString(diff);;
            if(a.length() < b.length()) {
                a = prefix + a;
            } else {
                b = prefix + b;
            }
        }
        int comparison = a.compareTo(b);
        if(comparison < 0) {
            sb.append("-");
            String tmp = a;
            a = b;
            b = tmp;
        } else if (comparison == 0) {
            return "0";
        }

        Stack<String> stack = new Stack<>();
        int beginIndex = a.length();
        int endIndex = beginIndex;
        int subtractFromPrev = 0;
        for(beginIndex = beginIndex - 18; beginIndex>=0; beginIndex -= 18) {
            subA = Long.parseLong(a.substring(beginIndex, endIndex)) - subtractFromPrev;
            subB = Long.parseLong(b.substring(beginIndex, endIndex));
            Long subResult = subA - subB;
            if(subResult < 0) {
                subtractFromPrev = 1;
                subResult += 1_000_000_000_000_000_000L;
            } else {
                subtractFromPrev = 0;
            }
            String prefix = makeZeroString(18 - subResult.toString().length());;
            stack.push(prefix + subResult);
            endIndex = beginIndex;
        }
        if(endIndex != 0) {
            subA = Long.parseLong(a.substring(0, endIndex)) - subtractFromPrev;
            subB = Long.parseLong(b.substring(0, endIndex));
            Long subResult = subA - subB;
            if(subResult != 0) {
                stack.push(subResult.toString());
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
