package baekjoon.b17.p17435;

import java.util.Scanner;

public class Main1 {
    static int query(int[] F, int n, int x) {
        for (int i = 0; i < n; ++i)
            x = F[x];
        return x;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int M = scanner.nextInt();
            var F = new int[M + 1];
            for (int i = 1; i <= M; ++i)
                F[i] = scanner.nextInt();
            int Q = scanner.nextInt();
            for (int q = 0; q < Q; ++q) {
                int n = scanner.nextInt();
                int x = scanner.nextInt();
                System.out.println(query(F, n, x));
            }
        }
    }
}