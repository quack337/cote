package baekjoon.b3055;
// 물 만 구현
import java.io.*;
import java.util.*;

public class Main1 {
  static int ROW, COL;
  static char[][] A;
  static int[][] water;

  static void BFS_water(ArrayDeque<int[]> queue) {
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (A[r][c] == 'D' || A[r][c] == 'X') continue;
      if (water[r][c] > -1) continue;
      water[r][c] = distance;
      if (r > 0) queue.add(new int[] { r-1, c, distance+1});
      if (c > 0) queue.add(new int[] { r, c-1, distance+1});
      if (r < ROW-1) queue.add(new int[] { r+1, c, distance+1});
      if (c < COL-1) queue.add(new int[] { r, c+1, distance+1});
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new char[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      A[r] = scanner.next().toCharArray();
    scanner.close();
    ArrayDeque<int[]> queue1 = new ArrayDeque<>();
    water = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        water[r][c] = -1;
        if (A[r][c] == '*') queue1.add(new int[] {r, c, 0});
      }
    BFS_water(queue1);
    System.out.println(Arrays.deepToString(water));
  }
}