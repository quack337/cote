package baekjoon.p01.p1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, S;
    static int[] V;
    static int[][] DP;

    static int 탐색(int index, int 이전볼륨) {
        if (이전볼륨 < 0 || 이전볼륨 > M) return -1;
        if (index == N) return 이전볼륨;
        if (DP[index][이전볼륨] != Integer.MIN_VALUE) return DP[index][이전볼륨];
        int r1 = 탐색(index + 1, 이전볼륨 + V[index]);
        int r2 = 탐색(index + 1, 이전볼륨 - V[index]);
        return DP[index][이전볼륨] = Math.max(r1, r2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        S = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        V = new int[N];
        DP = new int[N][M+1];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; ++i) {
            V[i] = Integer.parseInt(tokenizer.nextToken());
            Arrays.fill(DP[i], Integer.MIN_VALUE);
        }
        reader.close();
        System.out.println(탐색(0, S));
    }
}
