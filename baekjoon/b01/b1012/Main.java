package baekjoon.b01.b1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static void DFS(int[][] A, int r, int c) {
        if (r < 0 || r >= A.length) return;
        if (c < 0 || c >= A[0].length) return;
        if (A[r][c] != 1) return;
        A[r][c] = 0;
        DFS(A, r-1, c);
        DFS(A, r+1, c);
        DFS(A, r, c-1);
        DFS(A, r, c+1);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for (int t = 0; t < T; ++t) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(tokenizer.nextToken());
            int N = Integer.parseInt(tokenizer.nextToken());
            int K = Integer.parseInt(tokenizer.nextToken());
            int[][] A = new int[M][N];
            for (int k = 0; k < K; ++k) {
                tokenizer = new StringTokenizer(reader.readLine());
                int r = Integer.parseInt(tokenizer.nextToken());
                int c = Integer.parseInt(tokenizer.nextToken());
                A[r][c] = 1;
            }
            int count = 0;
            for (int r = 0; r < A.length; ++r)
                for (int c = 0; c < A[0].length; ++c)
                    if (A[r][c] == 1) {
                        ++count;
                        DFS(A, r, c);
                    }
            System.out.println(count);
        }
    }
}