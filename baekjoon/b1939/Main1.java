package baekjoon.b1939;
// 모든 경로 DFS로 다 찾기. 시간초과.
import java.io.*;
import java.util.*;

public class Main1 {
  static int N, E, START, GOAL, maxWeight = 0;
  static ArrayList<int[]>[] edges;
  static boolean[] visited;

  static void DFS(int node, int weight) {
    if (node == GOAL) {
      if (weight > maxWeight) maxWeight = weight;
      return;
    }
    if (visited[node]) return;
    visited[node] = true;
    for (int[] edge : edges[node]) {
      int neighbor = edge[0], edge_weight = edge[1];
      DFS(neighbor, weight < edge_weight ? weight : edge_weight);
    }
    visited[node] = false;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws NumberFormatException, IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    E = scanner.nextInt();
    visited = new boolean[N+1];
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
    DFS(START, Integer.MAX_VALUE);
    System.out.println(maxWeight);
    scanner.close();
  }
}