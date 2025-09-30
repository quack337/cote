package baekjoon.b10826.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static BigInteger fib(int N) {
        if (N < 2) return BigInteger.valueOf(N);
        BigInteger[] a = new BigInteger[N+1];
        a[0] = BigInteger.valueOf(0);
        a[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= N; ++i)
            a[i] = a[i-1].add(a[i-2]);
        return a[N];
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        System.out.println(fib(N));
    }
}