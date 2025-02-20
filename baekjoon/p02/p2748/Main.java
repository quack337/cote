package baekjoon.p02.p2748;

import java.util.Scanner;

public class Main {
    static long fib(int n) {
        if (n <= 1) return n;
        long f0 = 0, f1 = 1, f2 = 0;
        for (int i = 2; i <= n; ++i) {
            f2 = f1 + f0;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            System.out.println(fib(n));
        }
    }
}
