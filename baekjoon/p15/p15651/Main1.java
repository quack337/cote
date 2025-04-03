package baekjoon.p15.p15651;

// 시간 초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main1 {
    static int N, M;

    static void DFS(ArrayDeque<Integer> result) {
        if (result.size() == M) {
            for (int i : result) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; ++i) {
            result.add(i);
            DFS(result);
            result.removeLast();
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        DFS(new ArrayDeque<Integer>());
    }
}