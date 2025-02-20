package baekjoon.p02.p2450;

import java.util.Scanner;

public class Main {
    static int[][] 행렬입력(Scanner scanner) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        for (int r = 0; r < n; ++r)
            for (int c = 0; c < m; ++c)
                a[r][c] = scanner.nextInt();
        return a;
    }

    static int[][] 곱셈(int[][] a, int[][] b) {
        int R = a.length, C = b[0].length;
        int[][] m = new int[R][C];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                for (int i = 0; i < b.length; ++i)
                    m[r][c] += a[r][i] * b[i][c];
        return m;
    }

    static void print(int[][] a) {
        for (int[] b : a) {
            for (int i : b)
                System.out.printf("%d ", i);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[][] a = 행렬입력(scanner);
            int[][] b = 행렬입력(scanner);
            int[][] r = 곱셈(a, b);
            print(r);
        }
    }
}
