package baekjoon.b1414;
import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static int[][] A;

  static int prim(int start) {
    int costSum = 0, visitedCount = 0;
    var visited = new boolean[N];
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      System.out.printf(" %d %d\n", node, cost);
      ++visitedCount;
      costSum += cost;
      for (int neighbor = 0; neighbor < N; ++neighbor) {
        if (visited[neighbor]) continue; // 자기자신도 걸러짐
        if (A[node][neighbor] > 0)
          queue.add(new int[] {neighbor, A[node][neighbor]});
        else if (A[neighbor][node] > 0)
          queue.add(new int[] {neighbor, A[neighbor][node]});
      }
    }
    return visitedCount == N ? costSum : -1;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    A = new int[N][N];
    int min = Integer.MAX_VALUE, minNode = 0, sum = 0;
    for (int i = 0; i < N; ++i) {
      String s = scanner.next();
      for (int j = 0; j <N; ++j) {
        char ch = s.charAt(j);
        if (ch == '0') A[i][j] = 0;
        else if (ch <= 'z') A[i][j] = ch - 'a' + 1;
        else A[i][j] = ch - 'A' + 27;
        if (A[i][j] > 0 && A[i][j] < min) { min = A[i][j]; minNode = i; }
        sum += A[i][j]; 
      }
    }
    scanner.close();
    int r = prim(minNode);
    System.out.println(r == -1 ? -1 : sum - r);
  }
}