package baekjoon.p01.p1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static final int MOD = 15746;
    static int N;
    static int[] DP;

    static int 경우의수(int length) {
        if (length == 0) return 1;
        if (DP[length] > 0) return DP[length];
        int sum = 0;
        if (length >= 2) sum += 경우의수(length - 2);
        sum += 경우의수(length - 1);
        return DP[length] = sum;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        DP = new int[N+1];
        System.out.println(경우의수(N));
    }
}
