package baekjoon.b2839;
import java.io.*;

public class Main {
  static int[] memo;

  static int DFS(int n) {
    if (n < 0) return Integer.MAX_VALUE;
    if (n == 0) return 0;
    if (memo[n] > 0) return memo[n];
    int r = Math.min(DFS(n-5), DFS(n-3));
    return memo[n] = (r==Integer.MAX_VALUE ? r : r + 1);
  }

  public static void main(String[] args) throws IOException {
    var rd = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(rd.readLine());
    memo = new int[N + 1];
    int x = DFS(N);
    System.out.println(x == Integer.MAX_VALUE ? -1 : x);
  }
}
