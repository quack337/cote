package baekjoon.p10.p10217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        Vertex vertex1, vertex2;
        int cost, weight;

        public Edge(Vertex vertex1, int cost, int weight, Vertex vertex2) {
            this.vertex1 = vertex1;
            this.cost = cost;
            this.weight = weight;
            this.vertex2 = vertex2;
        }
    }

    static class Vertex {
        int index;
        ArrayList<Edge> edges = new ArrayList<>();
        int[] distances;              // (가)

        public Vertex(int index, int M) {
            this.index = index;
            distances = new int[M+1]; // (가)
            Arrays.fill(distances, Integer.MAX_VALUE);
        }

        public int getDistance(int cost) {
            return distances[cost];
        }

        public void setDistance(int cost, int distance) {
            distances[cost] = distance;
        }
    }

    static class Node implements Comparable<Node> {
        Vertex vertex;
        int cost, distance;

        public Node(Vertex vertex, int cost, int distance) {
            this.vertex = vertex;
            this.cost = cost;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node n) {
            return distance - n.distance;
        }
    }

    static int dijkstra(Vertex[] V, int start, int end, int M) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(V[start], 0, 0));
        V[start].setDistance(0, 0);
        while (queue.size() > 0) {
            Node node = queue.remove();
            if (node.vertex.index == end) return node.distance;
            for (Edge edge: node.vertex.edges) {
                int cost = node.cost + edge.cost;
                if (cost > M) continue;
                int distance = node.distance + edge.weight;
                if (distance < edge.vertex2.getDistance(cost)) {    // (나)
                    edge.vertex2.setDistance(cost, distance);
                    queue.add(new Node(edge.vertex2, cost, distance));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            Vertex[] V = new Vertex[N];
            for (int i = 0; i < N; ++i)
                V[i] = new Vertex(i, M);
            int K = Integer.parseInt(tokenizer.nextToken());
            for (int k = 0; k < K; ++k) {
                tokenizer = new StringTokenizer(reader.readLine());
                int u = Integer.parseInt(tokenizer.nextToken()) - 1;
                int v = Integer.parseInt(tokenizer.nextToken()) - 1;
                int c = Integer.parseInt(tokenizer.nextToken());
                int d = Integer.parseInt(tokenizer.nextToken());
                V[u].edges.add(new Edge(V[u], c, d, V[v]));
            }
            int distance = dijkstra(V, 0, N-1, M);
            if (distance == Integer.MAX_VALUE) System.out.println("Poor KCM");
            else System.out.println(distance);
        }
    }
}
