package baekjoon.p10.p10451;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int N = scanner.nextInt();
                int[] A = new int[N];
                for (int i = 0; i < N; ++i)
                    A[i] = scanner.nextInt() - 1;

                int 사이클수 = 0;
                boolean[] visited = new boolean[N];
                for (int i = 0; i < N; ++i) {
                    if (visited[i]) continue;
                    visited[i] = true;
                    int j = A[i];
                    while (true) {
                        if (visited[j]) break;
                        visited[j] = true;
                        j = A[j];
                    }
                    ++사이클수;
                }
                System.out.println(사이클수);
            }
        }
    }
}
