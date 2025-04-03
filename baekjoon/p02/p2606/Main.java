package baekjoon.p02.p2606;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer>[] edges;
    static HashSet<Integer> visited = new HashSet<>();

    static void DFS(int a) {
        if (visited.contains(a)) return;
        visited.add(a);
        for (int b : edges[a])
            DFS(b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        edges = new ArrayList[N];
        for (int i = 0; i < N; ++i)
            edges[i] = new ArrayList<Integer>();
        int m = scanner.nextInt();
        for (int i = 0; i < m; ++i) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            edges[a].add(b);
            edges[b].add(a);
        }
        DFS(0);
        System.out.println(visited.size() - 1);
        scanner.close();
    }
}