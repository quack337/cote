package baekjoon.b18352;
// 비슷한 코드 붙여넣기만 함

import java.io.*;
import java.util.*;

public class Main {

  static int ROW, COL;
  static char[][] A;

  static int BFS() {
    var visited = new boolean[ROW][COL];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {0, 0, 1});
    while (queue.size() > 0) {
      var u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (r == ROW - 1 && c == COL - 1) return distance;
      if (A[r][c] == '0') continue; // 벽
      if (visited[r][c]) continue;
      visited[r][c] = true;
      if (r > 0) queue.add(new int[] {r-1, c, distance+1});
      if (c > 0) queue.add(new int[] {r, c-1, distance+1});
      if (r < ROW-1) queue.add(new int[] {r+1, c, distance+1});
      if (c < COL-1) queue.add(new int[] {r, c+1, distance+1});
    }
    return -1;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new char[ROW][];
    for (int r = 0; r < ROW; ++r)
      A[r] = scanner.next().toCharArray();
    scanner.close();
    System.out.println(BFS());
  }
}
