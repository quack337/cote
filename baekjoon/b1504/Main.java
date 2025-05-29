package baekjoon.b1504;
import java.io.*;
import java.util.*;

public class Main {
  static int N, E, INF = 300_000_000;
  static ArrayList<int[]>[] edges;

  static int dijkstra(int start, int goal) {
    var visited = new boolean[N+1];
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], distance = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      if (node == goal) return distance;
      for (int[] edge : edges[node]) {
        int neighbor = edge[0], cost = edge[1];
        queue.add(new int[] {neighbor, distance + cost});
      }
    }
    return INF;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    E = scanner.nextInt();
    edges = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i)
      edges[i] = new ArrayList<int[]>();
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int cost = scanner.nextInt();
      edges[a].add(new int[] {b, cost});
      edges[b].add(new int[] {a, cost});
    }
    int p = scanner.nextInt();
    int q = scanner.nextInt();
    scanner.close();
    int r1 = dijkstra(1, p) + dijkstra(p, q) + dijkstra(q, N);
    int r2 = dijkstra(1, q) + dijkstra(q, p) + dijkstra(p, N);
    int answer = (r1 >= INF && r2 >= INF) ? -1 : Math.min(r1, r2);
    System.out.println(answer);
  }
}