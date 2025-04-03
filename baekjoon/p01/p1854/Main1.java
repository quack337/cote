package baekjoon.p01.p1854;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1 {
    static final int INDEX = 0, DISTANCE = 1;
    static ArrayList<int[]>[] edges;

    static int dijkstra(int start, int goal) {
        var visited = new boolean[edges.length];
        var queue = new PriorityQueue<int[]>((a, b) -> a[DISTANCE] - b[DISTANCE]);
        queue.add(new int[] {start, 0});
        while (queue.size() > 0) {
            int[] current = queue.remove();
            if (visited[current[INDEX]]) continue;
            visited[current[INDEX]] = true;
            if (current[INDEX] == goal) return current[DISTANCE];
            if (edges[current[INDEX]] == null) continue;
            for (int[] edge : edges[current[INDEX]])
                queue.add(new int[] { edge[INDEX], edge[DISTANCE] + current[DISTANCE] });
        }
        return -1;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        edges = new ArrayList[N+1];
        for (int m = 0; m < M; ++m) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            if (edges[a] == null) edges[a] = new ArrayList<int[]>();
            edges[a].add(new int[] {b, c});
        }
        for (int goal = 1; goal <= N; ++goal)
            System.out.println(dijkstra(1, goal));
    }

}