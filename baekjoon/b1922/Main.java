package baekjoon.b1922;
import java.io.*;
import java.util.*;

public class Main {
  static int V, E;
  static ArrayList<int[]>[] links;

  static int prim(int start) {
    int costSum = 0;
    var visited = new boolean[V+1];
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      costSum += cost;
      for (int[] link : links[node])
        queue.add(link);
    }
    return costSum;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    V = scanner.nextInt();
    E = scanner.nextInt();
    links = new ArrayList[V+1];
    for (int i = 1; i <= V; ++i)
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
    System.out.println(prim(minNode));
    scanner.close();
  }
}