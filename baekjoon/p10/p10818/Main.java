package baekjoon.p10.p10818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int 최대값 = Integer.MIN_VALUE, 최소값 = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i) {
            int value = Integer.parseInt(tokenizer.nextToken());
            if (value > 최대값) 최대값 = value;
            if (value < 최소값) 최소값 = value;
        }
        System.out.printf("%d %d\n", 최소값, 최대값);
    }
}