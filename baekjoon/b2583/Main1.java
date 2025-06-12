package baekjoon.b2583;
import java.io.*;
import java.util.*;

public class Main1 {
  static int ROW = 0, COL = 0, K = 0;
  static int 벽 = 1, 탐색할칸 = 0;
  static int[][] A;
  static boolean[][] visited;
  static ArrayList<Integer> sizes = new ArrayList<>();

  static void 연결그래프찾기() {
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        if (!visited[r][c] && A[r][c] == 탐색할칸)
          sizes.add(DFS(r, c));
  }

  static int DFS(int rStart, int cStart) {
    int size = 0;
    var stack = new ArrayDeque<int[]>();
    stack.push(new int[] {rStart, cStart});
    while (stack.size() > 0) {
      int[] u = stack.pop();
      int r = u[0], c = u[1];
      if (A[r][c] != 탐색할칸 || visited[r][c]) continue;
      visited[r][c] = true;
      ++size;
      if (r > 0) stack.push(new int[] {r-1, c});
      if (c > 0) stack.push(new int[] {r, c-1});
      if (r < ROW-1) stack.push(new int[] {r+1, c});
      if (c < ROW-1) stack.push(new int[] {r, c+1});
    }
    return size;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    K = scanner.nextInt();
    A = new int[ROW][COL];
    visited = new boolean[ROW][COL];
    for (int i = 0; i < K; ++i) {
      int c1 = scanner.nextInt(), r1 = scanner.nextInt();
      int c2 = scanner.nextInt(), r2 = scanner.nextInt();
      for (int r = r1; r < r2; ++r)
        for (int c = c1; c < c2; ++c)
          A[r][c] = 벽; 
    }
    scanner.close();
    연결그래프찾기();
    Collections.sort(sizes);
    System.out.println(sizes.size());
    System.out.println(sizes.toString().replaceAll("[^0-9 ]",""));
  }
}