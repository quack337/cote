package baekjoon.b1719;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1 {
    static int N, M;

    static class Edge {
        int weight, vertex;

        public Edge(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    static class Node {
        int vertex, distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    static int[] BFS(List<Edge>[] edges, int start) {
        int[] result = new int[N];
        boolean[] visited = new boolean[N];
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        queue.add(new Node(start, 0));
        while (queue.size() > 0) {
            Node node = queue.remove();
            int vertex = node.vertex, distance = node.distance;
            if (visited[vertex]) continue;
            visited[vertex] = true;
            result[vertex] = distance;
            for (Edge edge : edges[vertex])
                if (visited[edge.vertex] == false)
                    queue.add(new Node(edge.vertex, distance + edge.weight));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        List<Edge>[] edges = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            edges[i] = new ArrayList<Edge>();
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int w = Integer.parseInt(tokenizer.nextToken());
            edges[a].add(new Edge(w, b));
            edges[b].add(new Edge(w, a));
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            int[] result = BFS(edges, i);
            for (int j = 0; j < N; ++j)
                builder.append(i == j ? "-" : result[j]).append(' ');
            builder.append('\n');
        }
        System.out.println(builder.toString());
    }
}