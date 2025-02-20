package baekjoon.p01.p1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3 {
    static long power(long a, long b, long c) {
        if (b == 0) return 1;
        if (b == 1) return a % c;
        if (b % 2 == 0) {
            long r = power(a, b / 2, c);
            return (r * r) % c;
        } else {
            long r = power(a, b / 2, c);
            return (((r * r) % c) * a) % c;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int A = Integer.parseInt(tokenizer.nextToken());
        int B = Integer.parseInt(tokenizer.nextToken());
        int C = Integer.parseInt(tokenizer.nextToken());
        System.out.println(power(A, B, C));
    }
}
