package baekjoon.b12.p12852;

import java.util.Scanner;

public class Main2 {

    static int[] DP;

    static void print(int x) {
        if (x == 1) {
            System.out.println(1);
            return;
        }
        System.out.print(x + " ");
        int y = x - 1;
        if (x % 3 == 0 && DP[x / 3] < DP[y]) y = x / 3;
        if (x % 2 == 0 && DP[x / 2] < DP[y]) y = x / 2;
        print(y);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int x = scanner.nextInt();
            DP = new int[Math.max(4, x + 1)];
            DP[1] = 0;
            DP[2] = DP[3] = 1;
            for (int i = 4; i <= x; ++i) {
                DP[i] = DP[i - 1] + 1;
                if (i % 3 == 0) DP[i] = Math.min(DP[i], DP[i / 3] + 1);
                if (i % 2 == 0) DP[i] = Math.min(DP[i], DP[i / 2] + 1);
            }
            System.out.println(DP[x]);
            print(x);
        }
    }
}