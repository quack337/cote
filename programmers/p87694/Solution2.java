package programmers.p87694;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution2 {
  int N = 102;
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

  public int solution(int[][] rectangles, int cStart, int rStart, int cGoal, int rGoal) {
    cStart *= 2; rStart *= 2; cGoal *= 2; rGoal *= 2;
    createA(rectangles);
    findBorderBFS();
    var visited = new boolean[N][N];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {rStart, cStart, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (visited[r][c]) continue;
      visited[r][c] = true;
      if (r == rGoal && c == cGoal) return distance / 2;
      if (A[r][c] != '#') continue;
      if (c < N-1) queue.add(new int[] {r, c+1, distance+1});
      if (r < N-1) queue.add(new int[] {r+1, c, distance+1});
      if (c > 0) queue.add(new int[] {r, c-1, distance+1});
      if (r > 0) queue.add(new int[] {r-1, c, distance+1});
    }
    return -1;
  }

  public static void main(String[] args) {
    var s = new Solution2();
    var answer = s.solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},
    1,3,7,8);
    System.out.println(answer); // 17

    answer = s.solution(new int[][] {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},
    9,7,6,1);
    System.out.println(answer); // 11

    answer = s.solution(new int[][] {{1,1,5,7}},1,1,4,7);
    System.out.println(answer); // 9

    answer = s.solution(new int[][] {{2,1,7,5},{6,4,10,10}},3,1,7,10);
    System.out.println(answer); // 15

    answer = s.solution(new int[][] {{2,2,5,5},{1,3,6,4},{3,1,4,6}},1,4,6,3);
    System.out.println(answer); // 10
  }
}