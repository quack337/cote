package baekjoon.b01.b1011;

import java.util.Scanner;

public class Main {

    static int 탐색(int 거리) {
        int n = (int)Math.sqrt(거리);
        if (거리 == n*n) return 2*n - 1;
        if (n*n < 거리 && 거리 <= n*n+n) return 2*n;
        return 2*n + 1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            for (int i = 0; i < N; ++i) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                System.out.println(탐색(end - start));
            }
        }
    }
}