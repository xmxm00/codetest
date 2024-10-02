package boj2887;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Minimal Spanning Tree?
 */

public class Main {
    static int N;
    static Pos[] planets;

    static class Pos {
        int x;
        int y;
        int z;

        Pos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/boj2887/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        planets = new Pos[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Pos(x, y, z);
        }
    }
}
