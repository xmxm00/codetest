package boj15686;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/boj15686/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        List<Pos> houses = new ArrayList<>();
        List<Pos> KFCs = new ArrayList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int info = Integer.parseInt(st.nextToken());
                if(info == 1) {
                    houses.add(new Pos(i+1, j+1));
                } else if(info == 2) {
                    KFCs.add(new Pos(i+1, j+1));
                }
            }
        }
        int[] dist = new int[KFCs.size()];
        for(int i=0; i<KFCs.size(); i++) {
            int distance = 0;
            Pos curKFC = KFCs.get(i);
            for(Pos house: houses) {
                distance += Math.abs(house.x - curKFC.x) + Math.abs(house.y - curKFC.y);
            }
            dist[i] = distance;
        }
        System.out.println(Arrays.toString(dist));

        Arrays.sort(dist);
        int result = 0;
        for(int i=0; i<M; i++) {
            result += dist[i];
        }

        System.out.println(result);
    }
}
