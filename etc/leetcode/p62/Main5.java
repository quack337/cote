package leetcode.p62;

import java.util.Arrays;

public class Main5 {
    static class Solution {

        public int uniquePaths(int m, int n) {
            if (n > m) {
                int temp = n;
                n = m;
                m = temp;
            }
            int[] DP = new int[n];
            Arrays.fill(DP, 1);
            for (int r = m - 2; r >= 0; --r)
                for (int c = n - 2; c >= 0; --c)
                    DP[c] += DP[c + 1];
            return DP[0];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }
}