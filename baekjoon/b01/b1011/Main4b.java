package baekjoon.b01.b1011;

import java.util.Scanner;

public class Main4b {

    static int 점프수(int X) {
        int 거리 = 1;
        int 점프수 = 1;
        int 반복수 = 1;
        while (true) {
            for (int j = 0; j < 2; ++j) {
                for (int i = 0; i < 반복수; ++i) {
                    if (거리 == X) return 점프수;
                    ++거리;
                }
                ++점프수;
            }
            ++반복수;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            for (int i = 0; i < N; ++i) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                System.out.println(점프수(end - start));
            }
        }
    }
}