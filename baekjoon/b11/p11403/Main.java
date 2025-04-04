package baekjoon.b11.p11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void floydWarshall(int[][] A) {
        int N = A.length;
        for (int k = 0; k < N; ++k)
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < N; ++j)
                    A[i][j] = Math.max(A[i][j], Math.min(A[i][k], A[k][j]));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[][] A = new int[N][N];
        for (int r = 0; r < N; ++r) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < N; ++c)
                A[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        floydWarshall(A);
        StringBuilder builder = new StringBuilder();
        for (int[] a : A) {
            for (int i : a)
                builder.append(i).append(' ');
            builder.append('\n');
        }
        System.out.println(builder.toString());
    }
}