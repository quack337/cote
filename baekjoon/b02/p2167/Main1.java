package baekjoon.b02.p2167;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int R, C;
    static int[][] A;

    static int sum(int r, int c) {
        if (r < 0 || c < 0) return 0;
        return sum(r-1, c) + sum(r, c-1) - sum(r-1, c-1) + A[r][c];
    }

    static int sum(int r1, int c1, int r2, int c2) {
        return sum(r2, c2) - sum(r2, c1-1) - sum(r1-1, c2) + sum(r1-1, c1-1);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        A = new int[R][C];
        for (int r = 0; r < R; ++r) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < C; ++c)
                A[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        int K = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int k = 0; k < K; ++k) {
            tokenizer = new StringTokenizer(reader.readLine());
            int r1 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c1 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int r2 = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c2 = Integer.parseInt(tokenizer.nextToken()) - 1;
            builder.append(sum(r1, c1, r2, c2)).append('\n');
        }
        System.out.println(builder);
    }
}