package leetcode.p62;

public class Main4 {
    static class Solution {

        public int uniquePaths(int m, int n) {
            int[] DP = new int[n];
            DP[n - 1] = 1;
            for (int r = m - 1; r >= 0; --r)
                for (int c = n - 1; c > 0; --c)
                    DP[c - 1] += DP[c];
            return DP[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }
}