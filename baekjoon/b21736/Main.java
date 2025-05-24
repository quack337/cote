package baekjoon.b21736;
import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL;
  static char[][] A;
  static boolean[][] visited;
  static int answer = 0;

  static void DFS(int r, int c) {
    if (visited[r][c]) return;
    visited[r][c] = true;
    if (A[r][c] == 'X') return;
    if (A[r][c] == 'P') ++answer;
    if (r > 0) DFS(r - 1, c);
    if (c > 0) DFS(r, c - 1);
    if (r < ROW-1) DFS(r+1, c);
    if (c < COL-1) DFS(r, c+1);
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    visited = new boolean[ROW][COL];
    A = new char[ROW][];
    for (int r = 0; r < ROW; ++r)
      A[r] = scanner.next().toCharArray();
    scanner.close();
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
      if (A[r][c] == 'I') {
        DFS(r, c);
        if (answer <= 0) System.out.println("TT");
        else System.out.println(answer);
        return;
      }
  }
}
