package baekjoon.p01.p1932;

import java.util.Scanner;

public class Main {
    static int[][] A;
    static int[][] B;

    static int sum(int i, int j) {
        if (i >= A.length) return 0;
        if (B[i][j] > 0) return B[i][j];
        return B[i][j] = A[i][j] + Math.max(sum(i+1, j), sum(i+1, j+1));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int DEPTH = scanner.nextInt();
            A = new int[DEPTH][];
            B = new int[DEPTH][];
            for (int i = 0; i < DEPTH; ++i) {
                A[i] = new int[i + 1];
                B[i] = new int[i + 1];
                for (int j = 0; j <= i; ++j)
                    A[i][j] = scanner.nextInt();
            }
            System.out.println(sum(0, 0));
        }
    }
}
