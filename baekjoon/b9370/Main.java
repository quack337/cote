package baekjoon.b9370;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

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
        int index, distance;
        ArrayList<Edge> edges = new ArrayList<>();
        boolean visited = false;

        public Vertex(int index) { this.index = index; }
    }

    static int dijkstra(Vertex[] V, int start, int end) {
        for (Vertex v : V)
            v.visited = false;
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

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int TEST = Integer.parseInt(reader.readLine());
        for (int i1 = 0; i1 < TEST; ++i1) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            int T = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(reader.readLine());
            int S = Integer.parseInt(tokenizer.nextToken()) - 1;
            int G = Integer.parseInt(tokenizer.nextToken()) - 1;
            int H = Integer.parseInt(tokenizer.nextToken()) - 1;
            Vertex[] V = new Vertex[N];
            for (int i = 0; i < N; ++i)
                V[i] = new Vertex(i);
            int GH_weight = 0;
            for (int i = 0; i < M; ++i) {
                tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken()) - 1;
                int b = Integer.parseInt(tokenizer.nextToken()) - 1;
                int d = Integer.parseInt(tokenizer.nextToken());
                if ((a == G && b == H) || (a == H && b == G)) GH_weight = d;
                V[a].edges.add(new Edge(V[a], d, V[b]));
                V[b].edges.add(new Edge(V[b], d, V[a]));
            }
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = 0; i < T; ++i) {
                int 목적지후보 = Integer.parseInt(reader.readLine()) - 1;
                int distance1 = dijkstra(V, S, 목적지후보);
                int distance2 = dijkstra(V, S, G) + GH_weight + dijkstra(V, H, 목적지후보);
                int distance3 = dijkstra(V, S, H) + GH_weight + dijkstra(V, G, 목적지후보);
                if (distance1 == distance2 || distance1 == distance3)
                    result.add(목적지후보);
            }
            Collections.sort(result);
            for (int i : result)
                System.out.print((i+1) + " ");
            System.out.println();
        }
    }
}