package programmers.e87390;

import java.util.Arrays;

public class Main1 {

    static class Solution {
        public int[] solution(int n, int left, int right) {
            int[][] a = new int[n][n];
            for (int i = 1; i <= n; ++i) {
                for (int j = 0; j < i; ++j) {
                    a[i - 1][j] = i;
                    a[j][i - 1] = i;
                }
            }
            int size = right - left + 1;
            int[] r = new int[size];
            for (int i = 0; i < size; ++i) {
                int index = i + left;
                int row = index / n;
                int col = index % n;
                r[i] = a[row][col];
            }
            return r;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(3, 2, 5)));
        System.out.println(Arrays.toString(sol.solution(4, 7, 14)));
    }

}