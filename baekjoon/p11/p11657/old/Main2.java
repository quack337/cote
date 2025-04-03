package baekjoon.p11.p11657.old;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    static class Edge {     // 간선
        int weight;         // 가중치
        int vertex;         // 간선의 끝 정점

        public Edge(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    static int N;                   // 정점의 수
    static ArrayList<Edge>[] edges; // 진출간선
    static int[] distance; // 각 정점의 최단경로 거리
    static int[] parent;   // 최단경로에서 각 정점의 부모 정점

    static class Node {
        int vertex, depth;

        public Node(int vertex, int depth) {
            this.vertex = vertex;
            this.depth = depth;
        }
    }

    static void bellmanFord(int start) throws Exception {
        Queue<Node> queue = new ArrayDeque<>(); // 방문할 정점 목록. distance 값이 변경된 정점 목록.
        Arrays.fill(distance, Integer.MAX_VALUE);  // 모든 정점의 distance 값을 무한대로 초기화
        distance[start] = 0;                       // 시작 정점의 distance에 0 대입
        queue.add(new Node(start, 0));             // 방문할 정점 목록에 시작 정점 추가
        while (queue.size() > 0) {
            Node path = queue.remove();            // 방문할 정점 목록에서 선두 정점 꺼내기
            int u = path.vertex, depth = path.depth;
            if (depth >= N) throw new Exception(); // 최단 경로에서 정점의 수가 N 이상이면
                                                   // 그래프에 음수 싸이클 존재
            for (Edge e : edges[u]) {              // 그 정점과 연결된 간선 각각에 대해서
                int v = e.vertex;
                // 그 간선에 연결된 정점 v의 distance 값이
                // 정점 u의 distance + 간선의 가중치 보다 작다면
                if (distance[v] > distance[u]+ e.weight) {
                    distance[v] = distance[u] + e.weight; // v의 distance 값 수정
                    queue.add(new Node(v, depth + 1)); // distance값이 수정된 정점을, 방문할 정점 목록에 추가
                    parent[v] = u;              // 최단 경로 트리에서 v의 부모를 u로 수정
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        edges = new ArrayList[N];
        distance = new int[N];
        parent = new int[N];
        for (int i = 0; i < N; ++i)
            edges[i] = new ArrayList<>();

        int M = Integer.parseInt(tokenizer.nextToken());
        for (int m = 0; m < M; ++m) {
            tokenizer = new StringTokenizer(reader.readLine());
            int A = Integer.parseInt(tokenizer.nextToken()) - 1;
            int B = Integer.parseInt(tokenizer.nextToken()) - 1;
            int C = Integer.parseInt(tokenizer.nextToken());
            edges[A].add(new Edge(C, B));
        }
        try {
            bellmanFord(0);
            for (int i = 1; i < N; ++i)
                System.out.println(distance[i] == Integer.MAX_VALUE ? -1 : distance[i]);
        } catch (Exception e) {
            System.out.println(-1);
        }
    }
}