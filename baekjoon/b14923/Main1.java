package baekjoon.b14923;

import java.io.*;
import java.util.*;

public class Main1 {
  static int ROW, COL, rStart, cStart, rGoal, cGoal;
  static int[][] A;

  static int BFS() {
    var visited = new boolean[ROW][COL][2];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {rStart, cStart, 0, 1});
    while (queue.size() > 0) {
      var u = queue.remove();
      int r = u[0], c = u[1], distance = u[2], magic = u[3];
      if (visited[r][c][magic]) continue;
      visited[r][c][magic] = true;
      if (A[r][c] == 1) {  // 벽
        if (magic == 0) continue;
        --magic;
      }
      if (r == rGoal && c == cGoal) return distance;
      if (r > 0) queue.add(new int[] {r-1, c, distance+1, magic});
      if (c > 0) queue.add(new int[] {r, c-1, distance+1, magic});
      if (r < ROW-1) queue.add(new int[] {r+1, c, distance+1, magic});
      if (c < COL-1) queue.add(new int[] {r, c+1, distance+1, magic});
    }
    return -1;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    rStart = scanner.nextInt() - 1; cStart = scanner.nextInt() - 1;
    rGoal = scanner.nextInt() - 1; cGoal = scanner.nextInt() - 1;
    A = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        A[r][c] = scanner.nextInt();
    scanner.close();
    System.out.println(BFS());
  }
}
