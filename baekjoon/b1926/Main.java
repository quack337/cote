package baekjoon.b1926;
import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL, size, 색 = 1;
  static int[][] A;
  static boolean[][] visited;

  static void DFS(int r, int c) {
    if (visited[r][c] || A[r][c] != 색) return;
    visited[r][c] = true;
    ++size;
    if (r > 0) DFS(r-1, c);
    if (c > 0) DFS(r, c-1);
    if (r < ROW-1) DFS(r+1, c);
    if (c < COL-1) DFS(r, c+1);
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        A[r][c]= scanner.nextInt();
    scanner.close();

    int count = 0, maxSize = 0;
    visited = new boolean[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        if (!visited[r][c] && A[r][c] == 색) {
          ++count;
          size = 0;
          DFS(r, c);
          if (size > maxSize) maxSize = size;
        }
    System.out.println(count +"\n" + maxSize);
  }
}
