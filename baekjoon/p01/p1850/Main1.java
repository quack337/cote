package baekjoon.p01.p1850;

public class Main1 {
    static long 최대공약수(long a, long b){
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static Long num(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; ++i)
            builder.append("1");
        return Long.parseLong(builder.toString());
    }

    public static void main(String[] args) {
        for (int a = 2; a <= 10; ++a)
            for (int b = 2; b <= 19; ++b) {
                long A = num(a);
                long B = num(b);
                long G = 최대공약수(A, B);
                int g = String.valueOf(G).length();
                System.out.printf("%,20d (%2d) %,25d (%2d) %,25d (%2d)\n", A, a, B, b, G, g);
            }
    }
}
