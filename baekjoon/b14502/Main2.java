package baekjoon.b14502;

import java.io.*;
import java.util.*;

public class Main2 {
  static int ROW, COL;
  static int[][] A;

  static void nC3조합() {
    int N = ROW * COL;
    for (int a = 0; a < N - 2; ++a) {
      int r1 = a / COL, c1 = a % COL;
      if (A[r1][c1] != 0) continue;
      for (int b = a + 1; b < N - 1; ++b) {
        int r2 = b / COL, c2 = b % COL;
        if (A[r2][c2] != 0) continue;
        for (int c = b + 1; c < N; ++c) {
          int r3 = c / COL, c3 = c % COL;
          if (A[r3][c3] != 0) continue;
          System.out.printf("(%d,%d) (%d,%d) (%d,%d)\n", r1, c1, r2, c2, r3, c3);
        }
      }
    }
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new int[ROW][];
    for (int r = 0; r < ROW; ++r) {
      A[r] = new int[COL];
      for (int c = 0; c < COL; ++c)
        A[r][c] = scanner.nextByte();
    }
    nC3조합();
    scanner.close();
  }
}