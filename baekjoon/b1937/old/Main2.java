package baekjoon.b1937.old;
import java.io.*;
import java.util.*;

// 2단계: DP
public class Main2 {
  static int ROW, COL;
  static int[][] A, D;

  static int DFS(int r, int c) {
    if (D[r][c] > 0) return D[r][c];
    int d = 0;
    if (r > 0 && A[r-1][c] > A[r][c]) d = Math.max(d, DFS(r-1, c));
    if (c > 0 && A[r][c-1] > A[r][c]) d = Math.max(d, DFS(r, c-1));
    if (r < ROW-1 && A[r+1][c] > A[r][c]) d = Math.max(d, DFS(r+1, c));
    if (c < COL-1 && A[r][c+1] > A[r][c]) d = Math.max(d, DFS(r, c+1));
    return D[r][c] = d + 1;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = ROW;
    A = new int[ROW][COL];
    D = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        A[r][c] = scanner.nextInt();
    scanner.close();
    for (int r = 0; r < ROW; ++r) {
      for (int c = 0; c < COL; ++c)
        System.out.print(DFS(r, c) + " ");
      System.out.println();
    }
  }
}