package baekjoon.b1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

  public static void main(String[] args) throws NumberFormatException, IOException {
    int[][] C = new int[30][30];
    for (int n = 0; n < 30; ++n)
      C[n][n] = C[n][0] = 1;
    for (int n = 2; n < 30; ++n)
      for (int r = 1; r < n; ++r)
        C[n][r] = C[n - 1][r - 1] + C[n - 1][r];

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(reader.readLine());
    StringBuilder builder = new StringBuilder();
    for (int test = 0; test < T; ++test) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int n = Integer.parseInt(tokenizer.nextToken());
      int m = Integer.parseInt(tokenizer.nextToken());
      builder.append(C[m][n]).append('\n');
    }
    System.out.println(builder);
  }
}