package baekjoon.b11.p11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MOD = 10007;
    static int[][] DP;

    static int nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        if (r == 0 || r == n) return 1;
        if (DP[n][r] > 0) return DP[n][r];
        return DP[n][r] = (nCr(n-1, r-1) % MOD + nCr(n - 1, r) % MOD) % MOD;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        DP = new int[N+1][K+1];
        System.out.println(nCr(N, K));
    }
}