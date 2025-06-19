package baekjoon.b2638;
import java.io.*;
import java.util.*;

public class Main2 {
  static int ROW, COL;
  static int[][] A;

  static int dijkstra() {
    int distance = 0;
    var visited = new boolean[ROW][COL];
    var queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
    queue.add(new int[] {0, 0, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1]; distance = u[2];
      if (visited[r][c]) continue;
      visited[r][c] = true;
      if (r > 0) queue.add(new int[] {r-1, c, distance + A[r-1][c]});
      if (c > 0) queue.add(new int[] {r, c-1, distance + A[r][c-1]});
      if (r < ROW-1) queue.add(new int[] {r+1, c, distance + A[r+1][c]});
      if (c < COL-1) queue.add(new int[] {r, c+1, distance + A[r][c+1]});
    }
    return distance;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        A[r][c] = scanner.nextInt();
    scanner.close();
    System.out.println(dijkstra());
  }
}