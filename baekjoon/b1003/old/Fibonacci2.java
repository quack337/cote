package baekjoon.b1003;
public class Fibonacci2 {

    static int fib(int n) {
        int[] a = new int[Math.max(2, n+1)];
        a[0] = 0; a[1] = 1;
        for (int i = 2; i <= n; ++i)
            a[i] = a[i-1] + a[i-2];
        return a[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; ++i)
            System.out.printf("%d: %d\n",  i, fib(i));
    }
}