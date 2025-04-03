package programmers.e118670;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main4 {

    static class Solution {
        int rowCount, colCount;
        Deque<Integer> leftColumn;
        Deque<Integer> rightColumn;
        Deque<Deque<Integer>> rows;

        void shiftRows() throws Exception {
            rows.addFirst(rows.removeLast());
            leftColumn.addFirst(leftColumn.removeLast());
            rightColumn.addFirst(rightColumn.removeLast());
        }

        void rotate() throws Exception {
            rows.peekFirst().addFirst(leftColumn.removeFirst());
            rightColumn.addFirst(rows.peekFirst().removeLast());
            rows.peekLast().addLast(rightColumn.removeLast());
            leftColumn.addLast(rows.peekLast().removeFirst());
        }

        public int[][] solution(int[][] A, String[] operations) throws Exception {
            rowCount = A.length; colCount = A[0].length;
            rows = new ArrayDeque<>();
            leftColumn = new ArrayDeque<>();
            rightColumn = new ArrayDeque<>();
            for (int r = 0; r < rowCount; ++r) {
                leftColumn.addLast(A[r][0]);
                rightColumn.addLast(A[r][colCount - 1]);
                var row = new ArrayDeque<Integer>();
                for (int c = 1; c < colCount - 1; ++c)
                    row.addLast(A[r][c]);
                rows.addLast(row);
            }

            for (String op : operations)
                if (op.charAt(0) == 'R') rotate();
                else shiftRows();

            for (int r = 0; r < rowCount; ++r) {
                var row = rows.removeFirst();
                A[r][0] = leftColumn.removeFirst();
                for (int c = 1; c < colCount - 1; ++c)
                    A[r][c] = row.removeFirst();;
                A[r][colCount - 1] = rightColumn.removeFirst();
            }
            return A;
        }
    }

    public static void main(String[] args) throws Exception {
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