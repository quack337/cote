package baekjoon.b3055;

import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL;
  static char[][] A;
  static int[][] water;

  static void BFS_water() {
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    water = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        if (A[r][c] == '*') queue.add(new int[] {r, c, 0});
        water[r][c] = -1;
      }
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (A[r][c] == 'D') continue;
      if (water[r][c] > -1) continue;
      water[r][c] = distance;
      if (r > 0) queue.add(new int[] { r-1, c, distance+1});
      if (c > 0) queue.add(new int[] { r, c-1, distance+1});
      if (r < ROW-1) queue.add(new int[] { r+1, c, distance+1});
      if (c < COL-1) queue.add(new int[] { r, c+1, distance+1});    
    }
  }

  static int BFS(int row, int col, char goal, int[][] waterDistance) {
    boolean[][] visited = new boolean[ROW][COL];
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {row, col, 0});
    while (queue.size() > 0) {
        int[] u = queue.remove();
        int r = u[0], c = u[1], distance = u[2];
        if (A[r][c] == goal) return distance;
        if (A[r][c] != '.') continue;
        if (waterDistance != null && waterDistance[r][c] <= distance) continue;
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
    BFS_water();
    System.out.println(Arrays.deepToString(water));
  }
}