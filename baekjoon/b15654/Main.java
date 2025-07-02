package baekjoon.b15654;
import java.io.*;
import java.util.*;

public class Main {
  static int N, R;
  static int[] A;
  static List<Integer> selected = new ArrayList<>();
  static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

  static void DFS() throws IOException {
    if (selected.size() == R) {
      for (int val : selected)
        wr.write(val + " ");
      wr.write("\n");
      return;
    }
    for (int i = 0; i < N; ++i)
      if (!selected.contains(A[i])) {
        selected.add(A[i]);
        DFS();
        selected.remove(selected.size() - 1);
      }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int)tk.nval;
    tk.nextToken(); R = (int)tk.nval;
    A = new int[N];
    for (int i = 0; i < N; ++i) {
      tk.nextToken(); A[i] = (int)tk.nval;
    }
    Arrays.sort(A);
    DFS();
    wr.close();
  }
}