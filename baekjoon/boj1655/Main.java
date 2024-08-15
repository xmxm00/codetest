package boj1655;

import java.io.*;
import java.util.*;

public class Main {
    // 1655
    static int N;
    static PriorityQueue<Integer> pq;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/boj1655/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            int input = Integer.parseInt(br.readLine());
            int pos = Collections.binarySearch(list, input);
            if(pos < 0) {
                pos = -pos - 1;
            }
            list.add(pos, input);
            sb.append(list.get(i / 2)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
