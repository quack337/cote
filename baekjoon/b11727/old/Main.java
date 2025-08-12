package baekjoon.b11727.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 10007;
    static int[] DP;

    static int 경우의수(int n) {
        if (n == 0) return 1;
        if (DP[n] > 0) return DP[n];
        int count = 0;
        if (n >= 2) count = (count + 경우의수(n - 2) * 2) % MOD;
        count = (count + 경우의수(n - 1)) % MOD;
        return DP[n] = count % MOD;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        DP = new int[N+1];
        System.out.println(경우의수(N));
    }
}