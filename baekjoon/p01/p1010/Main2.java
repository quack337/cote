package baekjoon.p01.p1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static Integer[][] DP = new Integer[30][30];

    static int DFS(int n, int m) {
        if (n == 0) return DP[n][m] = 1;
        if (m == 0) return DP[n][m] = 0;
        if (DP[n][m] != null) return DP[n][m];
        return DP[n][m] = DFS(n, m - 1) + DFS(n - 1, m - 1);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder builder = new StringBuilder();
        for (int test = 0; test < T; ++test) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(tokenizer.nextToken());
            int M = Integer.parseInt(tokenizer.nextToken());
            DFS(N, M);
            builder.append(DP[N][M]).append('\n');
        }
        System.out.println(builder);
    }
}
