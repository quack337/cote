package baekjoon.p01.p1992;

import java.util.Scanner;

public class Main {
    static char[][] A;

    static boolean 단일문자인가(int 행, int 열, int 크기) {
        char ch = A[행][열];
        for (int r = 행; r < 행 + 크기; ++r)
            for (int c = 열; c < 열 + 크기; ++c)
                if (A[r][c] != ch) return false;
        return true;
    }

    static String 압축(int 행, int 열, int 크기) {
        if (크기 == 1 || 단일문자인가(행, 열, 크기))
            return String.valueOf(A[행][열]);
        int 새크기 = 크기 / 2;
        return "(" + 압축(행, 열, 새크기) + 압축(행, 열+새크기, 새크기)
                   + 압축(행+새크기, 열, 새크기) + 압축(행+새크기, 열+새크기, 새크기) + ")";
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            A = new char[N][];
            for (int i = 0; i < A.length; ++i)
                A[i] = scanner.next().toCharArray();
            System.out.println(압축(0, 0, N));
        }
    }
}
