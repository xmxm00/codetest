package playground;

import java.io.BufferedReader;
import java.io.StringReader;

public class BufferedReaderPlayground{
    public static void main(String[] args) throws Exception{
        String s = "0010001010111";
        BufferedReader br = new BufferedReader(new StringReader(s));
        System.out.println(br.read()-'0');
        System.out.println(br.read()-'0');
        System.out.println(br.read()-'0');
        System.out.println(br.read()-'0');
    }
}
