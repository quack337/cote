package baekjoon.b2225;
import java.util.*;

public class Main {
  static int N, K;
  static long[][] M;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    K = sc.nextInt();
    M = new long[N+1][K+1];
    for (long[] m : M) Arrays.fill(m, -1);
    System.out.println(BT(N, K));
  }

  static long BT(int n, int k) {
    if (M[n][k] > -1) return M[n][k];
    if (k == 0) return M[n][k] = (n == 0 ? 1 : 0);
    long r = 0;
    for (int i = 0; i <= n; i++) {
      r = (r + BT(n - i, k - 1)) % 1_000_000_000;
    }
    return M[n][k] = r;
  }
}
