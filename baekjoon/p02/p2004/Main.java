package baekjoon.p02.p2004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // n! 값의 소인수에서 factor의 갯수 구하기
    static long countFactor(int n, int factor) {
        long count = 0;
        for (long f = factor; n >= f; f = f * factor)
            count += n / f;
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());

        // nCm 분자인 n! 값의 소인수에서 2와 5의 갯수 구하기.
        long a2 = countFactor(N, 2), a5 = countFactor(N, 5);

        // nCm 분모인 m!, (n-m)! 값의 소인수에서 2와 5의 갯수 구하기.
        long b2 = countFactor(M, 2), b5 = countFactor(M, 5);
        long c2 = countFactor(N-M, 2), c5 = countFactor(N-M, 5);

        System.out.println(Math.min(a2-b2-c2, a5-b5-c5));
    }
}
