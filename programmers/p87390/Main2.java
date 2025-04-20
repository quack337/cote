package programmers.p87390;
import java.util.Arrays;

public class Main2 {

    static class Solution {

        int value(int row, int col) {
            if (row >= col) return row + 1;
            return col + 1;
        }

        public int[] solution(int n, int left, int right) {
            int size = right - left + 1;
            int[] r = new int[size];
            for (int i = 0; i < size; ++i) {
                int index = i + left;
                int row = index / n;
                int col = index % n;
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