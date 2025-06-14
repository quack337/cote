package baekjoon.b2887;
import java.io.*;
import java.util.*;

public class Main {
  static final int X=0, Y=1, Z=2, NO=3;
  static int N;
  static int[][] A, B;
  static int minCost = Integer.MAX_VALUE, minNode = 0;

  static int prim(int start) {
    int costSum = 0;
    var visited = new boolean[N+1];
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;

      //System.out.printf(" PRIM %d %d %d\n", node, cost, links[node].size());

      costSum += cost;
      for (int i = X; i <= Z; ++i) {
      }
    }
    return costSum;
  }

  static void sort(int index) {
    Arrays.sort(A, (a, b) -> a[index] - b[index]);
    for (int i = 0; i < N; ++i)
      B[i][index] = A[i][NO];
    for (int i = 0; i < N-1; ++i)
      if (minCost > Math.abs(A[i][index] - A[i+1][index])) {
        minCost = Math.abs(A[i][index] - A[i+1][index]);
        minNode = A[i][NO];
      }
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    A = new int[N][4];
    for (int i = 0; i < N; ++i) {
      A[i][X] = scanner.nextInt();
      A[i][Y] = scanner.nextInt();
      A[i][Z] = scanner.nextInt();
      A[i][NO] = i;
    }
    B = new int[N][3];
    sort(X); sort(Y); sort(Z);
    Arrays.sort(A, (a, b) -> a[NO] - b[NO]);
    System.out.println(prim(minNode));
    scanner.close();
  }
}