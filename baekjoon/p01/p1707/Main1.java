package baekjoon.p01.p1707;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1 {

    static class Node {
        int vertex, sign;

        public Node(int vertex, int sign) {
            this.vertex = vertex;
            this.sign = sign;
        }
    }

    static int V, E;
    static ArrayList<Integer>[] edges;

    static boolean BFS(int start) {
        boolean[] visited = new boolean[V];
        int[] bipartite = new int[V];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(start, +1));
        while (queue.size() > 0) {
            Node node = queue.remove();
            int vertex = node.vertex, sign = node.sign;
            if (bipartite[vertex] != 0 && bipartite[vertex] != sign) return false;
            if (visited[vertex]) continue;
            visited[vertex] = true;
            bipartite[vertex] = sign;
            for (int child : edges[node.vertex]) {
                if (bipartite[child] != 0 && bipartite[child] != -sign) return false;
                queue.add(new Node(child, -sign));
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int test = 0; test < T; ++test) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            V = Integer.parseInt(tokenizer.nextToken());
            E = Integer.parseInt(tokenizer.nextToken());
            edges = new ArrayList[V];
            for (int i = 0; i < V; ++i)
                edges[i] = new ArrayList<Integer>();
            for (int i = 0; i < E; ++i) {
                tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken()) - 1;
                int b = Integer.parseInt(tokenizer.nextToken()) - 1;
                if (a == b) continue;
                edges[a].add(b);
                edges[b].add(a);
            }
            System.out.println(BFS(0) ? "YES" : "NO");
        }
    }
}