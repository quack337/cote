package net.skhu.line.e2022;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Main4 {
    static int R, C;
    static char[][] map;
    static final int[][][] 이동패턴_빈칸 = new int[][][] { {}, {{-1,0}},
        {{-1,0},{-1,1},{-1,2},{0,1}},
        {{-1,0},{-1,-1},{-1,-2},{0,-1}},
        {{-1,0},{-1,1},{-1,2},{-1,3},{0,1},{0,2}},
        {{-1,0},{-1,-1},{-1,-2},{-1,-3},{0,-1},{0,-2}},
        {{-1,0},{0,1}}, {{-1,0},{0,-1}}
    };

    static boolean 이동가능(int r1, int c1, int r2, int c2, int pattern) {
        if (r2 < 0 || c2 < 0 || r2 >= R || c2 >= C) return false;
        if (map[r2][c2] != 'H') return false;
        for (int[] a : 이동패턴_빈칸[pattern]) {
            int r = r1 + a[0], c = c1 + a[1];
            if (r < 0 || c < 0 || r >= R || c >= C || map[r][c] != '.') return false;
        }
        return true;
    }

    static int[][] solution(String[] wall) {
        R = wall.length;
        C = wall[0].length();
        map = new char[R][];
        for (int i = 0; i < R; ++i)
            map[i] = wall[i].toCharArray();
        var result = new int[R][C];
        var visited = new boolean[R][C];
        var queue = new ArrayDeque<int[]>();
        queue.add(new int[] {R-1, 0, 1});
        while (queue.size() > 0) {
            int[] p = queue.remove();
            int r = p[0], c = p[1], distance = p[2];
            if (visited[r][c]) continue;
            visited[r][c] = true;
            result[r][c] = distance;
            if (이동가능(r,c,r,c+1,0)) queue.add(new int[] {r,c+1, distance+1});
            if (이동가능(r,c,r,c-1,0)) queue.add(new int[] {r,c-1, distance+1});
            if (이동가능(r,c,r+1,c,0)) queue.add(new int[] {r+1,c, distance+1});
            if (이동가능(r,c,r-1,c,0)) queue.add(new int[] {r-1,c, distance+1});
            if (이동가능(r,c,r-2,c,1)) queue.add(new int[] {r-2,c, distance+1});
            if (이동가능(r,c,r,c+2,2)) queue.add(new int[] {r,c+2, distance+1});
            if (이동가능(r,c,r,c-2,3)) queue.add(new int[] {r,c-2, distance+1});
            if (이동가능(r,c,r,c+3,4)) queue.add(new int[] {r,c+3, distance+1});
            if (이동가능(r,c,r,c-3,5)) queue.add(new int[] {r,c-3, distance+1});
            if (이동가능(r,c,r-1,c+1,6)) queue.add(new int[] {r-1,c+1, distance+1});
            if (이동가능(r,c,r-1,c-1,7)) queue.add(new int[] {r-1,c-1, distance+1});
        }
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (map[r][c] == 'H' && result[r][c] == 0)
                    result[r][c] = -1;
        return result;
    }

    public static void main(String[] args) {
        var a = new String[] {"H.H", ".HX", "H.H"};
        System.out.println(Arrays.deepToString(solution(a)));
        a = new String[] {"....HH", "H..H.H"};
        System.out.println(Arrays.deepToString(solution(a)));
    }
}
