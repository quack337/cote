package programmers.e381364;

import java.util.ArrayList;

public class Main2a {

    static class Solution {

        long[] 교차점찾기(int[] 선1, int[] 선2) {
            int A = 선1[0], B = 선1[1], E = 선1[2];
            int C = 선2[0], D = 선2[1], F = 선2[2];
            long 분모 = A*D - B*C;
            if (분모 == 0) return null;
            long x분자 = B*F - E*D, y분자 = E*C - A*F;
            if (x분자 % 분모 != 0) return null;
            if (y분자 % 분모 != 0) return null;
            return new long[] { x분자/분모, y분자/분모 };
        }

        public String[] solution(int[][] line) {
            var 교차점목록 = new ArrayList<long[]>();
            for (int i = 0; i < line.length - 1; ++i)
                for (int j = i + 1; j < line.length; ++j) {
                    long[] 교차점 = 교차점찾기(line[i], line[j]);
                    if (교차점 != null) 교차점목록.add(교차점);
                }
            long x1 = Long.MAX_VALUE, y1 = Long.MAX_VALUE;
            long x2 = Long.MIN_VALUE, y2 = Long.MIN_VALUE;
            for (long[] 교차점 : 교차점목록) {
                long x = 교차점[0], y = 교차점[1];
                if (x < x1) x1 = x; if (x > x2) x2 = x;
                if (y < y1) y1 = y; if (y > y2) y2 = y;
            }
            char[][] map = new char[(int)(y2 - y1 + 1)][(int)(x2 - x1 + 1)];
            for (int y = 0; y < map.length; ++y)
                for (int x = 0; x < map[y].length; ++x)
                    map[y][x] = '.';
            for (long[] 교차점 : 교차점목록) {
                long x = 교차점[0], y = 교차점[1];
                map[(int)(y - y1)][(int)(x - x1)] = '*';
            }
            var answer = new String[map.length];
            for (int y = 0; y < map.length; ++y)
                answer[map.length - y - 1] = new String(map[y]);
            return answer;
        }
    }

    static void print(String[] a) {
        for (String s : a)
            System.out.println(s);
        System.out.println();
    }

    public static void main(String[] args) {
        var s = new Solution();
        var a = new int[][] {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        print(s.solution(a));

        var b = new int[][] {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        print(s.solution(b));

        var c = new int[][] {{1, -1, 0}, {2, -1, 0}};
        print(s.solution(c));

        var d = new int[][] {{1, -1, 0}, {2, -1, 0}, {4, -1, 0}};
        print(s.solution(d));
    }

}
