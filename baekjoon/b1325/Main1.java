package baekjoon.b1325;
import java.io.*;
import java.util.*;

public class Main1 {
  static final int FALSE = 0, TRUE = 1;
  static List<Integer>[] neighbors;
  static int[] DP;
  static boolean[] visited;

  static int[] 그래프크기(int node) {
    if (DP[node] > 0) return new int[] {DP[node], FALSE};
    if (visited[node]) return new int[] {0, TRUE};
    visited[node] = true;
    int cycle = FALSE, size = 1;
    for (int neighbor : neighbors[node]) {
      int[] u = 그래프크기(neighbor);
      size += u[0];
      cycle |= u[1];
    }
    if (cycle == 0) DP[node] = size;
    return new int[] {size, cycle};
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int N = scanner.nextInt();
    neighbors = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i)
      neighbors[i] = new ArrayList<>();
    int E = scanner.nextInt();
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      neighbors[b].add(a);
    }
    scanner.close();
    int maxSize = 0;
    var maxNodes = new ArrayList<Integer>();
    DP = new int[N+1];
    for (int node = 1; node <= N; ++node) {
      visited = new boolean[N+1];
      int[] u = 그래프크기(node);
      int size = u[0];
      if (size > maxSize) {
        maxSize = size;
        maxNodes.clear();
      }
      if (size == maxSize)
        maxNodes.add(node);
    }
    System.out.println(maxNodes.toString().replaceAll("[^0-9 ]+", ""));
  }
}