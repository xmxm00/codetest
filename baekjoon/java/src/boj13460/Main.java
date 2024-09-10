package boj13460;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    static int N, M;
    static char[][] map;
    static int[] DX = {1, 0, -1, 0};
    static int[] DY = {0, -1, 0, 1};

    static class BallInfo {
        int redX;
        int redY;
        int blueX;
        int blueY;
        int count;

        boolean isBlueArrived() {
            return map[blueY][blueX] == '0';
        }

        boolean isRedArrived() {
            return map[redY][redX] == '0';
        }

    }

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/boj13460/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        BallInfo ballinfo = new BallInfo();
        ballinfo.count = 0;
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            String row = br.readLine();
            for(int j=0; j<M; j++) {
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'R') {
                    ballinfo.redX = j;
                    ballinfo.redY = i;
                    map[i][j] = '.';
                }
                if (map[i][j] == 'B') {
                    ballinfo.blueX = j;
                    ballinfo.blueY = i;
                    map[i][j] = '.';
                }
            }
        }
        ArrayDeque<BallInfo> queue = new ArrayDeque<>();
        queue.offer(ballinfo);
        while(!queue.isEmpty()) {
            BallInfo cur = queue.poll();
            map[cur.redY][cur.redX] = 'R';
            map[cur.blueY][cur.blueX] = 'B';
            int dirX = cur.blueX - cur.redX;
            dirX = dirX < 0 ? -1 : dirX == 0 ? 0 : 1;
            int dirY = cur.blueY - cur.redY;
            dirY = dirY < 0 ? -1 : dirY == 0 ? 0 : 1;
            for (int i = 0; i < 4; i++) {
                BallInfo next = new BallInfo(); next.count = cur.count + 1;
                if(dirX == DX[i] && dirY == DY[i]) {
                    blueMove(cur, next, i);
                    redMove(cur, next, i);
                } else {
                    redMove(cur, next, i);
                    blueMove(cur, next, i);
                }
            }
        }

    }

    private static void redMove(BallInfo cur, BallInfo next, int dir) {
        int nx = cur.redX + DX[dir];
        int ny = cur.redY + DY[dir];
        while (true) {
            if (map[ny][nx] == '#' || map[ny][nx] == 'B') {
                nx -= DX[dir];
                ny -= DY[dir];
                break;
            }
            if (map[ny][nx] == '0') {
                break;
            }
            nx += DX[dir];
            ny += DY[dir];
        }
        next.redX = nx;
        next.redY = ny;
    }

    private static void blueMove(BallInfo cur, BallInfo next, int dir) {
        int nx = cur.blueX + DX[dir];
        int ny = cur.blueY + DY[dir];
        while (true) {
            if (map[ny][nx] == '#' || map[ny][nx] == 'R') {
                nx -= DX[dir];
                ny -= DY[dir];
                break;
            }
            if (map[ny][nx] == '0') {
                break;
            }
            nx += DX[dir];
            ny += DY[dir];
        }
        next.blueX = nx;
        next.blueY = ny;
    }
}