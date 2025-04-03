package baekjoon.p23.p23253;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    @SuppressWarnings("unused")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        for (int m = 0; m < M; ++m) {
            int k = Integer.parseInt(reader.readLine());
            int prev = Integer.MAX_VALUE;
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < k; ++i) {
                int value = Integer.parseInt(tokenizer.nextToken());
                if (value > prev) {
                    System.out.println("No");
                    return;
                }
                prev = value;
            }
        }
        System.out.println("Yes");
    }
}