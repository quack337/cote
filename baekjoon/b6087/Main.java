package baekjoon.b6087;
import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL, rStart, cStart;
  static char[][] A;

  static int dijkstra() {
    final int[][] DIR = {{-1,0},{0,1},{0,-1},{1,0}};
    var visited = new boolean[ROW][COL][DIR.length];
    var queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
    for (int dir = 0; dir < DIR.length; ++dir)
      queue.add(new int[] {rStart, cStart, 0, dir});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2], dir = u[3];
      if (visited[r][c][dir]) continue;
      visited[r][c][dir] = true;
      if (A[r][c] == '*') continue;
      if (A[r][c] == 'C') return distance;
      for (int i = 0; i < 4; ++i) {
        int rr = r + DIR[i][0], cc = c + DIR[i][1], cost = 0;
        if (rr < 0 || cc < 0 || rr >= ROW || cc >= COL) continue;
        if (dir + i == 3) continue; // 180도 회전 불가
        if (dir != i) cost = 1;
        queue.add(new int[] {rr, cc, distance + cost, i});
      }
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    COL = scanner.nextInt();
    ROW = scanner.nextInt();
    A = new char[ROW][];
    for (int r = 0; r < ROW; ++r) {
      A[r] = scanner.next().toCharArray();
      for (int c = 0; c < COL; ++c)
        if (A[r][c] == 'C') { rStart = r; cStart = c; }
    }
    scanner.close();
    A[rStart][cStart] = '.';
    System.out.println(dijkstra());
  }
}