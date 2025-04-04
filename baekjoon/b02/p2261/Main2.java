package baekjoon.b02.p2261;

import java.util.Scanner;

public class Main2 {
    static final int X = 0, Y = 1;

    static int 거리(int[] a, int[] b) {
        int x = a[X] - b[X];
        int y = a[Y] - b[Y];
        return x * x + y * y;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[][] A = new int[N][2];
            for (int i = 0; i < A.length; ++i) {
                A[i][X] = scanner.nextInt();
                A[i][Y] = scanner.nextInt();
            }
            int 최소 = Integer.MAX_VALUE;
            for (int i = 0; i < N ; ++i)
                for (int j = i+1; j < N; ++j) {
                    int 거리 = 거리(A[i], A[j]);
                    if (거리 < 최소 && 거리 > 0) 최소 = 거리;
                }
            System.out.printf("답=%d\n", 최소);
        }
    }
}