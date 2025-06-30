package baekjoon.b15665;
import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[] A;
  static List<Integer> selected = new ArrayList<>();
  static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));
  static Set<String> visited = new HashSet<>();

  static void DFS() throws IOException {
    if (selected.size() == M) {
      var builder = new StringBuilder();
      for (int i : selected)
        builder.append(A[i] + " ");
      var s = builder.toString().trim();
      if (!visited.contains(s)) {
        visited.add(s);
        wr.write(s); wr.write("\n");
      }
      return;
    }
    for (int i = 0; i < N; ++i) {
      selected.add(i);
      DFS();
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
    DFS();
    wr.close();
  }
}