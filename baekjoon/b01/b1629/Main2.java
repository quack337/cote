package baekjoon.b01.b1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static long power1(long a, long b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        if (b % 2 == 0) {
            long r = power1(a, b / 2);
            return r * r;
        } else {
            long r = power1(a, b / 2); // b가 홀수인 경우에 (b-1)/2 == b/2 이다.
            return r * r * a;
        }
    }

    static long power2(long a, long b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        long r = power1(a, b / 2);
        return (b % 2 == 0) ? r * r : r * r * a;
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());
        System.out.println(power1(A, B));
    }
}