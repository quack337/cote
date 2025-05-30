package baekjoon.b1939;
// 파라매트릭 서치 + DFS
// 정답
import java.io.*;
import java.util.*;

public class Main {
  static int N, E, START, GOAL;
  static ArrayList<int[]>[] edges;
  static boolean[] visited;

  static int 파라매트릭서치_최대값(int left, int right) {
    while (left <= right) {
      int middle = (left + right) / 2;
      long r = compare(middle);
      if (r <= 0)
        left = middle + 1;
      else
        right = middle - 1;
    }
    return right;
  }

  static int compare(int middle) {
    visited = new boolean[N+1];
    return DFS(START, middle) ? 0 : 1;
  }

  static boolean DFS(int node, int minWeight) {
    if (node == GOAL) return true;
    if (visited[node]) return false;
    visited[node] = true;
    for (int[] edge : edges[node])
      if (!visited[edge[0]] && edge[1] >= minWeight)
        if (DFS(edge[0], minWeight))
          return true;
    return false;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws NumberFormatException, IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    E = scanner.nextInt();
    edges = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i)
      edges[i] = new ArrayList<int[]>();
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int weight = scanner.nextInt();
      edges[a].add(new int[] {b, weight});
      edges[b].add(new int[] {a, weight});
    }
    START = scanner.nextInt();
    GOAL = scanner.nextInt();
    int weight = 파라매트릭서치_최대값(1, 1_000_000_000);
    System.out.println(weight);
    scanner.close();
  }
}