package boj18406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        int leftSum = 0;
        for(int i=0; i<n.length() / 2; i++) {
            leftSum += Integer.parseInt(n.substring(i, i+1));
        }
        int rightSum = 0;
        for(int i=n.length() / 2; i<n.length(); i++) {
            rightSum += Integer.parseInt(n.substring(i, i + 1));
        }

        if(leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }

}
