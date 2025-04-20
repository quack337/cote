package baekjoon.b17779;
import java.util.Scanner;

public class Main1 {
    static int N;
    static int[][] A;

    static void print(int[][] B) {
        for (int r = 1; r <= N; ++r) {
            for (int c = 1; c <= N; ++c)
                System.out.printf("%d ", B[r][c]);
            System.out.println();
        }
        System.out.println();
    }

    static void 선거구표시(int[][] B, int x, int y, int d1, int d2) {
        // 5 선거구
        int c1 = y, c2 = y;
        for (int i = 0; i <= d1 + d2; ++i) {
            int r = x + i;
            for (int c = c1; c <= c2; ++c)
                B[r][c] = 5;
            if (i < d1) --c1; else ++c1;
            if (i < d2) ++c2; else --c2;
        }
        // 1선거구
        for (int r = 1; r < x + d1; ++r)
            for (int c = 1; c <= y; ++c)
                if (B[r][c] == 0) B[r][c] = 1;
        // 2선거구
        for (int r = 1; r <= x + d2; ++r)
            for (int c = y + 1; c <= N; ++c)
                if (B[r][c] == 0) B[r][c] = 2;
        // 3선거구
        for (int r = x + d1; r <= N; ++r)
            for (int c = 1; c < y - d1 + d2; ++c)
                if (B[r][c] == 0) B[r][c] = 3;
        // 4선거구
        for (int r = x + d2 + 1; r <= N; ++r)
            for (int c = y - d1 + d2; c <= N; ++c)
                if (B[r][c] == 0) B[r][c] = 4;
        print(B);
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            A = new int[N + 1][N + 1];
            for (int r = 1; r <= N; ++r)
                for (int c = 1; c <= N; ++c)
                    A[r][c] = scanner.nextInt();
            int[][] B = new int[N + 1][N + 1];
            선거구표시(B, 2, 4, 2, 2);
        }
    }
}

/* 예제 입력
7
1 1 1 1 1 1 1
1 1 1 1 1 1 1
1 1 1 1 1 1 1
1 1 1 1 1 1 1
1 1 1 1 1 1 1
1 1 1 1 1 1 1

*/