package baekjoon.b11057.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int MOD = 10007;
    static int[][] DP;

    static int 탐색(int index, int previous) {
        if (index == N) return 1;
        if (DP[index][previous] > 0) return DP[index][previous];
        int count = 0;
        for (int i = previous; i <= 9; ++i)
            count += 탐색(index + 1, i) % MOD;
        return DP[index][previous] = count % MOD;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        DP = new int[N][10];
        System.out.println(탐색(0, 0));
    }
}