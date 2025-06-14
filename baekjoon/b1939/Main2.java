package baekjoon.b1939;
// BFS로 minWeight 찾아서
// DFS로 전체 경로 찾을 때, minWeight 보다 작은 다리는 무시함
// 그래도 시간초과
import java.io.*;
import java.util.*;

public class Main2 {
  static int N, E, START, GOAL, minWeight, maxWeight = 0;
  static ArrayList<int[]>[] edges;
  static boolean[] visited;

  static int BFS() {
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
        if (!visited[edge[0]])
          queue.add(new int[] {edge[0], weight < edge[1] ? weight : edge[1]});
    }
    return -1;
  }

  static void DFS(int node, int weight) {
    if (node == GOAL) {
      if (weight > maxWeight) maxWeight = weight;
      return;
    }
    if (visited[node]) return;
    visited[node] = true;
    for (int[] edge : edges[node]) {
      if (edge[1] < minWeight) continue;
      DFS(edge[0], weight < edge[1] ? weight : edge[1]);
    }
    visited[node] = false;
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
    minWeight = BFS();
    visited = new boolean[N+1];
    DFS(START, Integer.MAX_VALUE);
    System.out.println(maxWeight);
    scanner.close();
  }
}