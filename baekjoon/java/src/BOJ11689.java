import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11689 {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        int result = 1;
        for(long i=2; i<N; i++) {
            if(gcd(N, i) == 1) {
                result++;
            }
        }
        System.out.println(result);
    }

    static long gcd(long a, long b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }
}
