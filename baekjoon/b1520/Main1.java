package baekjoon.b1520;
// 높이 내림차순으로 경로 수를 계산함
import java.io.*;
import java.util.*;

public class Main1 {
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int ROW = scanner.nextInt(), COL = scanner.nextInt();
    var A = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        A[r][c] = scanner.nextInt();
    scanner.close();
    final int[][] MV = {{-1,0},{1,0},{0,-1},{0,1}};
    var DP = new int[ROW][COL];
    var visited = new boolean[ROW][COL];
    var queue = new PriorityQueue<int[]>((a, b) -> b[2] - a[2]);
    DP[0][0] = 1;
    queue.add(new int[] {0, 0, A[0][0]});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1];
      if (visited[r][c]) continue;
      visited[r][c] = true;
      for (int[] mv : MV) {
        int rr = r + mv[0], cc = c + mv[1];
        if (rr < 0 || cc < 0 || rr >= ROW || cc >= COL) continue;
        if (A[rr][cc] > A[r][c])
          DP[r][c] += DP[rr][cc];
        else if (A[rr][cc] < A[r][c])
          queue.add(new int[] {rr, cc, A[rr][cc]});
      }
    }
    System.out.println(DP[ROW-1][COL-1]);
  }
}