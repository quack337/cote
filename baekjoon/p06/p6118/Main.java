package baekjoon.p06.p6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int vertex, distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    static int BFS(List<Integer>[] edges, int[] distances) {
        Arrays.fill(distances, -1);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0));
        int maxDistance = 0; // 가장 먼 정점까지의 거리
        while (queue.size() > 0) {
            Node current = queue.remove();
            int vertex = current.vertex, distance = current.distance;
            if (distances[vertex] != -1) continue;
            distances[vertex] = distance; // 시작정점에서 vertex 정점까지 최단거리
            maxDistance = distance;
            for (int u : edges[vertex])
                if (distances[u] == -1)
                    queue.add(new Node(u, distance + 1));
        }
        return maxDistance;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        List<Integer>[] edges = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            edges[i] = new ArrayList<Integer>();
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            edges[a].add(b);
            edges[b].add(a);
        }
        int[] distances = new int[N];
        int maxDistance = BFS(edges, distances);
        int count = 0, vertex = 0;
        for (int i = 1; i < N; ++i)
            if (distances[i] == maxDistance) {
                if (count == 0) vertex = i+1;
                ++count;
            }
        System.out.println(vertex + " " + maxDistance + " " + count);
    }
}