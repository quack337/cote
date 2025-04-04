package programmers.p001;

import java.util.Arrays;

public class Main {

    static class Solution {
        int RSIZE, CSIZE;
        int[][] map;
        char[][] grid;
        boolean[][] visited;

        boolean DFS(int r, int c) {
            System.out.printf("%d %d\n", r, c);
            // 이미 도형의 내부로 파악된 칸
            if (map[r][c] != 0) return map[r][c] == 1;

            // 도형 칸이면
            if (grid[r][c] == '#') {
                map[r][c] = 1;
                return true;
            }

            if (visited[r][c]) return true; // 재귀호출 과정에서 부모 칸 무시
            visited[r][c] = true;

            // 이웃 칸 각각에 대해서
            final int[][] dd = {{-1, 0}, {1, 0},  {0, -1}, {0, 1}};
            for (int[] d : dd) {
                int rr = r + d[0], cc = c + d[1];
                if ((rr < 0 || rr >= RSIZE) ||
                    (cc < 0 || cc >= CSIZE) ||
                    DFS(rr, cc) == false) {
                   // 이웃 칸 하나라도 도형 내부가 아니면, 이 칸도 도형 내부가 아님.
                   map[r][c] = 2;
                   return false;
               }
            }
            map[r][c] = 1;
            return true;
        }

        void print() {
            for (int r = 0; r < RSIZE; ++r)
                System.out.println(Arrays.toString(map[r]));

        }

        int solution(char[][] grid) {
            this.grid = grid;
            RSIZE = grid.length;
            CSIZE = grid[0].length;
            this.map = new int[RSIZE][CSIZE];

            int answer = 0;
            for (int r = 0; r < RSIZE; ++r)
                for (int c = 0; c < CSIZE; ++c) {
                    this.visited = new boolean[RSIZE][CSIZE];
                    if (DFS(r, c)) ++answer;
                    print();
                }

            return answer;
        }
    }

    public static void main(String[] args) {
        var grid = new char[][] { ".....####".toCharArray(),
                                  "..#...###".toCharArray(),
                                  ".#.##..##".toCharArray(),
                                  "..#..#...".toCharArray(),
                                  "..#...#..".toCharArray(),
                                  "...###...".toCharArray() };
        var sol = new Solution();
        System.out.println(sol.solution(grid));
    }

}