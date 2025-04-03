package baekjoon.p02.p2618;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    static int N, W;
    static int[][] A;
    static Integer[][] DP;

    static int distance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    static int sol(int index1, int index2) {
        if (DP[index1 + 1][index2 + 1] != null) return DP[index1 + 1][index2 + 1];
        int index = Math.max(index1, index2) + 1;
        if (index == W) return DP[index1 + 1][index2 + 1] = 0;
        int r = A[index][0], c = A[index][1];
        int r1 = 1, c1 = 1, r2 = N, c2 = N;
        if (index1 >= 0) {
            r1 = A[index1][0];
            c1 = A[index1][1];
        }
        if (index2 >= 0) {
            r2 = A[index2][0];
            c2 = A[index2][1];
        }
        int distance1 = distance(r, c, r1, c1) + sol(index, index2);
        int distance2 = distance(r, c, r2, c2) + sol(index1, index);
        return DP[index1 + 1][index2 + 1] = Math.min(distance1, distance2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        W = Integer.parseInt(reader.readLine());
        A = new int[W][2];
        DP = new Integer[W + 1][W + 1];
        for (int i = 0; i < W; ++i) {
            var tokenizer = new StringTokenizer(reader.readLine());
            A[i][0] = Integer.parseInt(tokenizer.nextToken());
            A[i][1] = Integer.parseInt(tokenizer.nextToken());
        }
        int answer = sol(-1, -1);
        System.out.println(answer);
    }
}