package baekjoon.b1219;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

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

    static long add(long a, long b) {
        if (a == Integer.MAX_VALUE || b == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return a + b;
    }

    static String bellmanFord(Vertex[] V, Edge[] E, int start, int end) {
        // 밸만 포드 알고리즘
        V[start].distance = 0;
        for (int i = 1; i < V.length; ++i)
            for (Edge e : E)
                if (V[e.vertex2].distance > add(V[e.vertex1].distance, e.weight))
                    V[e.vertex2].distance = add(V[e.vertex1].distance, e.weight);

        // 음수 사이클 찾기
        for (Edge e : E)
            if (V[e.vertex2].distance > add(V[e.vertex1].distance, e.weight)) { // 음수 사이클 발견
                V[e.vertex2].distance = add(V[e.vertex1].distance, e.weight);
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


/*
버그#1
3 0 2 4
0 1 9999
1 2 9999
1 1 9999
0 2 0
10000 10000 10000

Gee
버그 해결함
음수 사이클이 있는데, 당장 V[end] 값이 변경되지 않는 상황.
음수 사이클에서 목적지까지 경로가 있는지 확인해야 함.


버그#2
무한대 덧셈.
4 0 2 4
0 1 10
1 0 10
2 1 10
3 2 10
1000 1000 47000 100
gg 나와야 함.


*/