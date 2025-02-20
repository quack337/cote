package baekjoon.p03.p3176;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[][] distance = new int[N + 1][N + 1];
            int[][] min = new int[N + 1][N + 1];
            int[][] max = new int[N + 1][N + 1];
            for (int[] a : distance) Arrays.fill(a, INF);
            for (int[] a : min) Arrays.fill(a, INF);
            for (int[] a : max) Arrays.fill(a, 0);
            for (int i = 0; i < N - 1; ++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                int w = scanner.nextInt();
                max[a][b] = min[a][b] = distance[a][b] = w;
                max[b][a] = min[b][a] = distance[b][a] = w;
            }
            for (int i = 1; i <= N; ++i)
                for (int a = 1; a <= N; ++a)
                    for (int b = 1; b <= N; ++b)
                        if (a != b && distance[a][b] > distance[a][i] + distance[i][b]) {
                            distance[a][b] = distance[a][i] + distance[i][b];
                            min[a][b] = Math.min(min[a][b], Math.min(min[a][i], min[i][b]));
                            max[a][b] = Math.max(max[a][b], Math.max(max[a][i], max[i][b]));
                        }
            int K = scanner.nextInt();
            for (int i = 0; i < K; ++i) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.printf("%d %d\n", min[a][b], max[a][b]);
            }
        }
    }

}
