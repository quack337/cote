package baekjoon.b11.p11780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static int N, M;
    static long INF = 1_000_000_000_000L;
    static long[][] edges;
    static long[][] distances;
    static StringBuilder builder = new StringBuilder();
    static ArrayList<Integer> path = new ArrayList<>();

    static void DFS(int from, int to) {
        path.add(from + 1);
        if (from == to) return;
        for (int node = 0; node < N; ++node)
            if (edges[from][node] + distances[node][to] == distances[from][to]) {
                DFS(node, to);
                return;
            }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        edges = new long[N][N];
        distances = new long[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(distances[i], INF);
            Arrays.fill(edges[i], INF);
            distances[i][i] = 0;
        }
        for (int i = 0; i < M; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken());
            if (c < distances[a][b]) distances[a][b] = c;
            if (c < edges[a][b]) edges[a][b] = c;
        }
        for (int c = 0; c < N; ++c)
            for (int a = 0; a < N; ++a)
                for (int b = 0; b < N; ++b)
                    if (distances[a][b] > distances[a][c] + distances[c][b])
                        distances[a][b] = distances[a][c] + distances[c][b];
        for (int a = 0; a < N; ++a) {
            for (int b = 0; b < N; ++b)
                builder.append((distances[a][b] == INF ? 0 : distances[a][b]) + " ");
            builder.append("\n");
        }
        for (int a = 0; a < N; ++a)
            for (int b = 0; b < N; ++b)
                if (a == b || distances[a][b] == INF)
                    builder.append("0\n");
                else {
                    path.clear();
                    DFS(a, b);
                    builder.append(path.size() + " ");
                    for (int node : path) builder.append(node + " ");
                    builder.append("\n");
                }
        System.out.println(builder.toString());
    }
}