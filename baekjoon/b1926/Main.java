package baekjoon.b1926;

import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL;
  static int[][] A;

  static int DFS(int r, int c) {
    if (A[r][c] != 1) return 0;
    A[r][c] = -1;
    int count = 1;
    if (r > 0) count += DFS(r - 1, c);
    if (c > 0) count += DFS(r, c - 1);
    if (r < ROW-1) count += DFS(r + 1, c);
    if (c < COL-1) count += DFS(r, c + 1);
    return count;
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

    int answer1 = 0, answer2 = 0;
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        if (A[r][c] == 1) {
          ++answer1;
          int count = DFS(r, c);
          if (count > answer2) answer2 = count;
        }
    System.out.println(answer1 +"\n" + answer2);
  }
}
