package baekjoon.p13.p13244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] nodes;
    static boolean[] visited;

    static void DFS(int i) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j : nodes[i])
            DFS(j);
    }

    static boolean allNodesVisited() {
        for (boolean v : visited)
            if (!v) return false;
        return true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(reader.readLine());
            nodes = new ArrayList[N];
            visited = new boolean[N];
            for (int i = 0; i < N; ++i)
                nodes[i] = new ArrayList<Integer>();
            int M = Integer.parseInt(reader.readLine());
            for (int i = 0; i < M; ++i) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int a = Integer.parseInt(tokenizer.nextToken()) - 1;
                int b = Integer.parseInt(tokenizer.nextToken()) - 1;
                nodes[a].add(b);
                nodes[b].add(a);
            }
            if (M != N-1)
                System.out.println("graph");
            else {
                DFS(0);
                if (allNodesVisited()) System.out.println("tree");
                else System.out.println("graph");
            }
        }
    }
}