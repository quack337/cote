package baekjoon.b2239;
import java.io.*;

public class Main {
  static char[][] A = new char[9][];
  static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

  static boolean DFS(int row, int col) throws IOException {
    if (col == 9) { col = 0; ++row; }
    if (row == 9) {
      for (int r = 0; r < 9; ++r)
        wr.write(new String(A[r]) + "\n");
      return true;
    }
    if (A[row][col] > '0') {
      return DFS(row, col + 1);
    } else {
      var used = new boolean[10];
      for (int r = 0; r < 9; ++r)
        used[A[r][col] - '0'] = true;
      for (int c = 0; c < 9; ++c)
        used[A[row][c] - '0'] = true;
      int row0 = row / 3 * 3, col0 = col / 3 * 3;
      for (int r = 0; r < 3; ++r)
        for (int c = 0; c < 3; ++c)
          used[A[row0 + r][col0 + c] - '0'] = true;
      for (int i = 1; i <= 9; ++i)
        if (!used[i]) {
          A[row][col] = (char)(i + '0');
          if (DFS(row, col + 1)) return true;
          A[row][col] = '0';
        }
    }
    return false;
  }

  public static void main(String[] args) throws IOException {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    for (int r = 0; r < 9; ++r)
      A[r] = reader.readLine().toCharArray();
    DFS(0, 0);
    wr.close();
  }
}