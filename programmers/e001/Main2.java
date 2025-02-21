public class Main2 {

    static class Solution {
        int RSIZE, CSIZE;
        char[][] grid;
        boolean[][] visited;

        boolean DFS(int r, int c) {
            // 이미 도형의 내부로 파악된 칸
            if (grid[r][c] == '#') return true;

            // 이미 도형 외부로 파악된 칸
            if (grid[r][c] == ' ') return false;

            if (visited[r][c]) return true; // 재귀호출 과정에서 부모 칸 또 호출을 막기위함
            visited[r][c] = true;

            // 이웃 칸 각각에 대해서
            final int[][] dd = {{-1, 0}, {1, 0},  {0, -1}, {0, 1}};
            for (int[] d : dd) {
                int rr = r + d[0], cc = c + d[1];
                if ((rr < 0 || rr >= RSIZE) ||
                    (cc < 0 || cc >= CSIZE) ||
                    DFS(rr, cc) == false) {
                   // 이웃 칸 하나라도 도형 내부가 아니면, 이 칸도 도형 내부가 아님.
                   grid[r][c] = ' '; // 도형 외부임을 표시
                   return false;
               }
            }
            grid[r][c] = '#'; // 도형 내부임을 표시
            return true;
        }

        int solution(char[][] grid) {
            this.grid = grid;
            RSIZE = grid.length;
            CSIZE = grid[0].length;

            int answer = 0;
            for (int r = 0; r < RSIZE; ++r)
                for (int c = 0; c < CSIZE; ++c) {
                    this.visited = new boolean[RSIZE][CSIZE];
                    if (DFS(r, c)) ++answer;
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