package baekjoon.p10.p10026;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int N;
    static char[][] map;
    static boolean[][] visited;

    static void DFS(char color, int r, int c) {
        if (map[r][c] != color) return;
        if (visited[r][c]) return;
        visited[r][c] = true;
        if (r > 0) DFS(color, r-1, c);
        if (c > 0) DFS(color, r, c-1);
        if (r < N-1) DFS(color, r+1, c);
        if (c < N-1) DFS(color, r, c+1);
    }

    static int areaCount() {
        visited = new boolean[N][N];
        int count = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (visited[r][c] == false) {
                    ++count;
                    char color = map[r][c];
                    DFS(color, r, c);
                }
        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new char[N][];
        for (int i = 0; i < N; ++i)
            map[i] = scanner.next().toCharArray();
        int count1 = areaCount();

        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (map[r][c] == 'R') map[r][c] = 'G';
        int count2 = areaCount();

        System.out.println(count1 + " " + count2);
        scanner.close();
    }
}