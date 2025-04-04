package baekjoon.b11.p11779;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1 {
    static final long INF = 1_000_000_000_000_000L;
    static int N, M, start, goal;
    static long[][] edges;
    static long[] distances;
    static ArrayDeque<Integer> path = new ArrayDeque<>();

    static void dijkstra() {
        var queue = new PriorityQueue<long[]>((a, b) -> (int)(a[1] - b[1]));
        queue.add(new long[] {start, 0});
        while (queue.size() > 0) {
            long[] a = queue.remove();
            int node = (int)a[0]; long distance = a[1];
            if (distances[node] <= distance) continue;
            distances[node] = distance;
            if (node == goal) return;
            for (int child = 1; child <= N; ++child) {
                long weight = edges[node][child];
                if (weight >= INF) continue;
                queue.add(new long[] { child, distance + weight });
            }
        }
    }

    static void DFS(int node, long distance) {
        path.addFirst(node);
        if (node == start) return;
        for (int parent = 1; parent <= N; ++parent) {
            long weight = edges[parent][node];
            if (distances[parent] + weight + distance == distances[goal]) {
                DFS(parent, distance + weight);
                return;
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        M = Integer.parseInt(reader.readLine());
        distances = new long[N + 1];
        Arrays.fill(distances, INF);
        edges = new long[N+1][N+1];
        for (int i = 1; i <= N; ++i)
            Arrays.fill(edges[i], INF);
        for (int i = 0; i < M; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            edges[a][b] = c;
        }
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        start = Integer.parseInt(tokenizer.nextToken());
        goal = Integer.parseInt(tokenizer.nextToken());
        dijkstra();
        DFS(goal, 0);
        var builder = new StringBuilder();
        builder.append(distances[goal] + "\n");
        builder.append(path.size() + "\n");
        for (int i : path) builder.append(i + " ");
        builder.deleteCharAt(builder.lastIndexOf(" "));
        System.out.println(builder.toString());
    }
}