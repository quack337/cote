package baekjoon.p01.p1753;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        int start = scanner.nextInt() - 1;
        ArrayList<int[]>[] edges = new ArrayList[V];
        for (int i = 0; i < V; ++i)
            edges[i] = new ArrayList<int[]>();
        for (int i = 0; i < E; ++i) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int w = scanner.nextInt();
            edges[a].add(new int[] {b, w});
        }
        scanner.close();
        var visited = new boolean[V];
        var distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        queue.add(new int[] {start, 0});
        while (queue.size() > 0) {
            int[] current = queue.remove();
            int a = current[0], distance = current[1];
            if (distances[a] > distance) distances[a] = distance;
            if (visited[a]) continue;
            visited[a] = true;
            for (int[] edge : edges[a]) {
                int b = edge[0], w = edge[1];
                if (visited[b] == false)
                    queue.add(new int[] {b, distance + w});
            }
        }
        for (int d : distances)
            System.out.println(d == Integer.MAX_VALUE ? "INF" : d);
    }
}