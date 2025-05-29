package baekjoon.b14621;
import java.io.*;
import java.util.*;

public class Main {
  static int V, E;
  static char[] G;
  static ArrayList<int[]>[] links;

  static int prim(int start) {
    int costSum = 0, count = 0;
    var visited = new boolean[V+1];
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      costSum += cost;
      ++count;
      for (int[] link : links[node])
        queue.add(link);
    }
    if (count != V) return -1;
    return costSum;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    V = scanner.nextInt();
    E = scanner.nextInt();
    G = new char[V+1];
    for (int i = 1; i <= V; ++i)
      G[i] = scanner.next().charAt(0);
    links = new ArrayList[V+1];
    for (int i = 1; i <= V; ++i)
      links[i] = new ArrayList<>();
    int minCost = Integer.MAX_VALUE, minNode = 1;
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int cost = scanner.nextInt();
      if (G[a] == G[b]) continue;
      links[a].add(new int[] {b, cost});
      links[b].add(new int[] {a, cost});
      if (cost < minCost) { minCost = cost; minNode = a; }
    }
    System.out.println(prim(minNode));
    scanner.close();
  }
}