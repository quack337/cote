package baekjoon.b04.p4307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int L = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());
            int min = 0, max = 0;
            for (int i = 0; i < N; ++i) {
                int p = Integer.parseInt(reader.readLine());
                min = Math.max(min, Math.min(p, L - p));
                max = Math.max(max, Math.max(p, L - p));
            }
            System.out.printf("%d %d\n", min, max);
        }
    }
}