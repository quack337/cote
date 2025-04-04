package programmers.p118670.old;

import java.util.Arrays;

public class Main1a {

    static class Solution {
        int rows, cols;

        void shiftRows(int[][] A, int count) {
            count = count % rows;
            if (count == 0) return;
            var temp = new int[rows][];
            for (int i = 0; i < rows; ++i)
                temp[i] = A[i];
            int p = count;
            for (int i = 0; i < rows; ++i) {
                A[p] = temp[i];
                p = (p + 1) % rows;
            }
        }

        class Location {
            int r, c;

            void move() {
                if (r == 0 && c < cols - 1) ++c;
                else if (c == cols - 1 && r < rows - 1) ++r;
                else if (r == rows - 1 && c > 0) --c;
                else --r;
            }
        }

        void rotate(int[][] A, int count) {
            int N = rows*2 + cols*2 - 4;
            count = count % N;
            if (count == 0) return;
            var temp = new int[N];
            var p = new Location();
            for (int i = 0; i < N; ++i) {
                temp[i] = A[p.r][p.c];
                p.move();
            }
            for (int i = 0; i < count; ++i)
                p.move();
            for (int i = 0; i < N; ++i) {
                A[p.r][p.c] = temp[i];
                p.move();
            }
        }

        public int[][] solution(int[][] A, String[] operations) {
            rows = A.length; cols = A[0].length;
            String op_prev = operations[0];
            int count = 1;
            for (int i = 1; i <= operations.length; ++i) {
                String op = i < operations.length ? operations[i] : "end_of_op";
                if (op.equals(op_prev))
                    ++count;
                else {
                    if (op_prev.charAt(0) == 'R') rotate(A, count);
                    else shiftRows(A, count);
                    op_prev = op;
                    count = 1;
                }
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