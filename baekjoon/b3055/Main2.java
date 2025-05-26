package baekjoon.b3055;

import java.io.*;
import java.util.*;

public class Main2 {
  static int ROW, COL, INF = Integer.MAX_VALUE;
  static char[][] A;
  static int[][] waterDistance;

  static void BFS_water(ArrayDeque<int[]> queue) {
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (A[r][c] == 'D' || A[r][c] == 'X') continue;
      if (waterDistance[r][c] < INF) continue;
      waterDistance[r][c] = distance;
      if (r > 0) queue.add(new int[] { r-1, c, distance+1});
      if (c > 0) queue.add(new int[] { r, c-1, distance+1});
      if (r < ROW-1) queue.add(new int[] { r+1, c, distance+1});
      if (c < COL-1) queue.add(new int[] { r, c+1, distance+1});
    }
  }

  static int BFS(ArrayDeque<int[]> queue) {
    boolean[][] visited = new boolean[ROW][COL];
    while (queue.size() > 0) {
        int[] u = queue.remove();
        int r = u[0], c = u[1], distance = u[2];
        if (A[r][c] == 'D') return distance; // goal
        if (A[r][c] == 'X') continue;
        if (waterDistance[r][c] <= distance) continue;
        if (visited[r][c]) continue;
        visited[r][c] = true;
        if (r > 0) queue.add(new int[] { r-1, c, distance+1});
        if (c > 0) queue.add(new int[] { r, c-1, distance+1});
        if (r < ROW-1) queue.add(new int[] { r+1, c, distance+1});
        if (c < COL-1) queue.add(new int[] { r, c+1, distance+1});
    }
    return -1;
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new char[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      A[r] = scanner.next().toCharArray();
    scanner.close();
    ArrayDeque<int[]> queue1 = new ArrayDeque<>(), queue2 = new ArrayDeque<>();
    waterDistance = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        waterDistance[r][c] = INF;
        if (A[r][c] == '*') queue1.add(new int[] {r, c, 0});
        else if (A[r][c] == 'S') queue2.add(new int[] {r, c, 0});
      }
    BFS_water(queue1);
    int answer = BFS(queue2);
    System.out.println(answer == -1 ? "KAKTUS" : answer);
  }
}