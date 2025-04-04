package baekjoon.b01.b1018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    char[][] A;

    static int 칠할칸수(char[][] A, int row, int col) {
        int count = 0;
        for (int r = row; r < row + 8; ++r)
            for (int c = col; c < col + 8; ++c) {
                char ch = (r + c) % 2 == 0 ? 'B' : 'W';
                if (A[r][c] != ch) ++count;
            }
        return Math.min(count, 64 - count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        char[][] A = new char[N][];
        for (int i = 0; i < N; ++i)
            A[i] = reader.readLine().toCharArray();

        int min = 64;
        for (int r = 0; r < N - 7; ++r)
            for (int c = 0; c < M - 7; ++c) {
                int count = 칠할칸수(A, r, c);
                if (count < min) min = count;
            }
        System.out.println(min);
    }
}