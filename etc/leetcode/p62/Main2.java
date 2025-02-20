package leetcode.p62;

public class Main2 {
    static class Solution {
        int[][] DP;

        int DFS(int r, int c, int M, int N) {
            if (r == M-1 && c == N-1) return 1;
            if (r < 0 || c < 0 || M <= r || N <= c) return 0;
            if (DP[r][c] > 0) return DP[r][c];
            return DP[r][c] = DFS(r + 1, c, M, N) + DFS(r, c + 1, M, N);
        }

        public int uniquePaths(int m, int n) {
            DP = new int[m][n];
            return DFS(0, 0, m, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }
}
