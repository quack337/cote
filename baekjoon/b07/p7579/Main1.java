package baekjoon.b07.p7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
    static final int INF = 1_000_000_000;
    static int N, M;
    static int[] 메모리, 비용;

    static int sol(int index, int 부족한메모리) {
        if (부족한메모리 <= 0) return 0;
        if (index == N) return INF;
        int 비용1 = sol(index + 1, 부족한메모리);
        int 비용2 = 비용[index] + sol(index + 1, 부족한메모리 - 메모리[index]);
        return Math.min(비용1, 비용2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        메모리 = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            메모리[i] = Integer.parseInt(tokenizer.nextToken());
        비용 = new int[N];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i)
            비용[i] = Integer.parseInt(tokenizer.nextToken());
        System.out.println(sol(0, M));
    }
}