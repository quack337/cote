package baekjoon.b1368;
// 오답: 반례 data2
import java.io.*;
import java.util.*;

public class Main2 {
  static int N;
  static int[] well;
  static int[][] costs;
  static boolean[] visited;

  static int findStart() {
    int minCost = Integer.MAX_VALUE, minNode = -1;
    for (int i = 0; i < N; ++i)
      if (!visited[i] && well[i] < minCost) {
        minCost = well[i];
        minNode = i;
      }
    return minNode;
  }

  static long prim(int start) {
    long costSum = 0;
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      costSum += cost;
      for (int i = 0; i < N; ++i)
        if (i != node && !visited[i] && costs[node][i] < well[i])
          queue.add(new int[] {i, costs[node][i]});
    }
    return costSum;
  }

  static long solution() {
    long answer = 0;
    while (true) {
      int start = findStart();
      if (start == -1) return answer;
      answer += well[start];
      answer += prim(start);
    }
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    visited = new boolean[N];
    well = new int[N];
    for (int i = 0; i < N; ++i)
      well[i] = scanner.nextInt();
    costs = new int[N][N];
    for (int r = 0; r < N; ++r)
      for (int c = 0; c < N; ++c)
        costs[r][c] = scanner.nextInt();
    scanner.close();
    System.out.println(solution());
  }
}