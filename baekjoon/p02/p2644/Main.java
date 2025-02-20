package baekjoon.p02.p2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] edges;

    static class Node {
        int vertex, distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    static int BFS(int start, int end) {
        boolean[] visited = new boolean[N];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, 0));
        while (queue.size() > 0) {
            Node node = queue.remove();
            if (node.vertex == end) return node.distance;
            if (visited[node.vertex]) continue;
            visited[node.vertex] = true;
            for (int child : edges[node.vertex])
                if (visited[child] == false)
                    queue.add(new Node(child, node.distance + 1));
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        edges = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            edges[i] = new ArrayList<Integer>();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(tokenizer.nextToken()) - 1;
        int end = Integer.parseInt(tokenizer.nextToken()) - 1;
        int M = Integer.parseInt(reader.readLine());
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            edges[a].add(b);
            edges[b].add(a);
        }
        System.out.println(BFS(start, end));
    }
}
