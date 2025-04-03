package baekjoon.p09.p9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {

    static int 경우의수(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        return 경우의수(n - 3) + 경우의수(n - 2) + 경우의수(n - 1);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(경우의수(n));
        }
    }
}