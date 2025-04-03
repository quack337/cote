package baekjoon.p02.p2211;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int vertex1, weight, vertex2;

        public Edge(int vertex1, int weight, int vertex2) {
            this.vertex1 = vertex1;
            this.weight = weight;
            this.vertex2 = vertex2;
        }
    }

    static class Node {
        Edge edge;
        int distance;

        public Node(Edge edge, int distance) {
            this.edge = edge;
            this.distance = distance;
        }
    }

    static void dijkstra(List<Edge>[] edges, List<Edge> selected) {
        boolean[] visited = new boolean[edges.length];
        PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.distance - n2.distance);
        queue.add(new Node(new Edge(-1, 0, 0), 0)); // 시작 정점을 가르키는 더미 간선(Edge) 생성
        while (queue.size() > 0) {
            Node current = queue.remove();
            int v = current.edge.vertex2, distance = current.distance;
            if (visited[v]) continue;
            visited[v] = true;
            if (current.edge.vertex1 != -1) // 현재 간선이 더미 간선이 아니라면
                selected.add(current.edge); // 이 간선을 최단 경로 트리에 추가
            for (Edge edge : edges[v])
                if (visited[edge.vertex2] == false)
                    queue.add(new Node(edge, distance + edge.weight));
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        List<Edge>[] edges = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            edges[i] = new ArrayList<Edge>();
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken());
            edges[a].add(new Edge(a, c, b));
            edges[b].add(new Edge(b, c, a));
        }
        List<Edge> selectedEdges = new ArrayList<>();
        dijkstra(edges, selectedEdges);
        StringBuilder builder = new StringBuilder();
        builder.append(selectedEdges.size()).append('\n');
        for (Edge edge : selectedEdges)
            builder.append(edge.vertex1+1).append(' ').append(edge.vertex2+1).append('\n');
        System.out.println(builder.toString());
    }
}