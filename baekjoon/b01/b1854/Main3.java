package baekjoon.b01.b1854;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main3 {
    static final int INDEX = 0, DISTANCE = 1;
    static ArrayList<int[]>[] edges;

    static void dijkstra(int start, int K) {
        var count = new int[edges.length];
        var distance = new int[edges.length];
        Arrays.fill(distance, -1);
        var queue = new PriorityQueue<int[]>((a, b) -> a[DISTANCE] - b[DISTANCE]);
        queue.add(new int[] {start, 0});
        while (queue.size() > 0) {
            int[] current = queue.remove();
            if (count[current[INDEX]] == K) continue;
            distance[current[INDEX]] = current[DISTANCE];
            count[current[INDEX]]++;
            if (edges[current[INDEX]] == null) continue;
            for (int[] edge : edges[current[INDEX]])
                queue.add(new int[] { edge[INDEX], edge[DISTANCE] + current[DISTANCE] });
        }
        for (int i = 1; i < edges.length; ++i)
            System.out.println(count[i] == K ? distance[i] : -1);
    }

    @SuppressWarnings("unchecked")
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
        dijkstra(1, K);
    }

}