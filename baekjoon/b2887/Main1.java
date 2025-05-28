// 메모리 초과
package baekjoon.b2887;
import java.io.*;
import java.util.*;

public class Main1 {
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
        if (!visited[link[0]])
          queue.add(link);
    }
    return costSum;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    V = scanner.nextInt();
    var stars = new int[V][3];
    for (int i = 0; i < V; ++i) {
      stars[i][0] = scanner.nextInt();
      stars[i][1] = scanner.nextInt();
      stars[i][2] = scanner.nextInt();
    }
    links = new ArrayList[V+1];
    for (int a = 0; a < V; ++a)
      links[a] = new ArrayList<>();
    int min = Integer.MAX_VALUE; int minNode = 0;
    for (int a = 0; a < V-1; ++a)
      for (int b = a+1; b < V; ++b) {
        int dx = Math.abs(stars[a][0] - stars[b][0]);
        int dy = Math.abs(stars[a][1] - stars[b][1]);
        int dz = Math.abs(stars[a][2] - stars[b][2]);
        int cost = Math.min(Math.min(dx, dy), dz);
        links[a].add(new int[] {b, cost});
        links[b].add(new int[] {a, cost});
        if (cost < min) { min = cost; minNode = a; }
      }
    System.out.println(prim(minNode));
    scanner.close();
  }
}