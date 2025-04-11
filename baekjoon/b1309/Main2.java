package baekjoon.b1309;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    static int N;
    static int[][] DP;

    static int 경우의수(int index, int previous) {
        if (index == N) return 1;
        if (DP[index][previous] > 0) return DP[index][previous];
        int count = 0;
        count += 경우의수(index + 1, 0);
        if (previous != 1) count += 경우의수(index + 1, 1);
        if (previous != 2) count += 경우의수(index + 1, 2);
        return DP[index][previous] = count;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        DP = new int[N][3];
        System.out.println(경우의수(0, 0));
    }
}