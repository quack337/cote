package baekjoon.b02.p2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Rectangle {
        int r1, c1, r2, c2;

        public Rectangle(int r1, int c1, int r2, int c2) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
        }

        public boolean contains(int r, int c) {
            return r1 <= r && r < r2 && c1 <= c && c < c2;
        }
    }

    static int M, N, K;
    static Rectangle[] rectangles;
    static final int EMPTY = '0', VISITED = 'v', WALL = '1';

    static int DFS(char[][] map, int r, int c) {
        if (r < 0 || r >= M) return 0;
        if (c < 0 || c >= N) return 0;
        if (map[r][c] != EMPTY) return 0;
        map[r][c] = VISITED; // 방문 표시
        int count = 1;
        count += DFS(map, r-1, c);
        count += DFS(map, r+1, c);
        count += DFS(map, r, c-1);
        count += DFS(map, r, c+1);
        return count;
    }

    static boolean isEmpty(int r, int c) {
        for (Rectangle rects : rectangles)
            if (rects.contains(r, c)) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        M = Integer.parseInt(tokenizer.nextToken());
        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
        rectangles = new Rectangle[K];
        for (int i = 0; i < K; ++i) {
            tokenizer = new StringTokenizer(reader.readLine());
            int c1 = Integer.parseInt(tokenizer.nextToken());
            int r1 = Integer.parseInt(tokenizer.nextToken());
            int c2 = Integer.parseInt(tokenizer.nextToken());
            int r2 = Integer.parseInt(tokenizer.nextToken());
            rectangles[i] = new Rectangle(r1, c1, r2, c2);
        }
        char[][] map = new char[M][N];
        for (int r = 0; r < M; ++r)
            for (int c = 0; c < N; ++c)
                map[r][c] = isEmpty(r, c) ? '0' : '1';

        ArrayList<Integer> result = new ArrayList<>();
        for (int r = 0; r < M; ++r)
            for (int c = 0; c < N; ++c)
                if (map[r][c] == EMPTY)
                    result.add(DFS(map, r, c));

        System.out.println(result.size());
        Collections.sort(result);
        for (int i : result)
            System.out.print(i + " ");
    }
}