package baekjoon.b1743;
import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL, N;
  static int[][] A;

  static int DFS(int r, int c, boolean[][] visited) {
    if (visited[r][c]) return 0;
    visited[r][c] = true;
    if (A[r][c] == 0) return 0;
    int count = 1;
    if (r > 0) count += DFS(r-1, c, visited);
    if (c > 0) count += DFS(r, c-1, visited);
    if (r < ROW-1) count += DFS(r+1, c, visited);
    if (c < COL-1) count += DFS(r, c+1, visited);
    return count;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    N = scanner.nextInt();
    A = new int[ROW][COL];
    for (int i = 0; i < N; ++i) {
      int r = scanner.nextInt() - 1;
      int c = scanner.nextInt() - 1;
      A[r][c] = 1;
    }
    int max = 0;
    var visited = new boolean[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        if (A[r][c] == 1) {
          int count = DFS(r, c, visited);
          if (count > max) max = count;
        }
    scanner.close();
    System.out.println(max);
  }
}