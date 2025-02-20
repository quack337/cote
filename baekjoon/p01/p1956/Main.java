package baekjoon.p01.p1956;

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

    static void floydWarshall(int[][] distance, int n) {
        for (int k = 0; k < n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j)
                    distance[i][j] = Math.min(distance[i][j], add(distance[i][k], distance[k][j]));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int V = Integer.parseInt(tokenizer.nextToken());
        int E = Integer.parseInt(tokenizer.nextToken());
        int[][] distance = new int[V][V];
        for (int i = 0; i < V; ++i)
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        for (int i = 0; i < E; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken());
            distance[a][b] = Math.min(c, distance[a][b]);;
        }

        floydWarshall(distance, V);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < V; ++i)
            if (distance[i][i] < min) min = distance[i][i];
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
