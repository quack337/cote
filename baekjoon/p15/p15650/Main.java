package baekjoon.p15.p15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static void DFS(int n, ArrayDeque<Integer> result) {
        if (result.size() == M) {
            for (int i : result) System.out.print(i + " ");
            System.out.println();
            return;
        }
        result.add(n);
        DFS(n + 1, result); // i를 선택하고 재귀호출
        result.removeLast();

        if (N - n >= M - result.size()) // i를 선택안해도 되면
            DFS(n + 1, result);         // 선택 안하고 재귀호출
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        DFS(1, new ArrayDeque<Integer>());
    }
}