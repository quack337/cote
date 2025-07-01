package baekjoon.b6603;
import java.io.*;

public class Main {
  static int N, R = 6, selectCount = 0;
  static int[] A, selected = new int[R];
  static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

  static void DFS(int from, int to) throws IOException {
    if (selectCount == R) {
      for (int i : selected) wr.write(i + " ");
      wr.write('\n');
      return;
    }
    for (int i = from; i <= to; ++i) {
      selected[selectCount] = A[i];
      ++selectCount;
      DFS(i + 1, to + 1);
      --selectCount;
    }
  }

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    while (true) {
      tk.nextToken(); N = (int)tk.nval;
      if (N == 0) break;
      A = new int[N];
      for (int i = 0; i < N; ++i) {
        tk.nextToken();
        A[i] = (int)tk.nval;
      }
      DFS(0, N - R);
      wr.write('\n');
    }
    wr.close();
  }
}