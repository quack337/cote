package baekjoon.p14.p14176;

import java.util.Scanner;

public class Main {
    static int R, C;
    static int[][] map;
    static boolean[][] visited;

    static void DFS(int r, int c) {
        if (r < 0 || c < 0 || r >= R || c >= C) return;
        if (map[r][c] != 1) return;
        if (visited[r][c]) return;
        visited[r][c] = true;
        DFS(r - 1, c);
        DFS(r, c - 1);
        DFS(r + 1, c);
        DFS(r, c + 1);
        DFS(r + 1, c + 1);
        DFS(r + 1, c - 1);
        DFS(r - 1, c + 1);
        DFS(r - 1, c - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        R = scanner.nextInt();
        C = scanner.nextInt();
        map = new int[R][C];
        visited = new boolean[R][C];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                map[r][c] = scanner.nextInt();
        scanner.close();
        int count = 0;
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (map[r][c] == 1 && visited[r][c] == false) {
                    ++count;
                    DFS(r, c);
                }
        System.out.println(count);
    }
}

