package etcc.leetcode.p62;
public class Main1 {
    static class Solution {

        int DFS(int r, int c, int M, int N) {
            if (r == M-1 && c == N-1) return 1;
            if (r < 0 || c < 0 || M <= r || N <= c) return 0;
            return DFS(r + 1, c, M, N) + DFS(r, c + 1, M, N);
        }

        public int uniquePaths(int m, int n) {
            return DFS(0, 0, m, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }
}