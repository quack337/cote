package baekjoon.b15650;
import java.io.*;
import java.util.*;

public class Main {
  static int N, R;
  static List<Integer> selected = new ArrayList<>();
  static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

  static void DFS(int from, int to) throws IOException {
    if (selected.size() == R) {
      for (int i : selected)
        wr.write(i + " ");
      wr.write("\n");
      return;
    }
    for (int i = from; i <= N; ++i) {
      selected.add(i);
      DFS(i + 1, to + 1);
      selected.remove(selected.size() - 1);
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int)tk.nval;
    tk.nextToken(); R = (int)tk.nval;
    DFS(1, N-R+1);
    wr.close();
  }
}