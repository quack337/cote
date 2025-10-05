package baekjoon.b2169.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int N, M;
    static int[][] A;
    static final int DOWN = 0, LEFT = -1, RIGHT = 1;
    static Integer[][][] DP;

    static int sol(int row, int col, int dir) {
        if (DP[row][col][dir+1] != null) return DP[row][col][dir+1];
        int max = -1_000_000_000;
        if (row == N-1 && col == M-1) return A[row][col];
        if (row < N-1) max = Math.max(max, A[row][col] + sol(row + 1, col, DOWN));
        if (col < M-1 && dir != LEFT) max = Math.max(max, A[row][col] + sol(row, col + 1, RIGHT));
        if (col > 0 && dir != RIGHT) max = Math.max(max, A[row][col] + sol(row, col - 1, LEFT));
        return DP[row][col][dir+1] = max;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(tokenizer.nextToken());
        M = Integer.parseInt(tokenizer.nextToken());
        A = new int[N][M];
        DP = new Integer[N][M][3];
        for (int r = 0; r < N; ++r) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int c = 0; c < M; ++c)
                A[r][c] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(sol(0, 0, DOWN));
    }
}