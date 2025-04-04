package baekjoon.b03.p3009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] X = new int[3], Y = new int[3];
        for (int i = 0; i < 3; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            X[i] = Integer.parseInt(tokenizer.nextToken());
            Y[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.printf("%d %d\n", X[0] ^ X[1] ^ X[2], Y[0] ^ Y[1] ^ Y[2]);
    }
}