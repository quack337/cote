package baekjoon.p09.p9084;

import java.util.Scanner;

public class Main1 {

    static void sol(int[] 동전목록, int 금액) {
        int[] DP = new int[금액 + 1];
        DP[0] = 1;
        for (int 동전 : 동전목록)
            for (int i = 동전; i < DP.length; ++i)
                DP[i] = DP[i] + DP[i - 동전];
        System.out.println(DP[금액]);
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int N = scanner.nextInt();
                int[] 동전목록 = new int[N];
                for (int i = 0; i < N; ++i)
                    동전목록[i] = scanner.nextInt();
                int 금액 = scanner.nextInt();
                sol(동전목록, 금액);
            }
        }
    }
}