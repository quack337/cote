package baekjoon.b1753;
import java.io.*;
import java.util.*;

public class Main {
  static int N, E, START;
  static ArrayList<int[]>[] edges;

  static int[] dijkstra(int start) {
    var distances = new int[N+1];
    Arrays.fill(distances, -1);
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
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
    edges = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i)
      edges[i] = new ArrayList<int[]>();
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int cost = scanner.nextInt();
      edges[a].add(new int[] {b, cost});
    }
    scanner.close();
    int[] distances = dijkstra(START);
    var builder = new StringBuilder();
    for (int i = 1; i <= N; ++i)
      builder.append(distances[i] == -1 ? "INF\n" : distances[i] + "\n");
    System.out.println(builder.toString());
  }
}