package baekjoon.p02.p2618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int N, W;
    static int[][] A;

    static int distance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    static int sol(int index, int r1, int c1, int r2, int c2) {
        if (index == W) return 0;
        int r = A[index][0], c = A[index][1];
        int distance1 = distance(r, c, r1, c1) + sol(index + 1, r, c, r2, c2);
        int distance2 = distance(r, c, r2, c2) + sol(index + 1, r1, c1, r, c);
        return Math.min(distance1, distance2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        W = Integer.parseInt(reader.readLine());
        A = new int[W][2];
        for (int i = 0; i < W; ++i) {
            var tokenizer = new StringTokenizer(reader.readLine());
            A[i][0] = Integer.parseInt(tokenizer.nextToken());
            A[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        int answer = sol(0, 1, 1, N, N);
        System.out.println(answer);
    }
}
