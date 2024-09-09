package boj18352;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static int INF = Integer.MAX_VALUE;
    static int[] dist;
    static boolean[] visited;
    static List<Node>[] adjList;
    static class Node implements Comparable<Node>{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dist = new int[N+1]; Arrays.fill(dist, INF); dist[X] = 0;
        adjList = new ArrayList[N+1];
        visited = new boolean[N + 1];
        for(int i=1; i<=N; i++) {
            adjList[i] = new ArrayList<Node>();
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, 1));
        }
        dijkstra(X);
        int result = 0;
        for(int i=1; i<=N; i++) {
            if (dist[i] == K) {
                result++;
                sb.append(i).append("\n");
            }
        }

        if(result == 0) {
            System.out.println(-1);
        } else {
            bw.write(sb.toString());
            bw.flush();
        }

        bw.close(); br.close();
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(!visited[cur.to]) {
                visited[cur.to] = true;
                dist[cur.to] = cur.weight;
                for (Node e : adjList[cur.to]) {
                    pq.offer(new Node(e.to, cur.weight + e.weight));
                }
            }
        }
    }
}
