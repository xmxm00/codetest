package boj1439;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/boj1439/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        long[] n = new long[2];
        char cur = s.charAt(0);
        n[Integer.parseInt(String.valueOf(cur))]++;
        for (char c : s.toCharArray()) {
            if (c != cur) {
                cur = c;
                n[Integer.parseInt(String.valueOf(c))]++;
            }
        }
        System.out.println(n[0] > n[1] ? n[1] : n[0]);
    }
}
