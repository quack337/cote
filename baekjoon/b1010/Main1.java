package baekjoon.b1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {
  static int nCr(int n, int r) {
    if (r < 0 || r > n) return 0;
    if (r == 0 || r == n) return 1;
    return nCr(n - 1, r - 1) + nCr(n - 1, r);
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(reader.readLine());
    StringBuilder builder = new StringBuilder();
    for (int test = 0; test < T; ++test) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int N = Integer.parseInt(tokenizer.nextToken());
      int M = Integer.parseInt(tokenizer.nextToken());
      builder.append(nCr(M, N)).append('\n');
    }
    System.out.println(builder);
  }
}