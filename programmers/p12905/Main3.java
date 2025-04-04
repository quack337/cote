package programmers.p12905;

import static java.lang.Math.min;

public class Main3 {

    static class Solution
    {
        int H, W;
        int[][] A;

        int size(int r, int c) {
            if (r >= H || c >= W) return 0;
            if (A[r][c] == 0) return 0;
            return 1 + min(size(r, c+1), min(size(r+1, c), size(r+1, c+1)));
        }


        public int solution(int[][] board)
        {
            A = board;
            H = A.length;
            W = A[0].length;

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