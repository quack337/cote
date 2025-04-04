package baekjoon.b01.b1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static int N;

    static long count(long n) {
        long sum = 0;
        for (int i = 1; i <= Math.min(N, n); ++i)
           sum += Math.min(N, n / i);
        return sum;
    }

    static long 이진탐색(long K) {
        long start = 1, end = (long)N * N;
        while (start < end) {
            long middle = (start + end) / 2;
            long cnt = count(middle);
            if (cnt < K)
                start = middle + 1;
            else
                end = middle;
        }
        return start;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        long K = Long.parseLong(reader.readLine());
        System.out.println(이진탐색(K));
    }
}