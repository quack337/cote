package baekjoon.p01.p1074;

import java.util.Scanner;

public class Main {
    static int 탐색(int 시작행, int 시작열, int 시작번호, int n, int 찾을행, int 찾을열) {
        if (n == 0) return 시작번호;
        int 크기 = (int)Math.pow(2, n);
        int r = (찾을행 >= 시작행 + 크기/2) ? 1 : 0;
        int c = (찾을열 >= 시작열 + 크기/2) ? 1 : 0;
        int 시작행1 = 시작행 + (r * 크기/2);
        int 시작열1 = 시작열 + (c * 크기/2);
        int 시작번호1 = 시작번호 + (r * 2 + c) * (int)Math.pow(2, 2 * (n - 1));
        return 탐색(시작행1, 시작열1, 시작번호1, n-1, 찾을행, 찾을열);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println(탐색(0, 0, 0, N, r, c));
        }
    }
}