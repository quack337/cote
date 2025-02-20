package net.skhu.line.e2018;

import java.math.BigInteger;
import java.util.Scanner;

public class NumberOfCases1 {

    static BigInteger f(int n) { // factorial
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 2; i <= n; ++i)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            for (int i = 0; i < count; ++i) {
                int N = scanner.nextInt();
                int K = scanner.nextInt();
                int M = scanner.nextInt();

                int H = K - M;
                BigInteger r1 = f(N).divide(f(M)).divide(f(N - M));
                BigInteger r2 = f(N).divide(f(H)).divide(f(N - H));
                BigInteger r = r1.multiply(r2).remainder(BigInteger.valueOf(1003001));
                System.out.println(r);
            }
        }
    }
}
