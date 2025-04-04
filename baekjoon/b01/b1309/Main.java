package baekjoon.b01.b1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int MOD = 9901;
    static int N;
    static int[][] DP;

    static int 경우의수(int index, int previous) {
        if (index == N) return 1;
        if (DP[index][previous] > 0) return DP[index][previous];
        int count = 0;
        count = (count + 경우의수(index + 1, 0)) % MOD;
        if (previous != 1) count = (count + 경우의수(index + 1, 1)) % MOD;
        if (previous != 2) count = (count + 경우의수(index + 1, 2)) % MOD;
        return DP[index][previous] = count % MOD;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        DP = new int[N][3];
        System.out.println(경우의수(0, 0));
    }
}