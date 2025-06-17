package baekjoon.b9466;
// 시간초과
import java.io.*;
import java.util.*;

public class Main1 {
  static int N, selectedCount;
  static int[] A;
  static boolean[] selected;

  static void DFS(int start) {
    var visited = new boolean[N+1];
    visited[start] = true;
    int node = A[start];
    while (true) {
      if (node == start) break;
      if (selected[node] || visited[node]) return;
      visited[node] = true;
      node = A[node];
    }
    for (int i = 1; i <= N; ++i)
      if (visited[i]) { 
        selected[i] = true; 
        ++selectedCount;
      }
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int T = scanner.nextInt();
    for (int t = 0; t < T; ++t) {
      N = scanner.nextInt();;
      A = new int[N+1];
      for (int i = 1; i <= N; ++i)
        A[i] = scanner.nextInt();
      selected = new boolean[N+1];
      selectedCount = 0;
      for (int i = 1; i <= N; ++i)
        if (!selected[i])
          DFS(i);
      System.out.println(N - selectedCount);
    }
    scanner.close();
  }
}