package baekjoon.b09.p9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] 경우의수(int max) {
        int[] DP = new int[max+1];
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;
        for (int i = 4; i <= max; ++i)
            DP[i] = DP[i - 3] + DP[i - 2] + DP[i - 1];
        return DP;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        int[] DP = 경우의수(11);
        for (int t = 0; t < T; ++t) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(DP[n]);
        }
    }
}