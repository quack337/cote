package baekjoon.b10.p10250;

import java.util.Scanner;

public class Main {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int i = 0; i < T; ++i) {
                int H = scanner.nextInt();
                int W = scanner.nextInt();
                int N = scanner.nextInt();
                int 열 = (N-1) / H + 1;
                int 행 = N % H;
                if (행 == 0) 행 = H;
                System.out.printf("%d%02d\n", 행, 열);
            }
        }
    }
}