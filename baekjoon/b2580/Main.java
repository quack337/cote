package baekjoon.b2580;
import java.io.*;

public class Main {
  static int[][] A = new int[9][9];
  static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

  static boolean DFS(int row, int col) throws IOException {
    if (col == 9) { col = 0; ++row; }
    if (row == 9) {
      for (int r = 0; r < 9; ++r) {
        for (int c = 0; c < 9; ++c)
          wr.write(A[r][c] + " ");
        wr.write('\n');
      }
      return true;
    }
    if (A[row][col] > 0) {
      return DFS(row, col + 1);
    } else {
      var used = new boolean[10];
      for (int r = 0; r < 9; ++r) 
        used[A[r][col]] = true;
      for (int c = 0; c < 9; ++c) 
        used[A[row][c]] = true;
      int row0 = row / 3 * 3, col0 = col / 3 * 3;
      for (int r = 0; r < 3; ++r)
        for (int c = 0; c < 3; ++c)
          used[A[row0 + r][col0 + c]] = true;
      for (int i = 1; i <= 9; ++i)
        if (!used[i]) {
          A[row][col] = i;
          if (DFS(row, col + 1)) return true;
          A[row][col] = 0;
        }
    }
    return false;
  }

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    for (int r = 0; r < 9; ++r)
      for (int c = 0; c < 9; ++c) {
        tk.nextToken();
        A[r][c] = (int)tk.nval;
      }
    DFS(0, 0);
    wr.close();
  }
}