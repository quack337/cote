package programmers.p118670;
import java.util.Arrays;

public class Main1 {

    static class Solution {
        int rowCount, colCount;

        void shiftRows(int[][] A) {
            int[] last = A[rowCount - 1];
            for (int r = rowCount - 1; r > 0; --r)
                A[r] = A[r - 1];
            A[0] = last;
        }

        void rotate(int[][] A) {
            int first = A[0][0];
            for (int r = 0; r < rowCount - 1; ++r)
                A[r][0] = A[r + 1][0];
            for (int c = 0; c < colCount - 1; ++c)
                A[rowCount - 1][c] = A[rowCount - 1][c + 1];
            for (int r = rowCount - 1; r > 0; --r)
                A[r][colCount - 1] = A[r - 1][colCount - 1];
            for (int c = colCount - 1; c > 0; --c)
                A[0][c] = A[0][c - 1];
            A[0][1] = first;
        }

        public int[][] solution(int[][] A, String[] operations) {
            rowCount = A.length; colCount = A[0].length;
            for (String op : operations)
                if (op.charAt(0) == 'R') rotate(A);
                else shiftRows(A);
            return A;
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        var A = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        var op = new String[] {"Rotate", "ShiftRow"};
        System.out.println(Arrays.deepToString(s.solution(A, op)));

        A = new int[][] {{8,6,3},{3,3,7},{8,4,9}};
        op = new String[] {"Rotate", "ShiftRow", "ShiftRow"};
        System.out.println(Arrays.deepToString(s.solution(A, op)));

        A = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        op = new String[] {"ShiftRow", "Rotate", "ShiftRow", "Rotate"};
        System.out.println(Arrays.deepToString(s.solution(A, op)));
    }
}