package baekjoon.p01.p1238;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int add(int a, int b) {
        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return a + b;
    }

    static void floydWarshall(int[][] A, int N) {
        for (int k = 0; k < N; ++k)
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < N; ++j)
                    A[i][j] = Math.min(A[i][j], add(A[i][k], A[k][j]));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int X = Integer.parseInt(tokenizer.nextToken()) - 1;
        int[][] A = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(A[i], Integer.MAX_VALUE);
            A[i][i] = 0;
        }
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken());
            A[a][b] = c;
        }
        floydWarshall(A, N);
        int max = 0;
        for (int i = 0; i < N; ++i) {
            int travel = A[i][X] + A[X][i];
            if (travel > max) max = travel;
        }
        System.out.println(max);
    }
}