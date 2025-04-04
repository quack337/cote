package baekjoon.b02.p2631;

import java.util.Scanner;

public class Main1a {
    static int[] A;

    static int sol(int index, int previous) {
        if (index >= A.length) return 0;
        int r1 = 0, r2 = 0;
        if (A[index] > previous) r1 = 1 + sol(index + 1, A[index]);
        r2 = sol(index + 1, previous);
        return Math.max(r1, r2);
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            A = new int[N];
            for (int i = 0; i < N; ++i)
                A[i] = scanner.nextInt();
            int length = sol(0, 0);
            System.out.println(N - length);
        }
    }
}