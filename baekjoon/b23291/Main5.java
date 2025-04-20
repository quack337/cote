package baekjoon.b23291;
import java.util.Arrays;
import java.util.Scanner;

public class Main5 {

    static class Matrix {
        int[][] data;
        int rows, cols;

        public void rotate90(int[] A, int index) {
            if (rows == 0) {
                data = new int[1][1];
                data[0][0] = A[index];
                rows = cols = 1;
            } else {
                int rowsNew = rows, colsNew = cols;
                if (rows == cols) ++rowsNew; else ++colsNew;
                int[][] dataNew = new int[rowsNew][colsNew];
                for (int r = 0; r < rows; ++r)
                    for (int c = 0; c < cols; ++c)
                        dataNew[c][colsNew - r - 1] = data[r][c];
                for (int c = 0; c < colsNew; ++c)
                    dataNew[rowsNew - 1][c] = A[index + c];
                data = dataNew;
                rows = rowsNew;
                cols = colsNew;
            }
        }

        public void print(int[] A, int index) {
            System.out.println();
            for (int r = 0; r < rows; ++r) {
                for (int c = 0; c < cols; ++c)
                    System.out.printf("%2d ", data[r][c]);
                if (r < rows-1) System.out.println();
            }
            for (int i = index; i < A.length; ++i)
                System.out.printf("%2d ", A[i]);
            System.out.println();
        }

        public void adjust(int[] A, int index) {
            // 머리 부분 조정값 계산
            var 조정값1 = new int[rows][cols];
            for (int r = 0; r < rows; ++r)
            for (int c = 0; c < cols; ++c) {
                if (r > 0) 조정값계산(조정값1, r, c, r-1, c);
                if (c > 0) 조정값계산(조정값1, r, c, r, c-1);
            }
            // 꼬리 부분 조정값 계산
            var 조정값2 = new int[A.length];
            A[index - 1] = data[rows-1][cols-1];
            for (int i = index; i < A.length; ++i) {
                int diff = Math.abs(A[i-1] - A[i]) / 5;
                if (diff == 0) continue;
                if (A[i-1] < A[i]) diff = -diff;
                조정값2[i-1] -= diff;
                조정값2[i] += diff;
            }
            // 조정값 적용
            for (int r = 0; r < rows; ++r)
            for (int c = 0; c < cols; ++c)
                data[r][c] += 조정값1[r][c];
            data[rows-1][cols-1] += 조정값2[index - 1];
            for (int i = index; i < A.length; ++i)
                A[i] += 조정값2[i];
        }

        public void 조정값계산(int[][] 조정값, int r1, int c1, int r2, int c2) {
            int value1 = data[r1][c1];
            int value2 = data[r2][c2];
            int diff = Math.abs(value1 - value2) / 5;
            if (diff == 0) return;
            if (value1 < value2) diff = -diff;
            조정값[r1][c1] -= diff;
            조정값[r2][c2] += diff;
        }

        public int[] toArray(int[] A, int index) {
            var B = new int[A.length];
            int i = 0;
            for (int c = 0; c < cols; ++c)
                for (int r = rows-1; r >= 0; --r)
                    B[i++] = data[r][c];
            for (int j = index; j < A.length; ++j)
                B[j] = A[j];
            return B;
        }
    }

    static void adjust1(int[] A) {
        int min = Integer.MAX_VALUE;
        for (int i : A)
            if (i < min) min = i;
        for (int i = 0; i < A.length; ++i)
            if (A[i] == min) ++A[i];
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; ++i)
                A[i] = scanner.nextInt();

            adjust1(A);
            var matrix = new Matrix();
            int index = 0;
            while (A.length - index >= matrix.rows) {
                matrix.rotate90(A, index);
                index += matrix.cols;
            }
            matrix.adjust(A, index);
            int[] B = matrix.toArray(A, index);
            System.out.println(Arrays.toString(B));
        }
    }
}