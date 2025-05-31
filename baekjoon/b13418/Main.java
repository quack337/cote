package baekjoon.b13418;
import java.io.*;
import java.util.*;

public class Main {
  static int N, E;
  static ArrayList<int[]>[] edges;

  static int prim(int sign) {
    int count = 0;
    var visited = new boolean[N+1];
    var queue = new PriorityQueue<int[]>((a, b) -> sign * (a[1] - b[1]));
    queue.add(edges[0].get(0));
    visited[0] = true;
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      if (cost == 0) ++count;
      for (int[] edge : edges[node])
        if (!visited[edge[0]]) queue.add(edge);
    }
    return count;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    E = scanner.nextInt();
    edges = new ArrayList[N+1];
    for (int i = 0; i <= N; ++i)
      edges[i] = new ArrayList<>();
    for (int i = 0; i <= E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int cost = scanner.nextInt();
      edges[a].add(new int[] {b, cost});
      edges[b].add(new int[] {a, cost});
    }
    int r1 = prim(1);
    int r2 = prim(-1);
    System.out.println(r1*r1 - r2*r2);
    scanner.close();
  }
}