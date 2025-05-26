package baekjoon.b14940;

import java.io.*;
import java.util.*;

public class Main {

  static int ROW, COL, r0, c0;
  static char[][] A;
  static int[][] distances;

  static void BFS() {
    var visited = new boolean[ROW][COL];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {r0, c0, 0});
    while (queue.size() > 0) {
      var u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (A[r][c] == '0') continue; // 벽
      if (visited[r][c]) continue;
      visited[r][c] = true;
      distances[r][c] = distance;
      if (r > 0) queue.add(new int[] {r-1, c, distance+1});
      if (c > 0) queue.add(new int[] {r, c-1, distance+1});
      if (r < ROW-1) queue.add(new int[] {r+1, c, distance+1});
      if (c < COL-1) queue.add(new int[] {r, c+1, distance+1});
    }
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new char[ROW][COL];
    distances = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        A[r][c] = scanner.next().charAt(0);
        if (A[r][c] == '2') {
          r0 = r; c0 = c;
        }
      }
    scanner.close();
    BFS();
    var builder = new StringBuilder();
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        int distance = distances[r][c];
        if (distance == 0 && A[r][c] == '1') distance = -1;
        builder.append(distance).append(c < COL-1 ? ' ' : '\n');
      }
    System.out.println(builder.toString());
  }
}