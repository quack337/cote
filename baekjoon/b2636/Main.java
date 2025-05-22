package baekjoon.b2636;

import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL;
  static int[][] A;

  static int[] BFS() {
    var visited = new boolean[ROW][COL];
    var queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
    for (int r = 0; r < ROW; ++r) {
      queue.add(new int[] {r,0,0});
      queue.add(new int[] {r,COL-1,0});
    }
    for (int c = 0; c < COL; ++c) {
      queue.add(new int[] {0,c,0});
      queue.add(new int[] {ROW-1,c,0});
    }
    int maxDistance = 0, maxCount = 0;
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2] + A[r][c];
      if (visited[r][c]) continue;
      visited[r][c] = true;
      if (distance > maxDistance) {
        maxDistance = distance;
        maxCount = 1;
      } else if (distance == maxDistance && A[r][c] == 1)
        ++maxCount;
      if (r > 0) queue.add(new int[] {r-1, c, distance});
      if (c > 0) queue.add(new int[] {r, c-1, distance});
      if (r < ROW-1) queue.add(new int[] {r+1, c, distance});
      if (c < COL-1) queue.add(new int[] {r, c+1, distance});
    }
    return new int[] {maxDistance, maxCount};
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
    int[] result = BFS();
    System.out.println(result[0] + "\n" + result[1]);
  }
}