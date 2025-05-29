package baekjoon.b1238;
// 단방향 간선, 모든지점 왕복 최대거리
// 갈 때 간선 edges1, 올 때 간선 edges2
// 모든지점 최단거리 찾기
import java.io.*;
import java.util.*;

public class Main {
  static int N, E, START;

  static int[] dijkstra(ArrayList<int[]>[] edges) {
    var distances = new int[N+1];
    Arrays.fill(distances, -1);
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {START, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], distance = u[1];
      if (distances[node] > -1) continue;
      distances[node] = distance;
      for (int[] edge : edges[node]) {
        int neighbor = edge[0], cost = edge[1];
        queue.add(new int[] {neighbor, distance + cost});
      }
    }
    return distances;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    E = scanner.nextInt();
    START = scanner.nextInt();
    ArrayList<int[]>[] edges1 = new ArrayList[N+1];
    ArrayList<int[]>[] edges2 = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i) {
      edges1[i] = new ArrayList<int[]>();
      edges2[i] = new ArrayList<int[]>();
    }
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int cost = scanner.nextInt();
      edges1[a].add(new int[] {b, cost});
      edges2[b].add(new int[] {a, cost});
    }
    scanner.close();
    int[] distances1 = dijkstra(edges1);
    int[] distances2 = dijkstra(edges2);
    int max = 0;
    for (int i = 1; i <= N; ++i) {
      int distance = distances1[i] + distances2[i];
      if (distance > max) max = distance;
    }
    System.out.println(max);
  }
}