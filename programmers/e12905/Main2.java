package programmers.e12905;

import static java.lang.Math.min;

public class Main2 {

    static class Solution
    {
        public int solution(int[][] A)
        {
            int H = A.length, W = A[0].length;
            int[][] size = new int[H][W];
            int max = 0;
            for (int r = H - 1; r >= 0; --r)
                for (int c = W - 1; c >= 0; --c) {
                    if (A[r][c] == 0) {
                        size[r][c] = 0;
                    } else {
                        int size1 = (c < W - 1) ? size[r][c + 1] : 0;
                        int size2 = (r < H - 1) ? size[r + 1][c] : 0;
                        int size3 = (c < W - 1 && r < H - 1) ? size[r + 1][c + 1] : 0;
                        size[r][c] = 1 + min(size1, min(size2, size3));
                    }
                    if (size[r][c] > max) max = size[r][c];
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