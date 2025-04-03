package leetcode.p62;

public class Main3 {
    static class Solution {

        public int uniquePaths(int m, int n) {
            int[][] DP = new int[m][n];
            DP[m - 1][n - 1] = 1;
            for (int r = m - 1; r >= 0; --r)
                for (int c = n - 1; c >= 0; --c) {
                    if (r > 0) DP[r - 1][c] += DP[r][c];
                    if (c > 0) DP[r][c - 1] += DP[r][c];
                }
            return DP[0][0];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }
}