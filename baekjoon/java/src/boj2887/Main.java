package boj2887;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Minimal Spanning Tree?
 */

public class Main {
    static int N;
    static Pos[] planets;
    static PriorityQueue<Edge> edges = new PriorityQueue<>();
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }

        int from;
        int to;
        int dist;
        Edge(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "dist=" + dist +
                    '}';
        }
    }

    static class Pos {
        int num;
        int x;
        int y;
        int z;

        Pos(int num, int x, int y, int z) {
            this.num = num;
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
        parent = new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planets[i] = new Pos(i, x, y, z);
        }

        Arrays.sort(planets, (p1, p2) -> p1.x - p2.x);
        for(int i = 0; i < N-1; i++) {
            edges.offer(new Edge(planets[i].num, planets[i + 1].num, planets[i + 1].x - planets[i].x));
        }

        Arrays.sort(planets, (p1, p2) -> p1.y - p2.y);
        for(int i = 0; i < N-1; i++) {
            edges.offer(new Edge(planets[i].num, planets[i + 1].num, planets[i + 1].y - planets[i].y));
        }

        Arrays.sort(planets, (p1, p2) -> p1.z - p2.z);
        for(int i = 0; i < N-1; i++) {
            edges.offer(new Edge(planets[i].num, planets[i + 1].num, planets[i + 1].z - planets[i].z));
        }

        int result = 0;
        int num = 0;
        while (num != N - 1) {
            Edge edge = edges.poll();
            if(union(edge.from, edge.to)) {
                num++;
                result += edge.dist;
            }
        }

        System.out.println(result);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot != bRoot) {
            parent[bRoot] = aRoot;
            return true;
        } else {
            return false;
        }
    }

    public static int find(int a) {
        if(parent[a] == a) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}
