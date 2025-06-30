package baekjoon.b15652;
import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static List<Integer> selected = new ArrayList<>();
  static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

  static void DFS(int from) throws IOException {
    if (selected.size() == M) {
      for (int i : selected)
        wr.write(i + " ");
      wr.write("\n");
      return;
    }
    for (int i = from; i <= N; ++i) {
      selected.add(i);
      DFS(i);
      selected.remove(selected.size() - 1);
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int)tk.nval;
    tk.nextToken(); M = (int)tk.nval;
    DFS(1);
    wr.close();
  }
}