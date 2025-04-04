package baekjoon.b02.p2316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, P;
    static int[][] edge0, edge;
    static int[] parents;
    static boolean[] visited;

    static boolean BFS(int start, int end) {
        Arrays.fill(parents, -1);
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] {start, -1});
        while (queue.size() > 0) {
            int[] p = queue.remove();
            int node = p[0], parent = p[1];
            if (visited[node] && node != start && node != end) continue;
            visited[node] = true;
            if (parents[node] != -1) continue;
            parents[node] = parent;
            if (node == end) return true;
            for (int child = 0; child < N; ++child)
                if (edge[node][child] > 0 && child != parent)
                    queue.add(new int[] {child, node});
        }
        return false;
    }

    static int sol(int start, int end) {
        int answer = 0;
        for (int i = 0; i < edge.length; ++i)
            System.arraycopy(edge0[i], 0, edge[i], 0, edge[i].length);
        while (BFS(start, end)) {
            ++answer;
            for (int node = end; node != start; node = parents[node]) {
                edge[parents[node]][node] = 0;
                edge[node][parents[node]] = 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        P = Integer.parseInt(tokenizer.nextToken());
        edge = new int[N * 2][N * 2];
        parents = new int[N];  visited = new boolean[N];
        for (int i = 0; i < P; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            edge0[a * 2][a * 2 + 1] = 1;
            edge0[a * 2 + 1][b * 2] = 1;
            edge0[b * 2][b * 2 + 1] = 1;

            edge0[b * 2 + 1][b * 2] = 1;
            edge0[b * 2][a * 2 + 1] = 1;
            edge0[a * 2 + 1][a * 2] = 1;
        }
        System.out.println(Math.min(sol(0, 1), sol(1, 0)));
    }
}