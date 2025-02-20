package baekjoon.p03.p3640xxxxxxxxxxxx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main4 {
    static class Edge {
        int weight, vertex;

        public Edge(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    static class Node {
        int vertex, distance, parentVertex;
        BitSet visited;

        public Node(int vertex, int distance, int parentVertex) {
            this.vertex = vertex;
            this.distance = distance;
            this.parentVertex = parentVertex;
        }

        public Node(int vertex, int distance, Node previous) {
            this.vertex = vertex;
            this.distance = distance;
            this.visited = previous == null ? new BitSet() : (BitSet)previous.visited.clone();
            this.visited.set(vertex);
        }
    }

    static int dijkstra2(List<Edge>[] edges, int V, BitSet visited) {
        int count = 0;
        visited.set(0, false);
        visited.set(V-1, false);
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        queue.add(new Node(0, 0, -1));
        while (queue.size() > 0) {
            Node node = queue.remove();
            int vertex = node.vertex, distance = node.distance;
            if (vertex == V-1) {
                //System.out.printf("#2 %d\n", distance);
                if (node.parentVertex == 0 && ++count == 1) continue;
                return distance;
            }
            if (visited.get(vertex)) continue;
            visited.set(vertex, true);
            for (Edge edge : edges[vertex])
                if (visited.get(edge.vertex) == false)
                    queue.add(new Node(edge.vertex, distance + edge.weight, vertex));
        }
        return -1;
    }

    static int dijkstra1(List<Edge>[] edges, int V) {
        int result = Integer.MAX_VALUE;
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        queue.add(new Node(0, 0, null));
        while (queue.size() > 0) {
            Node node = queue.remove();
            int vertex = node.vertex, distance = node.distance;
            if (distance >= result) continue;
            if (vertex == V-1) {
                //System.out.printf("#1 %d\n", distance);
                int distance2 = dijkstra2(edges, V, (BitSet)node.visited.clone());
                if (distance2 < 0) continue;
                result = Math.min(result, distance + distance2);
            }
            for (Edge edge : edges[vertex])
                queue.add(new Node(edge.vertex, distance + edge.weight, node));
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if (s == null) break;
            StringTokenizer tokenizer = new StringTokenizer(s);
            int V = Integer.parseInt(tokenizer.nextToken());
            int E = Integer.parseInt(tokenizer.nextToken());
            List<Edge>[] edges = new ArrayList[V];
            for (int i = 0; i < V; ++i)
                edges[i] = new ArrayList<Edge>();
            for (int i = 0; i < E; ++i) {
                tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken()) - 1;
                int b = Integer.parseInt(tokenizer.nextToken()) - 1;
                int c = Integer.parseInt(tokenizer.nextToken());
                edges[a].add(new Edge(c, b));
            }
            System.out.println(dijkstra1(edges, V));
        }
    }
}
