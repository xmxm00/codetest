package boj14502;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/*
* 백트래킹을 이용해 풀이할 수 있음
* 재귀를 활용해 map에 벽을 세우고, 3개가 되면 bfs, 이후 벽을 해제하고 계속 나아간다.
* */


public class Main {
    static int N, M;
    static int[][] map;
    static int[][] tempMap;
    static int[] DX = {1, 0, -1, 0};
    static int[] DY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/boj14502/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for (int i1 = 0; i1 < N; i1++) {
            for (int j1 = 0; j1 < M; j1++) {
                if(map[i1][j1] == 0) {
                    int i2 = i1;
                    for (int j2 = j1 + 1; j2 < M; j2++) {
                        if(map[i2][j2] == 0) {
                            int i3 = i2;
                            for (int j3 = j2 + 1; j3 < M; j3++) {
                                if (map[i3][j3] == 0) {
                                    // 3개 다 고름
                                    copyMap();
                                    tempMap[i1][j1] = 1;
                                    tempMap[i2][j2] = 1;
                                    tempMap[i3][j3] = 1;
                                    int tempSum = bfs(tempMap);
                                    /*
                                    if (result < tempSum) {
                                        result = tempSum;
                                        System.out.println(i1+ "," + j1+ "," + i2+ "," + j2+ "," + i3+ "," + j3);
                                    }
                                    */
                                    result = Math.max(result, bfs(tempMap));
                                }
                            }
                            for (i3 = i2 + 1; i3 < N; i3++) {
                                for (int j3 = 0; j3 < M; j3++) {
                                    if (map[i3][j3] == 0) {
                                        // 3개 다 고름
                                        copyMap();
                                        tempMap[i1][j1] = 1;
                                        tempMap[i2][j2] = 1;
                                        tempMap[i3][j3] = 1;
                                        result = Math.max(result, bfs(tempMap));
                                    }
                                }
                            }
                        }
                    }
                    for (i2 = i1 + 1; i2 < N; i2++) {
                        for (int j2 = 0; j2 < M; j2++) {
                            if(map[i2][j2] == 0) {
                                int i3 = i2;
                                for (int j3 = j2 + 1; j3 < M; j3++) {
                                    if (map[i3][j3] == 0) {
                                        // 3개 다 고름
                                        copyMap();
                                        tempMap[i1][j1] = 1;
                                        tempMap[i2][j2] = 1;
                                        tempMap[i3][j3] = 1;
                                        result = Math.max(result, bfs(tempMap));
                                    }
                                }
                                for (i3 = i2 + 1; i3 < N; i3++) {
                                    for (int j3 = 0; j3 < M; j3++) {
                                        if (map[i3][j3] == 0) {
                                            // 3개 다 고름
                                            copyMap();
                                            tempMap[i1][j1] = 1;
                                            tempMap[i2][j2] = 1;
                                            tempMap[i3][j3] = 1;
                                            result = Math.max(result, bfs(tempMap));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
        System.out.println(result);
    }

    static void copyMap() {
        tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
    }

    static int bfs(int[][] map) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    queue.offer(10 * i + j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int coords = queue.poll();
            int x = coords % 10;
            int y = coords / 10;
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + DX[dir];
                int ny = y + DY[dir];
                if(nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx] == 0) {
                    map[ny][nx] = 2;
                    queue.offer(10*ny + nx);
                }
            }
        }

        int tempSum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    tempSum++;
                }
            }
        }

        return tempSum;
    }
}
