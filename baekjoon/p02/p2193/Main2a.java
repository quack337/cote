package baekjoon.p02.p2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2a {

    static int[][] DP = new int[91][2];

    static int DFS(int n, int previous) {
        if (n == 0) return 1;
        if (previous == -1) return DFS(n-1, 1);
        if (DP[n][previous] > 0) return DP[n][previous];
        if (previous == 0) return DP[n][previous] = DFS(n-1, 1) + DFS(n-1, 0);
        return DP[n][previous] = DFS(n-1, 0);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        System.out.println(N == 0 ? 0 : DFS(N, -1));
    }
}