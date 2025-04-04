package baekjoon.b04.p4803;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] edges;
    static boolean[] visited;

    static boolean DFS(int a, int parent) {
        if (visited[a]) return false;
        visited[a] = true;
        for (int b : edges[a]) {
            if (b == parent) continue;
            if (DFS(b, a) == false) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int t = 1; true; ++t) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            if (N == 0 && M == 0) break;
            edges = new ArrayList[N];
            for (int i = 0; i < N; ++i)
                edges[i] = new ArrayList<>();
            for (int i = 0; i < M; ++i) {
                int a = scanner.nextInt() - 1;
                int b = scanner.nextInt() - 1;
                edges[a].add(b);
                edges[b].add(a);
            }
            visited = new boolean[N];
            int count = 0;
            for (int i = 0; i < N; ++i)
                if (visited[i] == false)
                    if (DFS(i, -1)) ++count;
            if (count == 0) System.out.printf("Case %d: No trees.\n", t);
            else if (count == 1) System.out.printf("Case %d: There is one tree.\n", t);
            else System.out.printf("Case %d: A forest of %d trees.\n", t, count);
        }
        scanner.close();
    }
}