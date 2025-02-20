package baekjoon.p01.p1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static char[][] map;
    static int R, C;

    static int DFS(int r, int c, boolean[] visited) {
        if (r < 0 || r >= R) return 0;
        if (c < 0 || c >= C) return 0;
        char ch = map[r][c];
        if (visited[ch - 'A']) return 0;
        visited[ch - 'A'] = true;
        final int[][] DIFF = {{-1,0}, {+1,0}, {0,-1}, {0,+1}};
        int max = 0;
        for (int[] d : DIFF)
            max = Math.max(max, DFS(r + d[0], c + d[1], visited));
        return 1 + max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        map = new char[R][];
        for (int r = 0; r < R; ++r)
            map[r] = reader.readLine().toCharArray();
        System.out.println(DFS(0, 0, new boolean[26]));
    }
}
