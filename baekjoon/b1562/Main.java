package baekjoon.b1562;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Integer[][][] DP = new Integer[1001][10][0x400];

    static int sol(int N, int prev, int mask) {
        int result = 0;
        if (DP[N][prev][mask] != null) return DP[N][prev][mask];
        if (N == 0) result = (mask == 0x3FF ? 1: 0);
        else if (prev == 0) result = sol(N-1, 1, mask | (1 << 1));
        else if (prev == 9) result = sol(N-1, 8, mask | (1 << 8));
        else result = (   sol(N-1, prev-1, mask | (1 << (prev-1)))
                        + sol(N-1, prev+1, mask | (1 << (prev+1)))
                      ) % 1_000_000_000;
        return DP[N][prev][mask] = result;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int answer = 0;
        for (int prev = 1; prev <= 9; ++prev)
            answer = (answer + sol(N-1, prev, 1 << prev)) % 1_000_000_000;
        System.out.println(answer);
    }
}