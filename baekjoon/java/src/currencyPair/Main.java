package currencyPair;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] currency;
    static int[][] dp;
    static int INF = 11000;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/currencyPair/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        currency = new int[N];
        dp = new int[N][M+1];

        Arrays.fill(dp[0], INF);
        currency[0] = Integer.parseInt(br.readLine());
        for(int j=0; j<=M; j++) {
            if (j % currency[0] == 0) {
                dp[0][j] = j / currency[0];
            }
        }

        for (int i = 1; i < N; i++) {
            Arrays.fill(dp[i], INF);
            currency[i] = Integer.parseInt(br.readLine());
            for(int j=0; j<=M; j++) {
                if(j>=currency[i]) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j - currency[i]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        if (dp[N - 1][M] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1][M]);
        }

    }
}
