package programmers.e12905;

import static java.lang.Math.min;

public class Main4 {

    static class Solution
    {
        int H, W;
        int[][] A;
        int[][] DP;

        int size(int r, int c) {
            if (r >= H || c >= W) return 0;
            if (A[r][c] == 0) return 0;
            if (DP[r][c] > 0) return DP[r][c];
            return DP[r][c] = 1 + min(size(r, c+1), min(size(r+1, c), size(r+1, c+1)));
        }

        public int solution(int[][] board)
        {
            A = board;
            H = A.length;
            W = A[0].length;
            DP = new int[H][W];

            int max = 0;
            for (int r = 0; r < H; ++r)
                for (int c = 0; c < W; ++c) {
                    int s = size(r, c);
                    if (s > max) max = s;
                }
            return max * max;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(new int[][] {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
        System.out.println(sol.solution(new int[][] {{0,0,1,1},{1,1,1,1}}));
    }
}