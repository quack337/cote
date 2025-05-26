package baekjoon.b16946;

import java.io.*;
import java.util.*;

public class Main2 {
  static int ROW, COL;
  static int[][] A;

  static int DFS(int r, int c, int no) {
    if (A[r][c] != 0) return 0;
    A[r][c] = no;
    int count = 1;
    if (r > 0) count += DFS(r - 1, c, no);
    if (c > 0) count += DFS(r, c - 1, no);
    if (r < ROW-1) count += DFS(r + 1, c, no);
    if (c < COL-1) count += DFS(r, c + 1, no);
    return count;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r) {
      String s = scanner.next();
      for (int c = 0; c < COL; ++c)
        A[r][c] = s.charAt(c) - '0';
    }
    scanner.close();
    // 0 그룹의 count를 센다.
    var countMap = new HashMap<Integer, Integer>();
    int no = 2;
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        if (A[r][c] == 0) {
          int count = DFS(r, c, no);
          countMap.put(no, count);
          ++no;
        }
    var result = new StringBuilder();
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        int count = 0;
        if (A[r][c] == 1) {
          // 주변의 0 그룹의 no 집합을 구한다.
          var noSet = new HashSet<Integer>();
          if (r > 0 && A[r-1][c] > 1) noSet.add(A[r-1][c]);
          if (c > 0 && A[r][c-1] > 1) noSet.add(A[r][c-1]);
          if (r < ROW-1 && A[r+1][c] > 1) noSet.add(A[r+1][c]);
          if (c < COL-1 && A[r][c+1] > 1) noSet.add(A[r][c+1]);
          // 주변의 0 그룹들의 count 합계
          count = 1;
          for (int key : noSet)
            count += countMap.get(key);
        }
        result.append((char)('0' + count % 10));
        if (c == COL-1) result.append('\n');
      }
    System.out.println(result.toString());
  }
}
