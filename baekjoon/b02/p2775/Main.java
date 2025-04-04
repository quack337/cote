package baekjoon.b02.p2775;

import java.util.Scanner;

public class Main {

    static int solution(int K, int N) {
        int[][] a = new int[K + 1][N + 1];
        for (int n = 1; n <= N; ++n)
            a[0][n] = n;
        for (int k = 1; k <= K; ++k)
            for (int n = 1; n <= N; ++n)
                a[k][n] = a[k][n - 1] + a[k - 1][n];
        return a[K][N];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int k = scanner.nextInt();
                int n = scanner.nextInt();
                System.out.println(solution(k, n));
            }

        }
    }
}