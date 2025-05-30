package baekjoon.b1939;
// BFS 탐색으로 최단거리 탐색 weight 찾고,
// 다시 BFS 탐색. 방금 찾은 weight 보다 너 큰 다리만 이용
// 메모리 초과
import java.io.*;
import java.util.*;

public class Main3 {
  static int N, E, START, GOAL, maxWeight = 0;
  static ArrayList<int[]>[] edges;
  static boolean[] visited;

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
        if (!visited[edge[0]] && edge[1] > minWeight)
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
    int minWeight = 0;
    while (true) {
      int w = BFS(minWeight);
      if (w == -1) break;
      minWeight = w;
    }
    System.out.println(minWeight);
    scanner.close();
  }
}