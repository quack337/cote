package baekjoon.b15649;
import java.io.*;
import java.util.*;

public class Main {
  static int N, R;
  static List<Integer> selected = new ArrayList<>();
  static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

  static void DFS() throws IOException {
    if (selected.size() == R) {
      for (int i : selected)
        wr.write(i + " ");
      wr.write("\n");
      return;
    }
    for (int i = 1; i <= N; ++i)
      if (!selected.contains(i)) {
        selected.add(i);
        DFS();
        selected.remove(selected.size() - 1);
      }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int)tk.nval;
    tk.nextToken(); R = (int)tk.nval;
    DFS();
    wr.close();
  }
}
