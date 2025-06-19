package baekjoon.b2638;
// 정답 DFS 시뮬레이션
import java.io.*;
import java.util.*;

public class Main1 {
  static int ROW, COL;
  static int[][] A;

  static void DFS(int r, int c, boolean[][] visited) {
    if (visited[r][c]) return;
    visited[r][c] = true;
    if (A[r][c] == 1) return;
    if (A[r][c] == 0) A[r][c] = -1;
    if (r > 0) DFS(r-1, c, visited);
    if (c > 0) DFS(r, c-1, visited);
    if (r < ROW-1) DFS(r+1, c, visited);
    if (c < COL-1) DFS(r, c+1, visited);
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new int[ROW][COL];
    int cheeseCount = 0;
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        A[r][c] = scanner.nextInt();
        if (A[r][c] == 1) ++cheeseCount;
      }
    scanner.close();
    int answer = 0;
    while (cheeseCount > 0) {
      ++answer;
      DFS(0, 0, new boolean[ROW][COL]);
      for (int r = 0; r < ROW; ++r)
        for (int c = 0; c < COL; ++c)
          if (A[r][c] == 1) {
            int airCount = 0;
            if (A[r-1][c] == -1) ++airCount;
            if (A[r+1][c] == -1) ++airCount;
            if (A[r][c-1] == -1) ++airCount;
            if (A[r][c+1] == -1) ++airCount;
            if (airCount >= 2) {
              --cheeseCount;
              A[r][c] = 0;
            }
          }
    }
    System.out.println(answer);
  }
}