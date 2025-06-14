package baekjoon.b2178.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {

    static int R, C;
    static char[][] map;
    static boolean[][] visited = new boolean[R][C];

    static final int[][] D = {{-1,0}, {+1,0}, {0,-1}, {0,+1}};

    static int DFS(int r, int c) {
        if (map[r][c] == 'G') return 1;  // 목적지 도착
        if (map[r][c] == '0') return -1; // 벽
        if (visited[r][c]) return -1;    // 이미 방문한 칸인가?
        visited[r][c] = true;
        for (int[] d : D) {
            int r1 = r + d[0], c1 = c + d[1];
            if (r1 < 0 || r1 >= R) continue;
            if (c1 < 0 || c1 >= C) continue;
            int result = DFS(r1, c1);
            if (result > 0) return result + 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[R][C];
        map = new char[R][];
        for (int r = 0; r < R; ++r)
            map[r] = reader.readLine().toCharArray();
        System.out.println(DFS(0, 0) > 0);
    }
}