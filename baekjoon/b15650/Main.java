package baekjoon.b15650;
import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static List<Integer> selected = new ArrayList<>();

  static void DFS(Writer writer) throws IOException {
    if (selected.size() == M) {
      for (int i : selected) writer.write(i + " ");
      writer.write("\n");
      return;
    }
    int start = selected.size() == 0 ? 1 : selected.get(selected.size() - 1) + 1;
    for (int i = start; i <= N; ++i) {
      selected.add(i);
      DFS(writer);
      selected.remove(selected.size() - 1);
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());
    DFS(writer);
    writer.close();
  }
}