package baekjoon.p02.p2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;

    static void DFS(int r, int c, int rain, boolean[][] visited) {
        if (r < 0 || r >= N) return;
        if (c < 0 || c >= N) return;
        if (map[r][c] <= rain) return;
        if (visited[r][c]) return;
        visited[r][c] = true;
        DFS(r-1, c, rain, visited);
        DFS(r+1, c, rain, visited);
        DFS(r, c-1, rain, visited);
        DFS(r, c+1, rain, visited);
    }

    static int safeArea(int rain) {
        boolean[][] visited = new boolean[N][N];
        int count = 0;
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c)
                if (map[r][c] > rain && visited[r][c] == false) {
                    ++count;
                    DFS(r, c, rain, visited);
                }
        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        map = new int[N][N];
        for (int r = 0; r < N; ++r) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < N; ++c)
                map[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        int maxCount = 0;
        for (int rain = 0; rain <= 100; ++rain) {
            int count = safeArea(rain);
            if (count > maxCount) maxCount = count;
        }
        System.out.println(maxCount);
    }
}