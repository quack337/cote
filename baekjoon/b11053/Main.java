import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] A;
  static int[][] M;
  static int V = 1000; // 수열의 최대값

  static int DFS(int n, int prev) {
    if (n == N) return 0;
    if (M[n][prev] > -1) return M[n][prev];
    int a = (A[n] > prev) ? DFS(n + 1, A[n]) + 1 : 0;
    int b = DFS(n + 1, prev);
    return M[n][prev] = Math.max(a, b);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    A = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(st.nextToken());
    M = new int[N + 1][V + 1];
    for (int[] row : M) Arrays.fill(row, -1);
    System.out.println(DFS(0, 0));
  }
}
