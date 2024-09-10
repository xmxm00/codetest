package boj13460;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


class Main {
    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("src/boj13460/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().toCharArray();
        }
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}