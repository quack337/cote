package baekjoon.b3109;
import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL;
  static char[][] A;
  static boolean[][] visited;
  static final int[][] MV = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

  static boolean DFS(int r, int c) {
    if (visited[r][c] || A[r][c] == 'x') return false;
    visited[r][c] = true;
    if (c == COL-1) return true;
    for (int[] mv : MV) {
      int rr = r + mv[0], cc = c + mv[1];
      if (rr < 0 || cc < 0 || rr >= ROW) continue;
      if (DFS(rr, cc)) return true;
    }
    return false;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new char[ROW][];
    for (int r = 0; r < ROW; ++r)
      A[r] = scanner.next().toCharArray();
    scanner.close();
    visited = new boolean[ROW][COL];
    int answer = 0;
    for (int r = 0; r < ROW; ++r)
      if (DFS(r, 0))
        ++answer;
    System.out.println(answer);
  }
}