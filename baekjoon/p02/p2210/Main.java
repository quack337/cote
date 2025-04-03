package baekjoon.p02.p2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[][] A = new int[5][5];
    static HashSet<Integer> set = new HashSet<>();

    static void 완전탐색(int r, int c, int count, int number) {
        if (r < 0 || c < 0 || 5 <= r || 5 <= c) return;
        number = number * 10 + A[r][c];
        if (count + 1 == 6) {
            set.add(number);
            return;
        }
        완전탐색(r, c - 1, count + 1, number);
        완전탐색(r, c + 1, count + 1, number);
        완전탐색(r - 1, c, count + 1, number);
        완전탐색(r + 1, c, count + 1, number);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int r = 0; r < 5; ++r) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < 5; ++c)
                A[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        for (int r = 0; r < 5; ++r)
            for (int c = 0; c < 5; ++c)
                완전탐색(r, c, 0, 0);
        System.out.println(set.size());
    }
}