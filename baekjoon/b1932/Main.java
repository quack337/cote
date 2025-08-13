//package baekjoon.b1032;
import java.io.*;
import java.util.*;

public class Main {
  static int[][] A, memo;
  static int N;

  static int DFS(int r, int c) {
    if (r == N - 1) return A[r][c];
    if (memo[r][c] != -1) return memo[r][c];
    int a = DFS(r + 1, c);
    int b = DFS(r + 1, c + 1);
    return memo[r][c] = Math.max(a, b) + A[r][c];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(rd.readLine());
    A = new int[N][N];
    memo = new int[N][N];
    for (int[] row : memo) Arrays.fill(row, -1);
    for (int r = 0; r < N; r++) {
      var tk = new StringTokenizer(rd.readLine());
      for (int c = 0; c <= r; c++)
        A[r][c] = Integer.parseInt(tk.nextToken());
    }
    System.out.println(DFS(0, 0));
  }
}
