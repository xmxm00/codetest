package boj12852;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1]; Arrays.fill(dp, Integer.MAX_VALUE); dp[1] = 0;
        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }
        sb.append(dp[N]).append("\n");
        int num = N;
        while(true) {
            sb.append(num).append(" ");
            if(num == 1) break;
            int divisor = 1;
            int a = dp[num - 1];
            if(num % 2 == 0 && dp[num / 2] < a) {
                a = dp[num / 2];
                divisor = 2;
            }
            if(num % 3 == 0 && dp[num/3] < a) {
                a = dp[num / 3];
                divisor = 3;
            }
            if(divisor == 1) {
                num--;
            } else {
                num /= divisor;
            }
        }
        sb.append("\n");
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
