package programmers.e87390;

import java.util.Arrays;

public class Main3 {

    static class Solution {

        int value(int row, int col) {
            if (row >= col) return row + 1;
            return col + 1;
        }

        public int[] solution(int n, long left, long right) {
            int size = (int)(right - left + 1);
            int[] r = new int[size];
            for (int i = 0; i < size; ++i) {
                long index = i + left;
                int row = (int)(index / n);
                int col = (int)(index % n);
                r[i] = value(row, col);
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