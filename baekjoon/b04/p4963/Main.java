package baekjoon.b04.p4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int[][] D = {{-1,-1}, {-1,0}, {-1,+1}, {0,-1}, {0,+1}, {+1,-1}, {+1,0}, {+1,+1}};
    static int H, W;
    static char[][] map;
    static boolean[][] visited;

    static void DFS(int r, int c, boolean[][] visited) {
        if (visited[r][c]) return;
        visited[r][c] = true;
        for (int[] d : D) {
            int r1 = r + d[0], c1 = c + d[1];
            if (r1 < 0 || r1 >= H) continue;
            if (c1 < 0 || c1 >= W) continue;
            if (map[r1][c1] == '0') continue;
            if (visited[r1][c1]) continue;
            DFS(r1, c1, visited);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            W = Integer.parseInt(tokenizer.nextToken());
            H = Integer.parseInt(tokenizer.nextToken());
            if (W == 0) break;
            map = new char[H][];
            for (int r = 0; r < H; ++r)
                map[r] = reader.readLine().replaceAll(" ", "").toCharArray();
            visited = new boolean[H][W];
            int count = 0;
            for (int r = 0; r < H; ++r)
                for (int c = 0; c < W; ++c)
                    if (map[r][c] == '1' && visited[r][c] == false) {
                        ++count;
                        DFS(r, c, visited);
                    }
            builder.append(count).append('\n');
        }
        System.out.println(builder);
    }
}