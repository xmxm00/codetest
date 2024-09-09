package AntWarriors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        dp = new int[N + 1];
        for(int i=1; i<=N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
        int result = dp[1];
        for(int i=3; i<=N; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + dp[i]);
            if(result < dp[i]) {
                result = dp[i];
            }
        }

        System.out.println(result);
    }
}
