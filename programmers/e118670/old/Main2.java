package programmers.e118670.old;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main2 {

    static class Solution {
        int rows, cols;

        void shiftRows(Deque<Integer>[] B) {
            var last = B[rows - 1];
            for (int r = rows - 1; r > 0; --r)
                B[r] = B[r - 1];
            B[0] = last;
        }

        void rotate(Deque<Integer>[] B) {
            for (int r = 0; r < rows - 1; ++r)
                B[r].addFirst(B[r + 1].removeFirst());
            for (int r = rows - 1; r > 0; --r)
                B[r].addLast(B[r - 1].removeLast());
        }

        public int[][] solution(int[][] A, String[] operations) {
            rows = A.length; cols = A[0].length;
            Deque<Integer>[] B = new ArrayDeque[rows];
            for (int r = 0; r < rows; ++r) {
                B[r] = new ArrayDeque<>();
                for (int i : A[r])
                    B[r].addLast(i);
            }
            for (String op : operations)
                if (op.charAt(0) == 'R') rotate(B);
                else shiftRows(B);
            for (int r = 0; r < rows; ++r) {
                int c = 0;
                for (int i : B[r])
                    A[r][c++] = i;
            }
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