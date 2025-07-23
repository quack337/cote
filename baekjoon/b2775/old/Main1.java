package baekjoon.b2775.old;
import java.util.Scanner;

public class Main1 {
    static int sum(int[][] a, int K, int N) {
        int s = 0;
        for (int n = 1; n <= N; ++n)
            s += a[K][n];
        return s;
    }

    static int solution(int K, int N) {
        int[][] a = new int[K + 1][N + 1];
        for (int n = 1; n <= N; ++n)
            a[0][n] = n;
        for (int k = 1; k <= K; ++k)
            for (int n = 1; n <= N; ++n)
                a[k][n] = sum(a, k - 1, n);
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