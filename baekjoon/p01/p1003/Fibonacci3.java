package baekjoon.p01.p1003;

public class Fibonacci3 {

    static void fib(int n) {
        if (n == 0) System.out.print('0');
        else if (n == 1) System.out.print('1');
        else { fib(n-1); fib(n-2); }
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; ++i) {
            System.out.printf("%d: ", i);
            fib(i);
            System.out.println();
        }
    }
}
