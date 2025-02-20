package baekjoon.p02.p2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int[][] 상하좌우 = { {-1,0}, {+1,0}, {0,-1}, {0,+1} };
    static int R, C;
    static int[][] map;

    static boolean valid(int r, int c) {
        if (r < 0 || r >= R) return false;
        if (c < 0 || c >= C) return false;
        return true;
    }

    static boolean isZero(int r, int c) { // 주변의 0 칸 수
        return valid(r, c) && map[r][c] == 0;
    }

    static int zeroCount(int r, int c) {
        int count = 0;
        for (int[] d : 상하좌우)
            if (isZero(r + d[0], c + d[1])) ++count;
        return count;
    }

    static void melt() {
        int[][] newMap = new int[R][C];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                newMap[r][c] = Math.max(0, map[r][c] - zeroCount(r, c));
        map = newMap;
    }

    static void DFS(int r, int c, boolean[][] visited) {
        if (valid(r, c) == false) return;
        if (visited[r][c]) return;
        if (isZero(r, c)) return;
        visited[r][c] = true;
        for (int[] d : 상하좌우)
            DFS(r+d[0], c+d[1], visited);
    }

    static int countIceburg() {
        boolean[][] visited = new boolean[R][C];
        int count = 0;
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (visited[r][c]==false && isZero(r, c)==false) {
                    ++count;
                    DFS(r, c, visited);
                }
        return count;
    }

    static int solution() {
        int year = 0;
        while (true) {
            int count = countIceburg();
            if (count >= 2) return year;
            if (count == 0) return 0;
            melt();
            ++year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken()); // 행
        C = Integer.parseInt(tokenizer.nextToken()); // 열
        map = new int[R][C];
        for (int r = 0; r < R; ++r) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < C; ++c)
                map[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(solution());
    }
}
