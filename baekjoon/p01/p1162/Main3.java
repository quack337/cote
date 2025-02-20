package baekjoon.p01.p1162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main3 {
    static int N, M, K;
    static ArrayList<int[]>[] edges;
    static long[] distances;


    static void dijkstra() {
        boolean[][] visited = new boolean[N][K+1];
        var queue = new PriorityQueue<long[]>((a, b) -> (int)(a[2] - b[2]));
        queue.add(new long[] { 0, 0, 0 });
        while (queue.size() > 0) {
            long[] p = queue.remove();
            int node = (int)p[0], k = (int)p[1];
            long distance = p[2];
            if (visited[node][k]) continue;
            visited[node][k] = true;
            if (distance > distances[N-1]) continue;
            if (distance < distances[node]) distances[node] = distance;
            for (var edge : edges[node]) {
                int neighbor = edge[0], cost = edge[1];
                queue.add(new long[] { neighbor, k, distance + cost });
                if (k < K) queue.add(new long[] { neighbor, k + 1, distance });
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        distances = new long[N];
        Arrays.fill(distances, Long.MAX_VALUE);
        edges = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            edges[i] = new ArrayList<>(8);
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int w = Integer.parseInt(tokenizer.nextToken());
            edges[a].add(new int[] { b, w });
            edges[b].add(new int[] { a, w });
        }
        dijkstra();
        System.out.println(distances[N-1]);
    }
}