package baekjoon.b4386;
import java.io.*;
import java.util.*;

public class Main {
  static int V, E;
  static ArrayList<int[]>[] links;

  static int[] prim(int start) {
    int costSum = 0, costMax = 0;
    var visited = new boolean[V+1];
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      costSum += cost;
      if (cost > costMax) costMax = cost;
      for (int[] link : links[node])
        queue.add(link);
    }
    return new int[] {costSum, costMax};
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    V = scanner.nextInt();
    var stars = new double[V][0];
    for (int i = 0; i < V; ++i) {
      stars[i][0] = scanner.nextDouble();
      stars[i][1] = scanner.nextDouble();
    }
    links = new ArrayList[V+1];
    for (int i = 0; i < V-1; ++i)
      for (int j = i+1; j < V; ++j) {
        double dx = stars[i][0] - stars[j][0];
        double dy = stars[i][1] - stars[j][1];
        double distance = Math.sqrt(dx*dx + dy*dy);
        
      }

      links[i] = new ArrayList<>();
    int min = Integer.MAX_VALUE, minNode = 0;
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int cost = scanner.nextInt();
      links[a].add(new int[] {b, cost});
      links[b].add(new int[] {a, cost});
      if (cost < min) { min = cost; minNode = a; }
    }
    int[] result = prim(minNode);
    System.out.println(result[0] - result[1]);
    scanner.close();
  }
}