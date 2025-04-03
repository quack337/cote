package baekjoon.p02.p2213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

@SuppressWarnings("unchecked")
public class Main1 {
    static ArrayList<Integer>[] neighbor;
    static int[] W;

    static int sol(int node, int parent, int selected) {
        int result1 = 0, result2 = (selected == 0 ? W[node] : 0);
        for (int child : neighbor[node]) {
            if (child == parent) continue;
            result1 += sol(child, node, 0);
            if (selected == 0) result2 += sol(child, node, 1);
        }
        return Math.max(result1, result2);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        W = new int[N];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            W[i] = Integer.parseInt(tokenizer.nextToken());
        neighbor = new ArrayList[N];
        for (int i = 0; i < N - 1; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            if (neighbor[a] == null) neighbor[a] = new ArrayList<>();
            if (neighbor[b] == null) neighbor[b] = new ArrayList<>();
            neighbor[a].add(b);
            neighbor[b].add(a);
        }
        int answer = sol(0, -1, 0);
        System.out.println(answer);
    }
}