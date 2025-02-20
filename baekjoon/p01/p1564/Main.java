package baekjoon.p01.p1564;

import java.util.Scanner;

public class Main {

    static long f(int n) {
        long result = 1;
        for (int i = 2; i <= n; ++i) {
            int temp = i;
            while (temp % 10 == 0)
                temp /= 10;
            result *= temp;
            while (result % 10 == 0)
                result /= 10;
            result = result % 1000000000000L;
        }
        return result % 100000;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.printf("%05d\n", f(n));
        }
    }
}
