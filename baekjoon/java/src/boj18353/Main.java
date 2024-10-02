package boj18353;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] powers;
    static int[] lis;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/boj18353/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        powers = new int[N + 1];
        lis = new int[N + 1];
        dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            powers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(lis, Integer.MAX_VALUE);
        lis[0] = powers[N];
        Arrays.fill(dp, 1);

//        int max_pos = 0;
//        for (int i=N-1; i>0; i--) {
//            int target = powers[i];
//            int pos = Arrays.binarySearch(lis, target);
//            if(pos < 0) {
//                pos = -pos - 1;
//            }
//            lis[pos] = target;
//            max_pos = Math.max(max_pos, pos);
//        }
//        max_pos++;
//        System.out.println(N - max_pos);
        for(int i=1; i<=N; i++) {
            for(int j=1; j<i; j++) {
                if(powers[j] > powers[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int result = Arrays.stream(dp).max().getAsInt();
        System.out.println(N - result);

    }
}
