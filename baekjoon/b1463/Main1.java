package baekjoon.b1463;
import java.io.*;

public class Main1 {
  static int[] memo;
  static final int INF = 1_000_000;

  static int DFS(int x) {
    if (x == 1) return 0;
    if (memo[x] != 0) return memo[x];
    int a = INF, b = INF;
    if (x % 3 == 0) a = DFS(x / 3);
    if (x % 2 == 0) b = DFS(x / 2);
    int c = DFS(x - 1);
    return memo[x] = Math.min(Math.min(a, b), c) + 1;
  }

  public static void main(String[] args) throws IOException {
    var rd = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(rd.readLine());
    memo = new int[X + 1];
    System.out.println(DFS(X));
  }
}
