// 답
import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] A, M;
  static int FLAG, MX=1, MN=0;

  static int mnx(int a, int b) {
    return FLAG==MX ? (a>b?a:b) : (a<b?a:b);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new int[N][3];
    for (int i = 0; i < N; i++) {
      String[] parts = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        A[i][j] = Integer.parseInt(parts[j]);
      }
    }

    M = new int[N][3];
    for (int[] row : M) Arrays.fill(row, -1);
    FLAG = MX; int mx = DFS(0, 1);

    M = new int[N][3];
    for (int[] row : M) Arrays.fill(row, -1);
    FLAG = MN; int mn = DFS(0, 1);

    System.out.println(mx + " " + mn);
  }

  static int DFS(int n, int prev) {
    if (n == N) return 0;
    if (M[n][prev] > -1) return M[n][prev];
    int r = DFS(n + 1, 1) + A[n][1];
    if (prev != 2) r = mnx(r, DFS(n + 1, 0) + A[n][0]);
    if (prev != 0) r = mnx(r, DFS(n + 1, 2) + A[n][2]);
    return M[n][prev] = r;
  }
}
