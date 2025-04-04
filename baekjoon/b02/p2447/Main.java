package baekjoon.b02.p2447;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static void 생성(char[][] A, int 행, int 열, int 크기) {
        if (크기 == 1) {
            A[행][열] = '*';
            return;
        }
        for (int r = 0; r < 3; ++r)
            for (int c = 0; c < 3; ++c) {
                if (r == 1 && c == 1) continue;
                생성(A, 행 + (r * 크기/3), 열 + (c * 크기/3), 크기/3);
            }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            char[][] A = new char[N][N];
            for (char[] a : A)
                Arrays.fill(a, ' ');
            생성(A, 0, 0, N);
            for (char[] a : A)
                System.out.println(a);
        }
    }
}