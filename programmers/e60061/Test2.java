package net.skhu.kakao.t2020.ex5;

import java.util.ArrayList;
import java.util.Arrays;

public class Test2 {

    static class Solution {
        static final int 기둥=0, 보=1;
        int N;
        boolean[][][] obj;

        boolean 있나(int x, int y, int a) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            return obj[x][y][a];
        }

        boolean 설치가능(int x, int y, int a) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            if (a == 기둥) {
                if (y == N-1) return false;
                if (y>0 && !있나(x,y-1,기둥) && !있나(x-1,y,보) && !있나(x,y,보)) return false;
            }
            else if (a == 보) {
                if (y == 0 || x == N-1) return false;
                if (!있나(x,y-1,기둥) && !있나(x+1,y-1,기둥) && !(있나(x-1,y,보) && 있나(x+1,y,보)))
                    return false;
            }
            return true;
        }

        boolean 다시설치가능() {
            for (int x = 0; x < N; ++x)
                for (int y = 0; y < N; ++y)
                    for (int a = 0; a < 2; ++a)
                        if (있나(x,y,a) && !설치가능(x,y,a)) return false;
            return true;
        }

        boolean 삭제가능(int x, int y, int a) {
            if (x < 0 || x >= N || y < 0 || y >= N) return false;
            if (!있나(x,y,a)) return false;
            obj[x][y][a] = false;
            boolean result = 다시설치가능();
            obj[x][y][a] = true;
            return result;
        }

        public int[][] solution(int n, int[][] build_frame) {
            N = n + 1;
            obj = new boolean[N][N][2];
            for (int[] c : build_frame) {
                int x = c[0], y = c[1], a = c[2], cmd = c[3];
                if (cmd==1 && 설치가능(x,y,a)) obj[x][y][a] = true;
                if (cmd==0 && 삭제가능(x,y,a)) obj[x][y][a] = false;
            }
            ArrayList<int[]> list = new ArrayList<>();
            for (int x = 0; x < N; ++x)
                for (int y = 0; y < N; ++y)
                    for (int a = 0; a < 2; ++a)
                        if (obj[x][y][a]) list.add(new int[] {x, y, a});
            return list.toArray(new int[0][]);
        }
    }

    public static void main(String[] args) {
        int[][] a1 = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        int[][] a2 = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},
                      {1,1,1,0},{2,2,0,1}};
        System.out.println(Arrays.deepToString(new Solution().solution(5, a1)));
        System.out.println(Arrays.deepToString(new Solution().solution(5, a2)));
    }
}
