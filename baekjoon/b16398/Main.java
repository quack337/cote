package baekjoon.b16398;
import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] costs;

  static long prim(int start) {
    long costSum = 0;
    var visited = new boolean[N];
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      costSum += cost;
      for (int i = 0; i < N; ++i) {
        if (i != node)
          queue.add(new int[] {i, costs[node][i]});
      }
    }
    return costSum;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    costs = new int[N][N];
    int minCost = Integer.MAX_VALUE, minNode = 0;
    for (int r = 0; r < N; ++r)
      for (int c = 0; c < N; ++c) {
        int cost = costs[r][c] = scanner.nextInt();
        if (cost < minCost) { minCost = cost; minNode = r; }
      }
    System.out.println(prim(minNode));
    scanner.close();
  }
}