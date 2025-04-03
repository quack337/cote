package baekjoon.p01.p1325;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    static List<Integer>[] 링크;
    static boolean[] 방문한노드;
    static int[] 신뢰수;
    static int N, M;

    static int DFS(int node) {
        방문한노드[node] = true;
        if (링크[node] == null) return 1;
        int 노드수 = 1;
        int size = 링크[node].size();
        for (int i = 0; i < size; ++i) {
            int c = 링크[node].get(i);
            if (방문한노드[c]) continue;
            노드수 += DFS(c);
        }
        return 노드수;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            링크 = new ArrayList[N];
            신뢰수 = new int[N];
            방문한노드 = new boolean[N];
            for (int i = 0; i < M; ++i) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                if (링크[b] == null) 링크[b] = new ArrayList<>();
                링크[b].add(a);
            }

            int 최대값 = 0;
            for (int i = 0; i < N; ++i) {
                Arrays.fill(방문한노드, false);
                신뢰수[i] = DFS(i);
                if (신뢰수[i] > 최대값) 최대값 = 신뢰수[i];
            }
            for (int i = 0; i < N; ++i)
                if (신뢰수[i] == 최대값) System.out.printf("%d ", i + 1);
            System.out.println();
        }
    }
}