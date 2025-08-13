import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[] A;
  static int[][] M;
  static int V = 1000; // 수열의 최대값

  static int DFS(int n, int prev) {
    if (n == N) return M[n][prev] = 0;  // 경로 역추적 하려면, 모든 리턴값을 다 메모해야 한다
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
    DFS(0, 0);
    int prev = 0; // 역추적을 위한 prev 최초값
    var builder = new StringBuilder();
    builder.append(M[0][0]).append('\n');
    for (int n=0; n < N; ++n) // n: 0부터 N-1까지 역추적
      if (M[n][prev] == M[n+1][A[n]]+1)
        // A[n] 항목을 선택하고 다음 단계 재귀호출 리턴값 + 1 == 이 단계 리턴값 이라면
        // 최장 수열  다음 단계는 A[n] 항목 선택 재귀호출이다
        builder.append(prev = A[n]).append(' ');
    System.out.println(builder);
  }
}
