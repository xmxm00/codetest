package floorConstruction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(1);
        } else if (N == 2) {
            System.out.println(3);
        } else {
            dp = new int[N + 1]; dp[1] = 1; dp[2] = 3;
            for(int i=3; i<=N; i++) {
                dp[i] = dp[i-1] + dp[i-2] * 2;
                dp[i] %= 796_796;
            }

            System.out.println(dp[N]);
        }
    }
}
