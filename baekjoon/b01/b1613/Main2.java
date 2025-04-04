package baekjoon.b01.b1613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
    static ArrayList<Integer>[] A;

    static boolean DFS(int index, int end, boolean[] visited) {
        if (index == end) return true;
        if (visited[index]) return false;
        visited[index] = true;
        for (int child : A[index])
            if (DFS(child, end, visited)) return true;
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        A = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            A[i] = new ArrayList<Integer>();
        for (int k = 0; k < K; ++k) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            A[a].add(b);
        }
        int S = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int s = 0; s < S; ++s) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (DFS(a, b, new boolean[N])) builder.append(-1).append('\n');
            else if (DFS(b, a, new boolean[N])) builder.append(1).append('\n');
            else builder.append(0).append('\n');
        }
        System.out.println(builder.toString());
    }
}