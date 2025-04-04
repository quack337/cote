package baekjoon.b17.p17435;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int M = scanner.nextInt();
            int N = (int)(Math.log(500_0000) / Math.log(2));
            var DP = new int[M + 1][N];
            for (int x = 1; x <= M; ++x)
                DP[x][0] = scanner.nextInt();
            for (int n = 1; n < N; ++n)
                for (int x = 1; x <= M; ++x) {
                    int x2 = DP[x][n - 1];
                    DP[x][n] = DP[x2][n - 1];
                }
            int Q = scanner.nextInt();
            for (int q = 0; q < Q; ++q) {
                int n = scanner.nextInt();
                int x = scanner.nextInt();
                for (int i = 0; i < N; ++i) {
                    int bit = (n >> i) & 1;
                    if (bit == 1) x = DP[x][i];
                }
                System.out.println(x);
            }
        }
    }
}