package baekjoon.b16954;

import java.util.*;
import java.io.*;

public class Main {
  static char[][] A;

  static boolean wall(int r, int c, int time) {
    r -= time;
    return 0 <= r && r < 8 && 0 <= c && c < 8 && A[r][c] == '#';
  }

  static int BFS(char[][] map) {
    int[][] MV = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
    var visited = new int[8][8];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {7, 0, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], time = u[2];
      if (visited[r][c] > 8) continue;
      ++visited[r][c];
      if (wall(r, c, time)) continue;
      if (r == 0 && c == 7) return 1;
      for (int[] mv : MV) {
        int rr = r + mv[0], cc = c + mv[1];
        if (rr < 0 || rr >= 8 || cc < 0 || cc >= 8) continue;
        if (wall(rr, cc, time)) continue;
        queue.add(new int[] {rr, cc, time + 1 });
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    A = new char[8][];
    for (int i = 0; i < 8; ++i)
      A[i] = scanner.next().toCharArray();
    scanner.close();
    System.out.println(BFS(A));
  }
}