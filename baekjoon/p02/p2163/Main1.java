package baekjoon.p02.p2163;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static int 쪼개기횟수(int n, int m) {
        if (n == 1 && m == 1) return 0;
        if (n > m)
            return 1 + 쪼개기횟수(n/2, m) + 쪼개기횟수(n - n/2, m);
        else
            return 1 + 쪼개기횟수(n, m/2) + 쪼개기횟수(n, m - m/2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        System.out.println(쪼개기횟수(N, M));
    }
}
