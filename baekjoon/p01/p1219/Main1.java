package baekjoon.p01.p1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1 {
    static class Vertex {
        ArrayList<Edge> edges = new ArrayList<>();
        int money, distance = Integer.MAX_VALUE, updateCount = 0;
    }

    static class Edge {
        Vertex vertex1, vertex2;
        int weight;

        public Edge(Vertex vertex1, int weight, Vertex vertex2) {
            this.vertex1 = vertex1;
            this.weight = weight;
            this.vertex2 = vertex2;
        }
    }

    static String bellmanFord(Vertex[] V, int start, int end)  {
        Queue<Vertex> queue = new ArrayDeque<>();
        V[start].distance = 0;
        queue.add(V[start]);
        while (queue.size() > 0) {
            Vertex v = queue.remove();
            if (v.updateCount >= V.length && v == V[end]) return "Gee";
            for (Edge e : v.edges) {
                if (e.vertex2.distance > e.vertex1.distance + e.weight) {
                    e.vertex2.distance = e.vertex1.distance + e.weight;
                    e.vertex2.updateCount++;
                    queue.add(e.vertex2);
                }
            }
        }
        if (V[end].distance == Integer.MAX_VALUE) return "gg";
        return String.valueOf(V[end].money - V[end].distance);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int 시작 = Integer.parseInt(tokenizer.nextToken());
        int 도착 = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        Vertex[] V = new Vertex[N];
        for (int i = 0; i < N; ++i)
            V[i] = new Vertex();
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            V[a].edges.add(new Edge(V[a], c, V[b]));
        }
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i) {
            int m = Integer.parseInt(tokenizer.nextToken());
            V[i].money = m;
            for (Edge edge : V[i].edges)
                edge.weight -= m;
        }
        System.out.println(bellmanFord(V, 시작, 도착));
    }
}