package question38;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 정확한 순위
    static int N, M;
    static int[][] adjMat;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/question38/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjMat = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(adjMat[i], INF);
            adjMat[i][i] = 0;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjMat[a][b] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (adjMat[i][k] != INF && adjMat[k][j] != INF) {
                        adjMat[i][j] = Math.min(adjMat[i][j], adjMat[i][k] + adjMat[k][j]);
                    }
                }
            }
        }
        int result = 0;
        for(int i=1; i<=N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                if(i == j) continue;
                if (adjMat[i][j] != INF) {
                    sum++;
                }
                if (adjMat[j][i] != INF) {
                    sum++;
                }
            }
            if (sum == N-1) {
                result++;
            }
        }

        /*for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (adjMat[i][j] == INF) {
                    sb.append("INF\t");
                }else {
                    sb.append(adjMat[i][j]).append("\t");

                }
            }
            sb.append("\n");
        }*/
        sb.append(result).append("\n");
        bw.write(sb.toString());
        bw.flush();

        bw.close(); br.close();
    }
}
