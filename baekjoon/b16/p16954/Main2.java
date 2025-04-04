package baekjoon.b16.p16954;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main2 {

    static boolean wall(char[][] map, int r, int c, int t) {
        return 0 <= r-t && r-t <= 7 && 0 <= c && c <= 7 && map[r-t][c] == '#';
    }

    static int BFS(char[][] map) {
        var visited = new int[8][8];
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] {7, 0, 0});
        while (queue.size() > 0) {
            int[] a = queue.remove();
            int r = a[0], c = a[1], t = a[2];
            if (r < 0 || c < 0 || r > 7 || c > 7) continue;
            if (visited[r][c] > 8) continue;
            ++visited[r][c];
            if (wall(map, r, c, t)) continue;
            if (r == 0 && c == 7) return 1;
            for (int dr = -1; dr <= 1; ++dr)
                for (int dc = -1; dc <= 1; ++dc)
                    if (wall(map, r + dr, c + dc, t) == false)
                        queue.add(new int[] {r + dr, c + dc, t + 1});
        }
        return 0;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        char[][] map = new char[8][];
        for (int i = 0; i < 8; ++i)
            map[i] = scanner.next().toCharArray();
        scanner.close();
        System.out.println(BFS(map));
    }
}