package boj1932;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] triangle;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/question32/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        triangle = new int[N][N];
        dp = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<i+1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = triangle[0][0];
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<i+1; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], triangle[i+1][j]+dp[i][j]);
                dp[i + 1][j + 1] = dp[i][j] + triangle[i+1][j+1];
            }
        }
        int max = dp[N-1][0];
        for(int i=1; i<N; i++) {
            max = Math.max(max, dp[N - 1][i]);
        }

        System.out.println(max);
    }
}
