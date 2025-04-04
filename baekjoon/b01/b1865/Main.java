package baekjoon.b01.b1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] distance;

    static void initDistance() {
        distance = new int[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            distance[i][i] = 0;
        }
    }

    static int add(int a, int b) {
        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return a + b;
    }

    static void floydWarshall() {
        for (int k = 0; k < N; ++k)
            for (int i = 0; i < N; ++i)
                for (int j = 0; j < N; ++j)
                    distance[i][j] = Math.min(distance[i][j], add(distance[i][k], distance[k][j]));
    }

    static boolean check() {
        for (int i = 0; i < N; ++i)
            if (distance[i][i] < 0) return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(reader.readLine());
        for (int t = 0; t < TC; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            int W = Integer.parseInt(tokenizer.nextToken());
            initDistance();
            for (int m = 0; m < M; ++m) {
                tokenizer = new StringTokenizer(reader.readLine());
                int S = Integer.parseInt(tokenizer.nextToken()) - 1;
                int E = Integer.parseInt(tokenizer.nextToken()) - 1;
                int T = Integer.parseInt(tokenizer.nextToken());
                distance[S][E] = Math.min(distance[S][E], T);
                distance[E][S] = Math.min(distance[E][S], T);
            }
            for (int w = 0; w < W; ++w) {
                tokenizer = new StringTokenizer(reader.readLine());
                int S = Integer.parseInt(tokenizer.nextToken()) - 1;
                int E = Integer.parseInt(tokenizer.nextToken()) - 1;
                int T = Integer.parseInt(tokenizer.nextToken());
                distance[S][E] = Math.min(distance[S][E], -T);
            }
            System.out.println(Arrays.deepToString(distance));

            floydWarshall();

            System.out.println(Arrays.deepToString(distance));


            System.out.println(check() ? "YES" : "NO");
        }
    }
}