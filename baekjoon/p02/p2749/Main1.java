package baekjoon.p02.p2749;

public class Main1 {
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

    static boolean 일치하는가(int x) {
        for (int n = 0; n <= 10; ++n)
            if (fib(n) != fib(n + M*x)) return false;
        return true;
    }

    public static void main(String[] args) {
        for (int x = 1; x <= 10; ++x) {
            if (일치하는가(x)) {
                System.out.printf("x = %d\n", x);
                for (int n = 0; n <= 10; ++n)
                    System.out.printf("fib(%d)=%d fib(%,d)=%d\n", n, fib(n), n + x * M, fib(n + x * M));
            }
        }
    }
}