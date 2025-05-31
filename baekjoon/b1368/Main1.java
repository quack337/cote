package baekjoon.b1368;
// 메모리 초과
import java.io.*;
import java.util.*;

public class Main1 {
  static int N;
  static int[] well;
  static int[][] costs;
  static boolean[] selected;

  static int prim() {
    int costSum = 0;
    var visited = new boolean[N];
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    for (int i = 0; i < N; ++i)
      if (selected[i]) queue.add(new int[] {i, 0});
    if (queue.size() == 0) return Integer.MAX_VALUE;
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      costSum += cost;
      for (int i = 0; i < N; ++i)
        if (i != node && !visited[i])
          queue.add(new int[] {i, costs[node][i]});
    }
    return costSum;
  }

  static int subset(int index) {
    if (index == N)  {
      int cost = 0;
      for (int i = 0; i < N; ++i)
        if (selected[i])
          cost += well[i];
      return cost == 0 ? Integer.MAX_VALUE : cost + prim();
    }
    selected[index] = true;
    int cost1 = subset(index + 1);
    selected[index] = false;
    int cost2 = subset(index + 1);
    return cost1 < cost2 ? cost1 : cost2;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    selected = new boolean[N];
    well = new int[N];
    for (int i = 0; i < N; ++i)
      well[i] = scanner.nextInt();
    costs = new int[N][N];
    for (int r = 0; r < N; ++r)
      for (int c = 0; c < N; ++c)
        costs[r][c] = scanner.nextInt();
    System.out.println(subset(0));
    scanner.close();
  }
}