package boj2338;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    static String a, b;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/boj2338/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        if(a.length() >= b.length()) {
            System.out.println(add(a, b));
        } else {
            System.out.println(add(b, a));
        }


    }

    private static boolean isNagative(String s) {
        return s.charAt(0) == '-';
    }

    private static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        long subA;
        long subB;
        boolean isNagativeA = isNagative(a);
        boolean isNagativeB = isNagative(b);
        // Long 이용해서 크게크게 잘라나가기. Long = 8byte = 64bit = 16 * 1_000_000_000_000_000_000. 18개씩 끊어서 진행
        if(isNagativeA || isNagativeB) {
            if(isNagativeA && isNagativeB) {
                a = a.substring(1, a.length());
                b = b.substring(1, b.length());
                sb.append('-');
                addPositives(a, b, sb);
            } else if(isNagativeA) {


            } else if(isNagativeB) {

            }
        }
        else {
            addPositives(a, b, sb);
        }
        return sb.toString();
    }

    private static void addPositives(String a, String b, StringBuilder sb) {
        long subA;
        long subB;
        Stack<String> stack = new Stack<>();
        int diff = a.length() - b.length();
        if(diff > 0) {
            char[] arr = new char[diff];
            Arrays.fill(arr, '0');
            String prefix = new String(arr);
            System.out.println(prefix);
            b = prefix.concat(b);
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
            stack.push(subResult);
            endIndex = beginIndex;
        }
        subA = Long.parseLong(a.substring(0, endIndex));
        subB = Long.parseLong(b.substring(0, endIndex));
        String subResult = (subA+subB+addFromPrev) + "";
        stack.push(subResult);
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
    }
}
