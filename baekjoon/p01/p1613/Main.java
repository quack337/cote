package baekjoon.p01.p1613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] A;
    static boolean[][] B;

    static void DFS2(int index, int parent) {
        if (B[index] == null) {
            B[index] = new boolean[N];
            for (int child : A[index]) {
                B[index][child] = true;
                DFS2(child, index);
            }
        }
        if (parent < 0) return;
        B[parent][index] = true;
        for (int i = 0; i < N; ++i)
            if (B[index][i]) B[parent][i] = true;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
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
        B = new boolean[N][];
        for (int i = 0; i < N; ++i)
            if (B[i] == null) DFS2(i, -1);
        int S = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int s = 0; s < S; ++s) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (B[a][b]) builder.append(-1).append('\n');
            else if (B[b][a]) builder.append(1).append('\n');
            else builder.append(0).append('\n');
        }
        System.out.println(builder.toString());
    }
}
