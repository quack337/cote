package baekjoon.b1916;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public interface Main {
    static class Edge {
        int weight, vertex;

        public Edge(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    static class Node {
        int vertex, distance;

        public Node(int vertex, int distnace) {
            this.vertex = vertex;
            this.distance = distnace;
        }
    }

    static int dijkstra(List<Edge>[] edges, int start, int goal) {
        boolean[] visited = new boolean[edges.length];
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        queue.add(new Node(start, 0));
        while (queue.size() > 0) {
            Node node = queue.remove();
            int v = node.vertex, distance = node.distance;
            if (v == goal) return distance;
            if (visited[v]) continue;
            visited[v] = true;
            for (Edge edge : edges[v])
                if (visited[edge.vertex] == false)
                    queue.add(new Node(edge.vertex, distance + edge.weight));
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());
        List<Edge>[] edges = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            edges[i] = new ArrayList<Edge>();
        for (int i = 0; i < M; ++i) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int w = Integer.parseInt(tokenizer.nextToken());
            edges[a].add(new Edge(w, b));
        }
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int start = Integer.parseInt(tokenizer.nextToken()) - 1;
        int goal = Integer.parseInt(tokenizer.nextToken()) - 1;
        System.out.println(dijkstra(edges, start, goal));
    }
}