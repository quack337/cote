package baekjoon.p01.p1015;

import java.util.Scanner;

public class Main {
    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void 버블정렬(int[] A, int[] Q) {
        for (int i = A.length - 1; i >= 1; --i) {
            for (int j = 0; j < i; ++j) {
                if (A[j] > A[j + 1]) {
                    swap(A, j, j + 1);
                    swap(Q, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[] A = new int[N];
            int[] Q = new int[N];
            for (int i = 0; i < N; ++i) {
                A[i] = scanner.nextInt();
                Q[i] = i;
            }
            버블정렬(A, Q);

            int[] P = new int[N];
            for (int i = 0; i < N; ++i)
                P[Q[i]] = i;
            for (int i : P)
                System.out.printf("%d ", i);
            System.out.println();
        }
    }
}
