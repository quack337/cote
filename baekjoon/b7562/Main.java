package baekjoon.b7562;
import java.io.*;
import java.util.*;

public class Main {
  static int BFS(int N, int rStart, int cStart, int rGoal, int cGoal) {
    final int[][] MV = {{-1,-2},{-2,-1},{-1,2},{1,-2},{1,2},{-2,-1},
                        {-2,-1},{-1,-2},{2,-1},{-2,1},{2,1},{-1,-2}};
    var visited = new boolean[N][N];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {rStart, cStart, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (visited[r][c]) continue;
      visited[r][c] = true;
      if (r == rGoal && c == cGoal) return distance;
      for (int i = 0; i < MV.length; ++i) {
        int rr = r + MV[i][0], cc = c + MV[i][1];
        if (rr < 0 || cc < 0 || rr >= N || cc >= N) continue;
        queue.add(new int[] {rr, cc, distance+1});
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int T = scanner.nextInt();
    var result = new StringBuilder();
    for (int t = 0; t < T; ++t) {
      int N = scanner.nextInt();
      int rStart = scanner.nextInt();
      int cStart = scanner.nextInt();
      int rGoal = scanner.nextInt();
      int cGoal = scanner.nextInt();
      result.append(BFS(N, rStart, cStart, rGoal, cGoal)).append('\n');
    }
    scanner.close();
    System.out.println(result.toString());
  }
}
