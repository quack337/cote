package baekjoon.b12100;
import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL, selectCount = 0;
  static int[][] A  = new int[20][20], B = new int[20][20];
  static boolean[][] merged = new boolean[20][20];
  static int[] selected = new int[5];

  static void move() {
    for (int r = 0; r < ROW; ++r)
      System.arraycopy(A, r, B, r, ROW);
    for (int mv : selected) {
      for (var row : merged)
      Arrays.fill(row, false);
      for (int r = 0; r < ROW; ++r) {
        for (int c = COL-1; c >= 0; --c) {
          if (A[r][c] > 0)
        }
      }
    }
  }

  static void DFS() {
    if (selectCount == 5) {
    }
  }

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); ROW = COL = (int)tk.nval;
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        tk.nextToken();
        A[r][c] = (int)tk.nval;
      }
    DFS();
  }
}