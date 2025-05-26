package baekjoon.b16933;
// 시간초과

import java.io.*;
import java.util.*;

public class Main1 {

  static int ROW, COL;
  static char[][] A;

  static int BFS(int magicCount) {
    var visited = new boolean[ROW][COL][magicCount + 1];
    var queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
    queue.add(new int[] {0, 0, 1, magicCount});
    while (queue.size() > 0) {
      var u = queue.remove();
      int r = u[0], c = u[1], distance = u[2], magic = u[3];
      if (visited[r][c][magic]) continue;
      visited[r][c][magic] = true;
      if (A[r][c] == '1') {  // 벽
        if (magic == 0) continue;
        if (distance % 2 == 1) ++distance;
        --magic;
      }
      if (r == ROW-1 && c == COL-1) return distance;
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
    int magic = scanner.nextInt();
    A = new char[ROW][];
    for (int r = 0; r < ROW; ++r)
      A[r] = scanner.next().toCharArray();
    scanner.close();
    System.out.println(BFS(magic));
  }
}
