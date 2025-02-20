package baekjoon.p11.p11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] 이웃;
    static boolean[] visited;

    static void DFS(int i) {
        visited[i] = true;
        for (int c : 이웃[i])
            if (visited[c] == false)
                DFS(c);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        이웃 = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            이웃[i] = new ArrayList<Integer>();
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            이웃[a].add(b);
            이웃[b].add(a);
        }
        visited = new boolean[N];
        int count = 0;
        for (int i = 0; i < N; ++i)
            if (visited[i] == false) {
                ++count;
                DFS(i);
            }
        System.out.println(count);
    }
}
