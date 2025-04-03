package baekjoon.p03.p3176;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[][] B1 = new int[N + 1][N + 1];
            for (int[] a : B1)
                Arrays.fill(a, INF);
            for (int i = 0; i < N - 1; ++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int distance = scanner.nextInt();
                B1[a][b] = distance;
                B1[b][a] = distance;
            }
            for (int i = 1; i <= N; ++i) {
                for (int a = 1; a <= N; ++a)
                    for (int b = 1; b <= N; ++b)
                        B1[a][b] = Math.min(B1[a][b], B1[a][i] + B1[i][b]);
            }
            int K = scanner.nextInt();
            for (int i = 0; i < K; ++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println(B1[a][b]);
            }
        }

    }

}