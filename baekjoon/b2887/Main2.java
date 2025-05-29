package baekjoon.b2887;
// 중단
import java.io.*;
import java.util.*;

public class Main2 {
  static final int NO=0, X=1, Y=2, Z=3;
  static int V, E;
  static ArrayList<int[]>[] links;
  static int minCost = Integer.MAX_VALUE, minNode = 0;

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

      System.out.printf(" PRIM %d %d %d\n", node, cost, links[node].size());

      costSum += cost;
      for (int[] link : links[node]) {
        System.out.printf(" PRIM LOOP %d %d %s\n", link[0], link[1], visited[link[0]]);
        if (!visited[link[0]])
          queue.add(link);
      }
    }
    return costSum;
  }

  static void addLinks(int[][] stars) {
    for (int i = 0; i < V-1; ++i) {
      int dx = Math.abs(stars[i][X] - stars[i+1][X]);
      int dy = Math.abs(stars[i][Y] - stars[i+1][Y]);
      int dz = Math.abs(stars[i][Z] - stars[i+1][Z]);
      int cost = Math.min(Math.min(dx, dy), dz);
      int a = stars[i][NO], b = stars[i+1][NO];
      System.out.printf(" %d %d %d\n", a, b, cost);
      links[a].add(new int[] {a, cost});
      links[b].add(new int[] {b, cost});
      if (cost < minCost) { minCost = cost; minNode = i; }
    }
  }

  static void print(int[][] stars) {
    System.out.println(Arrays.deepToString(stars));
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    V = scanner.nextInt();
    var stars = new int[V][4];
    for (int i = 0; i < V; ++i) {
      stars[i][NO] = i;
      stars[i][X] = scanner.nextInt();
      stars[i][Y] = scanner.nextInt();
      stars[i][Z] = scanner.nextInt();
    }
    links = new ArrayList[V+1];
    for (int a = 0; a < V; ++a)
      links[a] = new ArrayList<>();
    Arrays.sort(stars, (a, b) -> a[X]-b[X]); addLinks(stars);
    Arrays.sort(stars, (a, b) -> a[Y]-b[Y]); addLinks(stars);
    Arrays.sort(stars, (a, b) -> a[Z]-b[Z]); addLinks(stars);
    System.out.println(prim(minNode));
    scanner.close();
  }
}