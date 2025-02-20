package baekjoon.p11.p11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long add(long a, long b) {
        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return a + b;
    }

    static void floydWarshall(long[][] distance, int n) {
        for (int k = 0; k < n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    distance[i][j] = Math.min(distance[i][j], add(distance[i][k], distance[k][j]));
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        long[][] distance = new long[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
        }

        for (int i = 0; i < M; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken());
            distance[a][b] = Math.min(c, distance[a][b]);
        }

        floydWarshall(distance, N);

        for (long[] a : distance) {
            for (long i : a)
                System.out.print((i == Integer.MAX_VALUE ? 0 : i) + " ");
            System.out.println();
        }
    }
}
