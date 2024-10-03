package progs42891;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/progs42891/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());
        List<Integer> food_times = new ArrayList<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            food_times.add(Integer.parseInt(st.nextToken()));
        }
        int result = solution(food_times.stream().mapToInt(x -> x).toArray(), k);
        System.out.println(result);

    }

    public static int solution(int[] food_times, long k) {
        long sum = 0;
        PriorityQueue<FT> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
        for(int i=0; i<food_times.length; i++) {
            pq.offer(new FT(i+1, food_times[i]));
            sum += food_times[i];
        }
        if(sum <= k) {
            return -1;
        }
        long previous = 0;
        while(!pq.isEmpty()) {
            FT cur = pq.peek();
            long now = cur.time;
            long target = (now - previous) * pq.size();
            if(k >= target) {
                k -= target;
                previous = now;
                pq.poll();
            } else {
                break;
            }
        }
        List<FT> ft = new ArrayList<>(pq);
        ft.sort((o1, o2) -> Integer.compare(o1.num, o2.num));
//        List<FT> ft = pq.stream().sorted((o1, o2) -> Integer.compare(o1.num, o2.num)).collect(Collectors.toList());
        return ft.get(((int)k) % ft.size()).num;
    }

    static class FT {
        int num;
        int time;

        FT(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public String toString() {
            return "FT{" +
                    "num=" + num +
                    ", time=" + time +
                    '}';
        }
    }
}
