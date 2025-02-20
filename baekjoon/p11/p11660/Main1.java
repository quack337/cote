package baekjoon.p11.p11660;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main1 {
    public static void main(String[] args) throws Exception {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();
        var tokennizer = new StringTokenizer(s);
        int N = Integer.parseInt(tokennizer.nextToken());
        int M = Integer.parseInt(tokennizer.nextToken());
        int[][] A = new int[N][N];
        for (int r = 0; r < N; ++r) {
            s = reader.readLine();
            tokennizer = new StringTokenizer(s);
            for (int c = 0; c < N; ++c)
              A[r][c] = Integer.parseInt(tokennizer.nextToken());
        }
        int[][] S = new int[N][N];
        for (int r = 0; r < N; ++r)
            for (int c = 0; c < N; ++c) {
              if (r == 0 && c == 0) S[r][c] = A[r][c];
              else if (r == 0) S[r][c] = S[r][c - 1] + A[r][c];
              else if (c == 0) S[r][c] = S[r - 1][c] + A[r][c];
              else S[r][c] = S[r][c - 1] + S[r - 1][c] - S[r - 1][c - 1] + A[r][c];
            }
        for (int i = 0; i < M; ++i) {
          s = reader.readLine();
          tokennizer = new StringTokenizer(s);
          int r1 = Integer.parseInt(tokennizer.nextToken()) - 1;
          int c1 = Integer.parseInt(tokennizer.nextToken()) - 1;
          int r2 = Integer.parseInt(tokennizer.nextToken()) - 1;
          int c2 = Integer.parseInt(tokennizer.nextToken()) - 1;
          int answer = 0;
          if (r1 == 0 && c1 == 0) answer = S[r2][c2];
          else if (r1 == 0) answer = S[r2][c2] - S[r2][c1 - 1];
          else if (c1 == 0) answer = S[r2][c2] - S[r1 - 1][c2];
          else answer = S[r2][c2] - S[r1 - 1][c2] - S[r2][c1 - 1] + S[r1 - 1][c1 - 1];
          writer.write(answer + "\n");
        }
        reader.close();
        writer.close();
    }
}
