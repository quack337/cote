package baekjoon.p01.p1003;

public class Fibonacci4 {

    static int fib0(int n) {
        if (n == 0) return 1;
        else if (n == 1) return 0;
        else return fib0(n-1) + fib0(n-2);
    }

    static int fib1(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return fib1(n-1) + fib1(n-2);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; ++i)
            System.out.printf("fib(%d) 0출력수=%d, 1출력수=%d\n", i, fib0(i), fib1(i));
    }
}
