package baekjoon.p02.p2931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static final int N=1, S=2, W=3, E=4; // 동 남 서 동
    static class Pipe {
        int r, c;
        char ch;

        public Pipe(int r, int c, char ch) {
            this.r = r;
            this.c = c;
            this.ch = ch;
        }
    }

    static int R, C;
    static char[][] map;

    static Pipe DFS(int r, int c) {
        Pipe result = null;
        if ((result = DFS(r+1, c, N, null)) != null) return result;
        if ((result = DFS(r-1, c, S, null)) != null) return result;
        if ((result = DFS(r, c+1, W, null)) != null) return result;
        if ((result = DFS(r, c-1, E, null)) != null) return result;
        return null;
    }

    static Pipe DFS(int r, int c, int from, Pipe pipe) {
        if (r < 0 || r >= R) return null;
        if (c < 0 || c >= C) return null;
        //System.out.printf("%d %d %d %s\n", r, c, from, pipe == null ? "null" : String.format("(%d,%d,%c)", pipe.r, pipe.c, pipe.ch));
        char current = map[r][c];
        if (pipe != null && pipe.r == r && pipe.c == c)
            current = pipe.ch;
        if (current == 'Z') return pipe;
        Pipe result = null;
        if (current == '|' || current == '+') {
            if (from == N && (result = DFS(r+1, c, N, pipe)) != null) return result;
            if (from == S && (result = DFS(r-1, c, S, pipe)) != null) return result;
        }
        if (current == '-' || current == '+') {
            if (from == E && (result = DFS(r, c-1, E, pipe)) != null) return result;
            if (from == W && (result = DFS(r, c+1, W, pipe)) != null) return result;
        }
        if (current == '1') {
            if (from == S && (result = DFS(r, c+1, W, pipe)) != null) return result;
            if (from == E && (result = DFS(r+1, c, N, pipe)) != null) return result;
        }
        if (current == '2') {
            if (from == N && (result = DFS(r, c+1, W, pipe)) != null) return result;
            if (from == E && (result = DFS(r-1, c, S, pipe)) != null) return result;
        }
        if (current == '3') {
            if (from == N && (result = DFS(r, c-1, E, pipe)) != null) return result;
            if (from == W && (result = DFS(r-1, c, S, pipe)) != null) return result;
        }
        if (current == '4') {
            if (from == S && (result = DFS(r, c-1, E, pipe)) != null) return result;
            if (from == W && (result = DFS(r+1, c, N, pipe)) != null) return result;
        }
        if (current == '.') {
            if (pipe != null) return null;
            if (from == N) {
                if ((result = DFS(r+1, c, N, new Pipe(r, c, '|'))) != null) return result;
                if ((result = DFS(r+1, c, N, new Pipe(r, c, '+'))) != null) return result;
                if ((result = DFS(r, c+1, W, new Pipe(r, c, '2'))) != null) return result;
                if ((result = DFS(r, c-1, E, new Pipe(r, c, '3'))) != null) return result;
            } else if (from == S) {
                if ((result = DFS(r-1, c, S, new Pipe(r, c, '|'))) != null) return result;
                if ((result = DFS(r-1, c, S, new Pipe(r, c, '+'))) != null) return result;
                if ((result = DFS(r, c+1, W, new Pipe(r, c, '1'))) != null) return result;
                if ((result = DFS(r, c-1, E, new Pipe(r, c, '4'))) != null) return result;
            } else if (from == E) {
                if ((result = DFS(r, c-1, E, new Pipe(r, c, '-'))) != null) return result;
                if ((result = DFS(r, c-1, E, new Pipe(r, c, '+'))) != null) return result;
                if ((result = DFS(r+1, c, N, new Pipe(r, c, '1'))) != null) return result;
                if ((result = DFS(r-1, c, S, new Pipe(r, c, '2'))) != null) return result;
            } else if (from == W) {
                if ((result = DFS(r, c+1, W, new Pipe(r, c, '-'))) != null) return result;
                if ((result = DFS(r, c+1, W, new Pipe(r, c, '+'))) != null) return result;
                if ((result = DFS(r-1, c, S, new Pipe(r, c, '3'))) != null) return result;
                if ((result = DFS(r+1, c, N, new Pipe(r, c, '4'))) != null) return result;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        map = new char[R][];
        int r0 = 0, c0 = 0;
        for (int r = 0; r < R; ++r) {
            map[r] = reader.readLine().toCharArray();
            for (int c = 0; c < C; ++c)
                if (map[r][c] == 'M') { r0 = r; c0 = c; }
        }
        Pipe pipe = DFS(r0, c0);
        System.out.printf("%d %d %c\n", pipe.r+1, pipe.c+1, pipe.ch);
    }
}