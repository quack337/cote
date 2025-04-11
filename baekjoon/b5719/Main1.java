package baekjoon.b5719;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1 {
    static int N, S, D;
    static int[][] edges;
    static int[] distances;
    static final int INF = 1_000_000_000;

    static void dijkstra(int start) {
        distances = new int[N];
        Arrays.fill(distances, INF);
        var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        queue.add(new int[] { start, 0 });
        while (queue.size() > 0) {
            int[] a = queue.remove();
            int node = a[0], distance = a[1];
            if (distances[node] < INF) continue;
            if (distance > distances[D]) return;
            distances[node] = distance;
            for (int child = 0; child < N; ++child) {
                if (distances[child] < INF) continue;
                int weight = edges[node][child];
                if (weight == INF) continue;
                queue.add(new int[] { child, distance + weight });
            }
        }
    }

    static void DFS(int node, int distance) {
        if (node == S) return;
        for (int parent = 0; parent < N; ++parent) {
            int weight = edges[parent][node];
            if (weight == INF) continue;
            if (distance + weight + distances[parent] == distances[D]) {
                edges[parent][node] = INF;
                DFS(parent, distance + weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        var builder = new StringBuilder();
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            if (N + M == 0) break;
            tokenizer = new StringTokenizer(reader.readLine());
            S = Integer.parseInt(tokenizer.nextToken());
            D = Integer.parseInt(tokenizer.nextToken());
            edges = new int[N][N];
            for (int i = 0; i < N; ++i)
                Arrays.fill(edges[i], INF);
            for (int i = 0; i < M; ++i) {
                tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                int c = Integer.parseInt(tokenizer.nextToken());
                edges[a][b] = c;
            }
            dijkstra(S);
            DFS(D, 0);
            dijkstra(S);
            if (distances[D] == INF) distances[D] = -1;
            builder.append(distances[D] + "\n");
        }
        System.out.println(builder.toString());
    }
}