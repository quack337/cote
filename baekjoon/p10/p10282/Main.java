package baekjoon.p10.p10282;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
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

    static void dijkstra(List<Edge>[] edges, int start, Writer writer) throws IOException {
        int count = 0, maxDistance = 0;
        boolean[] visited = new boolean[edges.length];
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        queue.add(new Node(start, 0));
        while (queue.size() > 0) {
            Node current = queue.remove();
            int v = current.vertex, distance = current.distance;
            if (visited[v]) continue;
            visited[v] = true;
            ++count;                 // 감연된 컴퓨터 수
            maxDistance = distance;  // 마지막에 대입된 값이 distance 최대값
            for (Edge edge : edges[v])
                if (visited[edge.vertex] == false)
                    queue.add(new Node(edge.vertex, distance + edge.weight));
        }
        writer.write(count + " " + maxDistance + "\n");
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int D = Integer.parseInt(tokenizer.nextToken());
            int C = Integer.parseInt(tokenizer.nextToken()) - 1;
            List<Edge>[] edges = new ArrayList[N];
            for (int i = 0; i < N; ++i)
                edges[i] = new ArrayList<Edge>();
            for (int i = 0; i < D; ++i) {
                tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken()) - 1;
                int b = Integer.parseInt(tokenizer.nextToken()) - 1;
                int s = Integer.parseInt(tokenizer.nextToken());
                edges[b].add(new Edge(s, a));
            }
            dijkstra(edges, C, writer);
        }
        writer.close();;
    }
}