package baekjoon.b01.b1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), "+-", true);
        int sum = 0, sign = 1;
        while (true) {
            sum += sign * Integer.parseInt(tokenizer.nextToken());
            if (tokenizer.hasMoreTokens() == false) break;
            if (tokenizer.nextToken().charAt(0) == '-') sign = -1;
        }
        System.out.println(sum);
    }
}