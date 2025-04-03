package baekjoon.p23.p23291;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

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
            System.out.println(Arrays.toString(A));
        }
    }
}