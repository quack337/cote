package baekjoon.b02.p2749;

import java.util.Scanner;

public class Main {

    static final int M = 1000000;

    static int fib(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int f0 = 0;
        int f1 = 1;
        int f2 = 2;
        for (long i = 2; i <= n; ++i) {
            f2 = (f1 + f0) % M;
            f0 = f1;
            f1 = f2;
        }
        return f1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            long n = scanner.nextLong();
            System.out.println(fib(n % (M * 3)));
        }
    }
}