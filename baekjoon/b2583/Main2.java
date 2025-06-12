package baekjoon.b2583;
import java.io.*;
import java.util.*;

public class Main2 {
  static int ROW, COL, K;
  static char[][] A;
  static final int EMPTY = 0, VISITED = 'v', WALL = 1;

  static int DFS(int r, int c) {
    if (r < 0 || r >= ROW) return 0;
    if (c < 0 || c >= COL) return 0;
    if (A[r][c] != EMPTY) return 0;
    A[r][c] = VISITED; // 방문 표시
    int count = 1;
    count += DFS(r - 1, c);
    count += DFS(r + 1, c);
    count += DFS(r, c - 1);
    count += DFS(r, c + 1);
    return count;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    K = scanner.nextInt();
    A = new char[ROW][COL];
    for (int i = 0; i < K; ++i) {
      int c1 = scanner.nextInt(), r1 = scanner.nextInt();
      int c2 = scanner.nextInt(), r2 = scanner.nextInt();
      for (int r = r1; r < r2; ++r)
        for (int c = c1; c < c2; ++c)
          A[r][c] = WALL; 
    }
    scanner.close();

    ArrayList<Integer> result = new ArrayList<>();
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        if (A[r][c] == EMPTY)
          result.add(DFS(r, c));
    Collections.sort(result);
    System.out.println(result.size());
    System.out.println(result.toString().replaceAll("[^0-9 ]",""));
  }
}
