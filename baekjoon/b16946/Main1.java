package baekjoon.b16946;
// 시간초과

import java.io.*;
import java.util.*;

public class Main1 {
  static int ROW, COL;
  static char[][] A;

  static int DFS(int r, int c, boolean[][] visited) {
    if (A[r][c] == '1' || visited[r][c]) return 0;
    visited[r][c] = true;
    int count = 1;
    if (r > 0) count += DFS(r - 1, c, visited);
    if (c > 0) count += DFS(r, c - 1, visited);
    if (r < ROW-1) count += DFS(r + 1, c, visited);
    if (c < COL-1) count += DFS(r, c + 1, visited);
    return count;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new char[ROW][];
    for (int r = 0; r < ROW; ++r)
      A[r] = scanner.next().toCharArray();
    scanner.close();
    var result = new StringBuilder();
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        int count = 0;
        if (A[r][c] == '1') {
          A[r][c] = '0';
          count = DFS(r, c, new boolean[ROW][COL]);
          A[r][c] = '1';
        }
        result.append((char)('0' + count % 10));
        if (c == COL-1) result.append('\n');
      }
    System.out.println(result.toString());
  }
}
