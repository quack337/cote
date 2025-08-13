import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] A; // 입력으로 주어진 수열
  static int[][] M;
  static int V = 1000; // 수열의 최대값

  static int DFS(int n, int prev) {
    if (n == N) return 0; // 재귀호출 과정 트리에서 리프 노드 도착
    if (M[n][prev] > -1) return M[n][prev]; // 메모한 값이 있으면 그 값 리턴
    int a = (A[n] > prev) ? DFS(n + 1, A[n]) + A[n] : 0; // A[n]을 선택하고 재귀호출
    int b = DFS(n + 1, prev); // A[n]을 선택하지 않고 재귀호출
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
