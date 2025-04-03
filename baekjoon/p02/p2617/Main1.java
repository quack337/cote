package baekjoon.p02.p2617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main1 {
    static List<Integer>[] parents, children;

    static int DFS1(int index, boolean[] visited) {
        if (visited[index]) return 0;
        visited[index] = true;
        int sum = 0;
        for (int parent : parents[index])
            sum += DFS1(parent, visited);
        return sum + 1;
    }

    static int DFS2(int index, boolean[] visited) {
        if (visited[index]) return 0;
        visited[index] = true;
        int sum = 0;
        for (int child: children[index])
            sum += DFS2(child, visited);
        return sum + 1;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        parents = new ArrayList[N];
        children = new ArrayList[N];
        for (int i = 0; i < N; ++i) {
            parents[i] = new ArrayList<Integer>();
            children[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int p = Integer.parseInt(tokenizer.nextToken()) - 1;
            int c = Integer.parseInt(tokenizer.nextToken()) - 1;
            parents[c].add(p);
            children[p].add(c);
        }
        int count = 0;
        for (int i = 0; i < N; ++i) {
            if (DFS1(i, new boolean[N])-1 > N/2) ++count;
            else if (DFS2(i, new boolean[N])-1 > N/2) ++count;
        }
        System.out.println(count);
    }
}