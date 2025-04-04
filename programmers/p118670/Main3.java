package programmers.p118670;

import java.util.Arrays;

public class Main3 {

    static class Solution {
        @SuppressWarnings("unchecked")
        static class MyDeque<T> {
            Object[] data = new Object[16];
            int begin = 0, count = 0;

            void expand() throws Exception {
                Object[] temp = new Object[data.length * 2];
                for (int i = 0; i < count; ++i)
                    temp[i] = get(i);
                data = temp;
                begin = 0;
            }

            public void addFirst(T value) throws Exception {
                if (count == data.length) expand();
                --begin;
                if (begin == -1) begin = data.length - 1;
                data[begin] = value;
                ++count;
            }

            public T removeFirst() throws Exception {
                if (count == 0) throw new Exception();
                T value = (T)data[begin];
                ++begin;
                if (begin == data.length) begin = 0;
                --count;
                return value;
            }

            public void addLast(T value) throws Exception {
                if (count == data.length) expand();
                int index = (begin + count) % data.length;;
                data[index] = value;
               ++count;
            }

            public T removeLast() throws Exception {
                if (count == 0) throw new Exception();
                int index = (begin + count - 1) % data.length;;
                T value = (T)data[index];
                --count;
                return value;
            }

            public T get(int index) throws Exception {
                if (index >= count) throw new Exception();
                index = (index + begin) % data.length;
                return (T)data[index];
            }
        }

        int rowCount, colCount;
        MyDeque<Integer> leftColumn;
        MyDeque<Integer> rightColumn;
        MyDeque<MyDeque<Integer>> rows;

        void shiftRows() throws Exception {
            rows.addFirst(rows.removeLast());
            leftColumn.addFirst(leftColumn.removeLast());
            rightColumn.addFirst(rightColumn.removeLast());
        }

        void rotate() throws Exception {
            rows.get(0).addFirst(leftColumn.removeFirst());
            rightColumn.addFirst(rows.get(0).removeLast());
            rows.get(rowCount - 1).addLast(rightColumn.removeLast());
            leftColumn.addLast(rows.get(rowCount - 1).removeFirst());
        }

        public int[][] solution(int[][] A, String[] operations) throws Exception {
        rowCount = A.length; colCount = A[0].length;
        rows = new MyDeque<>();
        leftColumn = new MyDeque<>();
        rightColumn = new MyDeque<>();
        for (int r = 0; r < rowCount; ++r) {
            leftColumn.addLast(A[r][0]);
            rightColumn.addLast(A[r][colCount - 1]);
            var row = new MyDeque<Integer>();
            for (int c = 1; c < colCount - 1; ++c)
                row.addLast(A[r][c]);
            rows.addLast(row);
        }

            for (String op : operations)
                if (op.charAt(0) == 'R') rotate();
                else shiftRows();

            for (int r = 0; r < rowCount; ++r) {
                var row = rows.get(r);
                A[r][0] = leftColumn.get(r);
                A[r][colCount - 1] = rightColumn.get(r);
                for (int c = 1; c < colCount - 1; ++c)
                    A[r][c] = row.get(c - 1);
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