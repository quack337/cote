package programmers.p1829;

import java.util.Arrays;

class Main {
    static class Solution {
        int DFS(int[][] A, int color, int r, int c, boolean[][] B) {
            if (r < 0 || c < 0 || r >= A.length || c >= A[0].length) return 0;
            if (A[r][c] != color || B[r][c]) return 0; // 색이 다르거나 이미 방문한 칸
            B[r][c] = true; // 방문한 칸으로 표시
            return 1 + DFS(A, color, r-1, c, B) + DFS(A, color, r+1, c, B) + // 칸의 수 리턴
                       DFS(A, color, r, c-1, B) + DFS(A, color, r, c+1, B);
        }

        public int[] solution(int m, int n, int[][] A) {
            boolean[][] B = new boolean[A.length][A[0].length]; // 방문한 칸 표시
            int count = 0, maxSize = 0;
            for (int r = 0; r < A.length; ++r)
                for (int c = 0; c < A[0].length; ++c) {
                    if (!B[r][c] && A[r][c] > 0) { // 방문한 칸도, 빈 칸도 아니라면
                        ++count;
                        maxSize = Math.max(maxSize, DFS(A, A[r][c], r, c, B));
                    }
                }
            return new int[] { count, maxSize };
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1,1,1,0}, {1,2,2,0}, {1,0,0,1}, {0,0,0,1}, {0,0,0,3}, {0,0,0,3}};
        System.out.println(Arrays.toString(new Solution().solution(6, 4, A)));
    }
}