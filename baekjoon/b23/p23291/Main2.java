package baekjoon.b23.p23291;

public class Main2 {

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

        public void print() {
            for (int r = 0; r < rows; ++r) {
                for (int c = 0; c < cols; ++c)
                    System.out.printf("%2d ", data[r][c]);
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] A = new int[96];
        var matrix = new Matrix();
        int index = 0;

        for (int i = 0; i < A.length; ++i)
            A[i] = (i + 1);
        while (A.length - index >= matrix.rows) { // 어
            matrix.rotate90(A, index);
            matrix.print();
            index += matrix.cols;
        }
    }
}