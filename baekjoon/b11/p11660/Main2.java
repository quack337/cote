package baekjoon.b11.p11660;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        var tokennizer = new StringTokenizer(s);
        int N = Integer.parseInt(tokennizer.nextToken());
        int M = Integer.parseInt(tokennizer.nextToken());
        int[][] A = new int[N + 1][N + 1];
        for (int r = 1; r <= N; ++r) {
            s = reader.readLine();
            tokennizer = new StringTokenizer(s);
            for (int c = 1; c <= N; ++c)
              A[r][c] = Integer.parseInt(tokennizer.nextToken());
        }
        int[][] S = new int[N + 1][N + 1];
        for (int r = 1; r <= N; ++r)
            for (int c = 1; c <= N; ++c)
              S[r][c] = S[r][c - 1] + S[r - 1][c] - S[r - 1][c - 1] + A[r][c];
        for (int i = 0; i < M; ++i) {
          s = reader.readLine();
          tokennizer = new StringTokenizer(s);
          int r1 = Integer.parseInt(tokennizer.nextToken());
          int c1 = Integer.parseInt(tokennizer.nextToken());
          int r2 = Integer.parseInt(tokennizer.nextToken());
          int c2 = Integer.parseInt(tokennizer.nextToken());
          int answer = S[r2][c2] - S[r1 - 1][c2] - S[r2][c1 - 1] + S[r1 - 1][c1 - 1];
          writer.write(answer + "\n");
        }
        reader.close();
        writer.close();
    }
}