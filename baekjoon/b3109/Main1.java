package baekjoon.b3109;
import java.io.*;
import java.util.*;

// 답 DFS
public class Main1 {
  static int ROW, COL;
  static char[][] A;
  static boolean[][] visited;
  
  static boolean DFS(int r, int c) {
    if (visited[r][c] || A[r][c] == 'x') return false;
    visited[r][c] = true;
    if (c == COL-1) return true;
    if (r > 0 && DFS(r-1, c+1)) return true;
    if (DFS(r, c+1)) return true;
    if (r < ROW-1 && DFS(r+1, c+1)) return true;
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
      if (DFS(r, 0)) ++answer;
    System.out.println(answer);
  }
}