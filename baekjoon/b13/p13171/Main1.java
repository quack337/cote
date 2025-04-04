package baekjoon.b13.p13171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static final long MOD = 1000000007;

    static long power(long a, long x) {
        if (x == 1) return a % MOD;
        if (x % 2 == 0) {
            long value = power(a, x/2);
            return (value * value) % MOD;
        } else {
            long value = power(a, x/2);
            return (((value * value) % MOD) * a) % MOD;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long A = Long.parseLong(reader.readLine());
        long X = Long.parseLong(reader.readLine());
        A = A % MOD;
        System.out.println(power(A, X));
    }
}