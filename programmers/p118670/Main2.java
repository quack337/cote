package programmers.p118670;
import java.util.Arrays;

public class Main2 {

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

        void shiftRows(MyDeque<MyDeque<Integer>> B) throws Exception {
            var row = B.removeLast();
            B.addFirst(row);
        }

        void rotate(MyDeque<MyDeque<Integer>> B) throws Exception {
            for (int r = 0; r < rowCount - 1; ++r)
                B.get(r).addFirst(B.get(r + 1).removeFirst());
            for (int r = rowCount - 1; r > 0; --r)
                B.get(r).addLast(B.get(r - 1).removeLast());
        }

        public int[][] solution(int[][] A, String[] operations) throws Exception {
            rowCount = A.length; colCount = A[0].length;
            MyDeque<MyDeque<Integer>> B = new MyDeque<>();
            for (int r = 0; r < rowCount; ++r) {
                var row = new MyDeque<Integer>();
                for (int i : A[r])
                    row.addLast(i);
                B.addLast(row);
            }

            for (String op : operations)
                if (op.charAt(0) == 'R') rotate(B);
                else shiftRows(B);

            for (int r = 0; r < rowCount; ++r) {
                MyDeque<Integer> row = B.get(r);
                for (int c = 0; c < colCount; ++c)
                    A[r][c] = row.get(c);
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