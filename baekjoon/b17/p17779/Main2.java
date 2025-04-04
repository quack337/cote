package baekjoon.b17.p17779;

import java.util.Scanner;

public class Main2 {
    static int N;
    static int[][] A;

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
    }

    static int 인구차이(int[][] B) {
        var 인구 = new int[6];
        for (int r = 1; r <= N; ++r)
            for (int c = 1; c <= N; ++c) {
                int 선거구 = B[r][c];
                인구[선거구] += A[r][c];
            }
        int 최소 = Integer.MAX_VALUE, 최대 = Integer.MIN_VALUE;
        for (int 선거구 = 1; 선거구 <= 5; ++선거구) {
            if (인구[선거구] > 최대) 최대 = 인구[선거구];
            if (인구[선거구] < 최소) 최소 = 인구[선거구];
        }
        return 최대 - 최소;
    }

    static int solution() {
        int 최소값 = Integer.MAX_VALUE;
        for (int x = 1; x <= N; ++x)
        for (int y = 1; y <= N; ++y)
        for (int d1 = 1; d1 < N; ++d1)
        for (int d2 = 1; d2 < N; ++d2) {
            if (x + d1 + d2 > N) continue;
            if (y - d1 < 1) continue;
            if (y + d2 > N) continue;
            int[][] B = new int[N + 1][N + 1];
            선거구표시(B, x, y, d1, d2);
            int 차이 = 인구차이(B);
            if (차이 < 최소값) 최소값 = 차이;
        }
        return 최소값;
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            A = new int[N + 1][N + 1];
            for (int r = 1; r <= N; ++r)
                for (int c = 1; c <= N; ++c)
                    A[r][c] = scanner.nextInt();
            System.out.println(solution());
        }
    }

}