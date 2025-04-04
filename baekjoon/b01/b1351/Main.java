package baekjoon.b01.b1351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long P, Q;
    static long[] DP = new long[1000 * 1000];

    static long A(long n) {
        if (n < DP.length) {
            int i = (int)n;
            if (DP[i] > 0) return DP[i];
            if (n == 0) return DP[i] = 1;
            return DP[i] = A(i / P) + A(i / Q);
        }
        return A(n / P) + A(n / Q);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long N = Long.parseLong(tokenizer.nextToken());
        P = Long.parseLong(tokenizer.nextToken());
        Q = Long.parseLong(tokenizer.nextToken());
        System.out.println(A(N));
    }
}