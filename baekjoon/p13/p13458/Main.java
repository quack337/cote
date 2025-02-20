package baekjoon.p13.p13458;

import java.util.Scanner;

public class Main {

    static int 올림_나눗셈(int 분자, int 분모) {
        return (분자 + 분모 - 1) / 분모;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 시험장_수 = scanner.nextInt();
            int[] 시험장목록 = new int[시험장_수];
            for (int i = 0; i < 시험장목록.length; ++i)
                시험장목록[i] = scanner.nextInt();
            int 총감독_감시 = scanner.nextInt();
            int 부감독_감시 = scanner.nextInt();

            long 감독관_수 = 0;
            for (int 응시자 : 시험장목록) {
                int 부감독관 = 올림_나눗셈(응시자 - 총감독_감시, 부감독_감시);
                if (부감독관 < 0) 부감독관 = 0;
                감독관_수 += (1 + 부감독관);
            }
            System.out.println(감독관_수);
        }
    }
}
