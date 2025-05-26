package baekjoon.b7576;

import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL, 익지않은_수;
  static int[][] A;
  static ArrayList<int[]> 익은토마토;

  static int BFS() {
    var visited = new boolean[ROW][COL];
    var queue = new ArrayDeque<int[]>();
    queue.addAll(익은토마토);
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (A[r][c] == -1) continue; // 갈수 없는 빈칸
      if (visited[r][c]) continue;
      visited[r][c] = true;
      if (A[r][c] == 0) --익지않은_수;
      if (익지않은_수 == 0) return distance;
      if (r > 0) queue.add(new int[] {r-1, c, distance+1});
      if (c > 0) queue.add(new int[] {r, c-1, distance+1 });
      if (r < ROW-1) queue.add(new int[] {r+1, c, distance+1});
      if (c < COL-1) queue.add(new int[] {r, c+1, distance+1});
    }
    return -1;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    COL = scanner.nextInt();
    ROW = scanner.nextInt();
    A = new int[ROW][COL];
    익은토마토 = new ArrayList<int[]>();
    익지않은_수 = 0;
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        A[r][c] = scanner.nextInt();
        if (A[r][c] == 0) ++익지않은_수;
        else if (A[r][c] == 1)
          익은토마토.add(new int[] {r, c, 0});
      }
    System.out.println(BFS());
    scanner.close();
  }
}