package baekjoon.b2665;
import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL;
  static char[][] A;

  static int dijkstra() {
    var visited = new boolean[ROW][COL];
    var queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
    queue.add(new int[] {0, 0, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (visited[r][c]) continue;
      visited[r][c] = true;
      if (r == ROW-1 && c == COL-1) return distance;
      if (r > 0) queue.add(new int[] {r-1, c, distance + (A[r-1][c]=='1' ? 0 : 1)});
      if (c > 0) queue.add(new int[] {r, c-1, distance + (A[r][c-1]=='1' ? 0 : 1)});
      if (r < ROW-1) queue.add(new int[] {r+1, c, distance + (A[r+1][c]=='1' ? 0 : 1)});
      if (c < COL-1) queue.add(new int[] {r, c+1, distance + (A[r][c+1]=='1' ? 0 : 1)});
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = COL = scanner.nextInt();
    A = new char[ROW][];
    for (int r = 0; r < ROW; ++r)
      A[r] = scanner.next().toCharArray();
    scanner.close();
    System.out.println(dijkstra());
  }
}