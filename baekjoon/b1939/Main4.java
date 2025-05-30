package baekjoon.b1939;
// 파라매트릭 서치 + BFS
// 메모리 초과
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
    int weight = BFS(middle);
    return weight == -1 ? 1 : 0;
  }

  static int BFS(int minWeight) {
    visited = new boolean[N+1];
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {START, Integer.MAX_VALUE});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], weight = u[1];
      if (node == GOAL) return weight;
      if (visited[node]) continue;
      visited[node] = true;
      for (int[] edge : edges[node])
        if (!visited[edge[0]] && edge[1] >= minWeight)
          queue.add(new int[] {edge[0], weight < edge[1] ? weight : edge[1]});
    }
    return -1;
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