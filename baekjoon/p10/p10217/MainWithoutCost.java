package baekjoon.p10.p10217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MainWithoutCost {

    static class Edge implements Comparable<Edge> {
        Vertex vertex1, vertex2;
        int weight;

        public Edge(Vertex vertex1, int weight, Vertex vertex2) {
            this.vertex1 = vertex1;
            this.weight = weight;
            this.vertex2 = vertex2;
        }

        private int distance() {
            return vertex1.distance + weight;
        }

        @Override
        public int compareTo(Edge e) {
            return distance() - e.distance();
        }
    }

    static class Vertex {
        int index;
        int distance;
        ArrayList<Edge> edges = new ArrayList<>();
        boolean visited = false;

        public Vertex(int index) { this.index = index; }
    }

    static int dijkstra(Vertex[] V, int start, int end) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        V[start].distance = 0;
        queue.add(new Edge(new Vertex(-1), 0, V[start]));
        while (queue.size() > 0) {
            Edge currentEdge = queue.remove();
            if (currentEdge.vertex2.visited) continue;
            if (currentEdge.vertex2.index == end) return currentEdge.distance();
            currentEdge.vertex2.visited = true;
            currentEdge.vertex2.distance = currentEdge.distance();
            for (Edge edge: currentEdge.vertex2.edges)
                if (edge.vertex2.visited == false)
                    queue.add(edge);
        }
        return Integer.MAX_VALUE;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            Vertex[] V = new Vertex[N];
            for (int i = 0; i < N; ++i)
                V[i] = new Vertex(i);
            int K = Integer.parseInt(tokenizer.nextToken());
            for (int k = 0; k < K; ++k) {
                tokenizer = new StringTokenizer(reader.readLine());
                int u = Integer.parseInt(tokenizer.nextToken()) - 1;
                int v = Integer.parseInt(tokenizer.nextToken()) - 1;
                int c = Integer.parseInt(tokenizer.nextToken());
                int d = Integer.parseInt(tokenizer.nextToken());
                V[u].edges.add(new Edge(V[u], d, V[v]));
            }
            int distance = dijkstra(V, 0, N-1);
            if (distance == Integer.MAX_VALUE) System.out.println("Poor KCM");
            else System.out.println(distance);
        }
    }
}