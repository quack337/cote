package programmers.p87694;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution1d {
  int N = 22;
  char[][] A;

  void createA(int[][] rectangles) {
    A = new char[N][N];
    for (int r = 0; r < N; ++r)
      Arrays.fill(A[r], '.');
    for (int[] rect : rectangles) {
      int c1 = rect[0] * 2, r1 = rect[1] * 2;
      int c2 = rect[2] * 2, r2 = rect[3] * 2;
      for (int c = c1; c <= c2; ++c)
        A[r1][c] = A[r2][c] = '%';
      for (int r = r1; r <= r2; ++r)
        A[r][c1] = A[r][c2] = '%';
    }
  }

  void findBorderBFS() {
    final var MV = new int[][] {
      {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    var visited = new boolean[N][N];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {0, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1];
      if (visited[r][c]) continue;
      visited[r][c] = true;
      if (A[r][c] == '#') continue;
      if (A[r][c] == '%') { A[r][c] = '#'; continue; }
      for (int[] mv : MV) {
        int rr = r + mv[0], cc = c + mv[1];
        if (rr < 0 || cc < 0 || rr >= N || cc >= N) continue;
        queue.add(new int[] {rr, cc});
      }
    }
  }

  void printA() {
    for (int y = N-1; y >= 0; --y) {
      for (int x = 0; x < N; ++x)
        System.out.print(A[y][x] + " ");
      System.out.println();
    }
  }

  public int solution(int[][] rectangles, int cStart, int rStart, int cGoal, int rGoal) {
    createA(rectangles);
    findBorderBFS();
    printA();
    return 0;
  }

  public static void main(String[] args) {
    var s = new Solution1d();
    s.solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},
    1, 3, 7, 8);
  }
}