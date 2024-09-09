package boj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            visited[0][i] = true;
            result += nQueen(0, i, 1);
            visited[0][i] = false;
        }

        System.out.println(result);
    }

    private static int nQueen(int i, int j, int count) {
        int result = 0;
        if (count == N) {
            // calculate
            return 1;

        } else {
            for (int a = 0; a < N; a++) {
                boolean colCondition = true;
                for (int b = 0; b <= i; b++) {
                    if (visited[b][a]) {
                        colCondition = false; break;
                    }
                }
                if(colCondition) {
                    boolean diagCondition = true;
                    int nx = a-1;
                    int ny = i;
                    while (nx >= 0 && ny >= 0) {
                        if (visited[ny][nx]) {
                            diagCondition = false;
                            break;
                        }
                        nx--; ny--;
                    }

                    nx = a+1;
                    ny = i;
                    while (nx < N && ny >= 0) {
                        if (visited[ny][nx]) {
                            diagCondition = false;
                            break;
                        }
                        nx++; ny--;
                    }

                    if (diagCondition) {
                        visited[i+1][a] = true;
                        result += nQueen(i + 1, a, count + 1);
                        visited[i+1][a] = false;
                    }
                }
            }
            return result;
        }
    }
}
