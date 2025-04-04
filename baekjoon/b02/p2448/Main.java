package baekjoon.b02.p2448;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static char[][] T = new char[][] { "  *  ".toCharArray(),
                                       " * * ".toCharArray(),
                                       "*****".toCharArray() };

    static void 생성(char[][] A, int 행, int 열, int 크기) {
        if (크기 == 3) {
            for (int r = 0; r < T.length; ++r)
                for (int c = 0; c < T[0].length; ++c)
                    A[행 + r][열 + c] = T[r][c];
            return;
        }
        생성(A, 행, 열 + 크기/2, 크기/2);
        생성(A, 행 + 크기/2, 열, 크기/2);
        생성(A, 행 + 크기/2, 열 + 크기, 크기/2);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            char[][] A = new char[N][N * 2 - 1];
            for (char[] a : A)
                Arrays.fill(a, ' ');
            생성(A, 0, 0, N);
            for (char[] a : A)
                System.out.println(a);
        }
    }
}