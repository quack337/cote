package baekjoon.b13907;
import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static ArrayList<int[]>[] edges;

  static int dijkstra(int start, int goal, int tax) {
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
        int neighbor = edge[0], cost = edge[1] + tax;
        queue.add(new int[] {neighbor, distance + cost});
      }
    }
    return -1;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    int E = scanner.nextInt();
    int K = scanner.nextInt();
    int start = scanner.nextInt();
    int goal = scanner.nextInt();
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
    var result = new StringBuilder();
    int tax = 0;
    result.append(dijkstra(start, goal, tax) + "\n");
    for (int i = 0; i < K; ++i) {
      tax += scanner.nextInt();
      result.append(dijkstra(start, goal, tax) + "\n");
    }
    scanner.close();
    System.out.println(result.toString());
  }
}