package baekjoon.b11559;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static final int R = 12, C = 6;
    static char[][] map;

    static int countDFS(int r, int c, char color, boolean[][] visited) {
        if (r < 0 || r >= R) return 0;
        if (c < 0 || c >= C) return 0;
        if (map[r][c] != color) return 0;
        if (visited[r][c]) return 0;
        visited[r][c] = true;
        int sum = 0;
        sum += countDFS(r-1, c, color, visited);
        sum += countDFS(r+1, c, color, visited);
        sum += countDFS(r, c-1, color, visited);
        sum += countDFS(r, c+1, color, visited);
        return sum + 1;
    }

    static void removeDFS(int r, int c, char color) {
        if (r < 0 || r >= R) return;
        if (c < 0 || c >= C) return;
        if (map[r][c] != color) return;
        for (int i = r; i > 0; --i)
            map[i][c] = map[i-1][c];
        map[0][c] = '.';
        removeDFS(r, c, color); // 한 칸 내려왔으므로, -1 이 필요 없음
        removeDFS(r+1, c, color);
        removeDFS(r, c-1, color);
        removeDFS(r, c+1, color);
    }

    static boolean bang() {
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (map[r][c] != '.')
                    if (countDFS(r, c, map[r][c], new boolean[R][C]) >= 4) {
                        removeDFS(r, c, map[r][c]);
                        return true;
                    }
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        map = new char[R][];
        for (int r = 0; r < R; ++r)
            map[r] = reader.readLine().toCharArray();
        int count = 0;
        while (bang())
            ++count;
        System.out.println(count);
    }
}