package baekjoon.b23.p23291;

import java.util.Scanner;

public class Main3 {

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

            matrix.print(A, index);
        }
    }
}