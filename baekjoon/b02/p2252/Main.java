package baekjoon.b02.p2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parentCount;
    static ArrayList<Integer>[] children;

    static int 부모가없는정점() {
        for (int i = 0; i < N; ++i)
            if (parentCount[i] == 0) return i;
        return -1;
    }

    static void topologicalSort() {
        for (int i = 0; i < N; ++i) {
            int index = 부모가없는정점();
            parentCount[index] = -1; // 이 노드 제거
            System.out.printf("%d ", index + 1);
            for (int j : children[index])
                --parentCount[j];
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        parentCount = new int[N];
        children = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            children[i] = new ArrayList<Integer>(1);
        for (int i = 0; i < M; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;
            children[a].add(b);
            ++parentCount[b];
        }
        topologicalSort();
        System.out.println();
    }
}