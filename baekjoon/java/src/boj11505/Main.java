package boj11505;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, S;
    static int[] segTree;
    static int DIVISOR = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("baekjoon/java/src/boj11505/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = 1;
        while (S < N) {
            S *= 2;
        }
        segTree = new int[2*S];
        Arrays.fill(segTree, 1); segTree[0] = 0;
        for (int i = 0; i < N; i++) {
            segTree[S + i] = Integer.parseInt(br.readLine());
        }

        initTree();
        for (int i = 0; i < M + K; i++) {
//            printTree();
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                // update b to c
                update(b, c);
            } else if (a == 2) {
                // query from b to c
                int result = query(1, S, 1, b, c);
                sb.append(result).append("\n");
            }
        }
        bw.write(sb.toString()); bw.flush();

        bw.close(); br.close();
    }

    private static int query(int start, int end, int node, int qLeft, int qRight) {
        if (qLeft > end || qRight < start) {
            return 1;
        }
        if (start == end) {
            return segTree[node];
        }
        if((qLeft <= start && end <= qRight)) {
            return segTree[node];
        }
        else {
            int mid = (start + end) / 2;
            long retVal = query(start, mid, node * 2, qLeft, qRight) % DIVISOR;
            retVal *= query(mid + 1, end, node * 2 + 1, qLeft, qRight) % DIVISOR;
            retVal %= DIVISOR;
            return (int)retVal;
        }
    }

    private static void initTree() {
        int start = S, end = 2 * S;
        while (start != 1) {
            for(int i = start; i < end; i+=2) {
                long parent = ((long)segTree[i] * segTree[i+1]) % DIVISOR;
                segTree[i / 2] = (int) parent;
            }
            start /= 2; end /= 2;
        }
    }

    private static void update(int target, int val) {
        int node = S + target - 1;
        segTree[node] = val; node /= 2;
        while (node != 0) {
            long tmp = ((long)segTree[node * 2] * segTree[node * 2 + 1]) % DIVISOR;
            segTree[node] = (int) tmp;
            node /= 2;
        }
    }

    static void printTree() {
        System.out.println(Arrays.toString(segTree));
    }
}
