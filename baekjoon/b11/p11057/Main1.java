package baekjoon.b11.p11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static int N;
    static int MOD = 10007;

    static int 탐색(int index, int previous) {
        if (index == N) return 1;
        int count = 0;
        for (int i = previous; i <= 9; ++i)
            count += 탐색(index + 1, i) % MOD;
        return count % MOD;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        System.out.println(탐색(0, 0));
    }

}