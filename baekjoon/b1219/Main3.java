package baekjoon.b1219;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

    static class Vertex {
        long distance, money;

        public Vertex(long distance, long money) {
            this.distance = distance;
            this.money = money;
        }
    }

    static class Edge {
        int vertex1, vertex2, weight;

        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }
    }

    static boolean findPath(Edge[] E, int start, int end, boolean[] visited) {
        if (start == end) return true;
        if (visited[start]) return false;
        visited[start] = true;
        for (Edge e : E)
            if (e.vertex1 == start && visited[e.vertex2] == false)
                if (findPath(E, e.vertex2, end, visited)) return true;
        return false;
    }

    static String bellmanFord(Vertex[] V, Edge[] E, int start, int end) {
        // 밸만 포드 알고리즘
        V[start].distance = 0;
        for (int i = 1; i < V.length; ++i)
            for (Edge e : E)
                if (V[e.vertex2].distance > V[e.vertex1].distance + e.weight)
                    V[e.vertex2].distance = V[e.vertex1].distance + e.weight;

        // 음수 사이클 찾기
        for (Edge e : E)
            if (V[e.vertex2].distance > V[e.vertex1].distance + e.weight) { // 음수 사이클 발견
                V[e.vertex2].distance = V[e.vertex1].distance + e.weight;
                if (findPath(E, e.vertex2, end, new boolean[V.length]))
                    return "Gee"; // 음수 사이클에서 목적지까지 갈 수 있다면, Gee
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
        Edge[] E = new Edge[M];
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());
            E[i] = new Edge(a, b, c);
        }
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i) {
            long money = Integer.parseInt(tokenizer.nextToken());
            V[i] = new Vertex(Integer.MAX_VALUE, money);
            if (money != 0)
                for (Edge e : E)
                    if (e.vertex1 == i) e.weight -= money;
        }
        System.out.println(bellmanFord(V, E, 시작, 도착));
    }
}