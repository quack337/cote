package baekjoon.b1003;
public class Fibonacci5 {

    static void fib(int n) {
        int[] 문자0출력수 = new int[n+1];
        int[] 문자1출력수 = new int[n+1];
        문자0출력수[0] = 1; 문자0출력수[1] = 0;
        문자1출력수[0] = 0; 문자1출력수[1] = 1;
        for (int i = 2; i <= n; ++i) {
            문자0출력수[i] = 문자0출력수[i-1] + 문자0출력수[i-2];
            문자1출력수[i] = 문자1출력수[i-1] + 문자1출력수[i-2];
        }
        for (int i = 0; i <= n; ++i)
            System.out.printf("fib(%d) 0출력수=%d, 1출력수=%d\n", i, 문자0출력수[i], 문자1출력수[i]);
    }

    public static void main(String[] args) {
        fib(10);
    }
}