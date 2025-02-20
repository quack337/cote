package baekjoon.p14.p14502;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static byte[][] clone(byte[][] 게임판) {
        byte[][] 새게임판 = new byte[게임판.length][];
        for (int i = 0; i < 게임판.length; ++i)
            새게임판[i] = Arrays.copyOf(게임판[i], 게임판[i].length);
        return 새게임판;
    }

    static void 바이러스전염(byte[][] 게임판, int y, int x) {
        if (y < 0 || y >= 게임판.length) return;
        if (x < 0 || x >= 게임판[y].length) return;
        if (게임판[y][x] != 0) return;
        게임판[y][x] = 2;
        바이러스전염(게임판, y - 1, x);
        바이러스전염(게임판, y + 1, x);
        바이러스전염(게임판, y, x - 1);
        바이러스전염(게임판, y, x + 1);
    }

    static void 바이러스전염(byte[][] 게임판) {
        for (int y = 0; y < 게임판.length; ++y)
            for (int x = 0; x < 게임판[y].length; ++x)
                if (게임판[y][x] == 2) {
                    바이러스전염(게임판, y - 1, x);
                    바이러스전염(게임판, y + 1, x);
                    바이러스전염(게임판, y, x - 1);
                    바이러스전염(게임판, y, x + 1);
                }
    }

    static int 안전지역수(byte[][] 게임판) {
        int count = 0;
        for (int y = 0; y < 게임판.length; ++y)
            for (int x = 0; x < 게임판[y].length; ++x)
                if (게임판[y][x] == 0)
                    ++count;
        return count;
    }

    static int 탐색(int 행수, int 열수, byte[][] 게임판) {
        int N = 행수 * 열수;
        int max = 0;
        for (int i1 = 0; i1 < N; ++i1) {
            int y1 = i1 / 열수;
            int x1 = i1 % 열수;
            if (게임판[y1][x1] != 0) continue;
            for (int i2 = i1 + 1; i2 < N; ++i2) {
                int y2 = i2 / 열수;
                int x2 = i2 % 열수;
                if (게임판[y2][x2] != 0) continue;
                for (int i3 = i2 + 1; i3 < N; ++i3) {
                    int y3 = i3 / 열수;
                    int x3 = i3 % 열수;
                    if (게임판[y3][x3] != 0) continue;
                    byte[][] 새게임판 = clone(게임판);
                    새게임판[y1][x1] = 1;
                    새게임판[y2][x2] = 1;
                    새게임판[y3][x3] = 1;
                    바이러스전염(새게임판);
                    int count = 안전지역수(새게임판);
                    if (count > max) max = count;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 행수 = scanner.nextInt();
            int 열수 = scanner.nextInt();
            byte[][] 게임판 = new byte[행수][];
            for (int 행 = 0; 행 < 행수; ++행) {
                게임판[행] = new byte[열수];
                for (int 열 = 0; 열 < 열수; ++열)
                    게임판[행][열] = scanner.nextByte();
            }
            int max = 탐색(행수, 열수, 게임판);
            System.out.println(max);
        }
    }
}
