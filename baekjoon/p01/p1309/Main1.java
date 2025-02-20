package baekjoon.p01.p1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    static int N;

    static int 경우의수(int index, int previous) {
        if (index == N) return 1;
        int count = 0;
        count += 경우의수(index + 1, 0);
        if (previous != 1) count += 경우의수(index + 1, 1);
        if (previous != 2) count += 경우의수(index + 1, 2);
        return count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        System.out.println(경우의수(0, 0));
    }
}
