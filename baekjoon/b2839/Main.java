package baekjoon.b2839;
import java.io.*;
import java.util.*;

public class Main {
  static final int INF = 9000;
  static int[] DP = new int[5001];

  static int 완전탐색(int n) {
    if (DP[n] > 0) return DP[n];
    if (n == 5 || n == 3) return DP[n] = 1;
    int r1 = INF, r2 = INF;
    if (n > 5) r1 = 완전탐색(n - 5) + 1;
    if (n > 3) r2 = 완전탐색(n - 3) + 1;
    return DP[n] = (r1 < r2 ? r1 : r2);
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int n = scanner.nextInt();;
    scanner.close();
    int r = 완전탐색(n);
    System.out.println(r >= INF ? -1 : r);
  }
}