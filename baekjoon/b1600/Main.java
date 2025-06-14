package baekjoon.b1600;
import java.io.*;
import java.util.*;

public class Main {
  static int K, ROW, COL;
  static int[][] A;

  static int BFS() {
    final int[][] MV = {{0,-1},{0,1},{-1,0},{1,0},
      {-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
    var visited = new boolean[ROW][COL][K+1];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {0, 0, 0, K});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2], magic = u[3];
      if (visited[r][c][magic]) continue;
      visited[r][c][magic] = true;
      if (r == ROW-1 && c == COL-1) return distance;
      if (A[r][c] == 1) continue;
      for (int i = 0; i < MV.length; ++i) {
        if (i >= 4 && magic == 0) break;
        int rr = r + MV[i][0], cc = c + MV[i][1];
        if (rr < 0 || cc < 0 || rr >= ROW || cc >= COL) continue;
        queue.add(new int[] {rr, cc, distance+1, magic - (i >= 4 ? 1 : 0)});
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    K = scanner.nextInt();
    COL = scanner.nextInt();
    ROW = scanner.nextInt();
    A = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        A[r][c]= scanner.nextInt();
    scanner.close();
    System.out.println(BFS());
  }
}
