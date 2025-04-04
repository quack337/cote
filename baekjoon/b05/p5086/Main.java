package baekjoon.b05.p5086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            if (a == 0 && b == 0) break;
            String s = "neither";
            if (b % a == 0) s = "factor";
            else if (a % b == 0) s = "multiple";
            System.out.println(s);
        }
    }
}