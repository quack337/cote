package baekjoon.b15657;
import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[] A;
  static List<Integer> selected = new ArrayList<>();
  static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

  static void DFS(int from) throws IOException {
    if (selected.size() == M) {
      for (int val : selected)
        wr.write(val + " ");
      wr.write("\n");
      return;
    }
    for (int i = from; i < N; ++i) {
      selected.add(A[i]);
      DFS(i);
      selected.remove(selected.size() - 1);
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int)tk.nval;
    tk.nextToken(); M = (int)tk.nval;
    A = new int[N];
    for (int i = 0; i < N; ++i) {
      tk.nextToken(); A[i] = (int)tk.nval;
    }
    Arrays.sort(A);
    DFS(0);
    wr.close();
  }
}