package programmers.p87694;
import java.util.*;

public class Solution1b {
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

  void printA() {
    for (int r = N-1; r >= 0; --r) {
      for (int c = 0; c < N; ++c)
        System.out.print(A[r][c] + " ");
      System.out.println();
    }
  }

  public int solution(int[][] rectangles, int cStart, int rStart, int cGoal, int rGoal) {
    createA(rectangles);
    printA();
    return 0;
  }

  public static void main(String[] args) {
    var s = new Solution1b();
    s.solution(new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},
    1, 3, 7, 8);
  }
}