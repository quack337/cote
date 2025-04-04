package baekjoon.b09.p9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    static boolean valid(int[] queen, int row, int col) {
        for (int r = 0; r < row; ++r) {
            if (queen[r] == col) return false;
            if (queen[r] - r == col - row) return false;
            if (queen[r] + r == col + row) return false;
        }
        return true;
    }

    static int 경우의수(int[] queen, int row) {
        if (row >= N) return 1;
        int sum = 0;
        for (int col = 0; col < N; ++col) {
            if (valid(queen, row, col)) {
                queen[row] = col;
                sum += 경우의수(queen, row + 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        int[] queen = new int[N];
        System.out.println(경우의수(queen, 0));
    }
}