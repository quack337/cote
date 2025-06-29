package baekjoon.b15652;
import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static List<Integer> selected = new ArrayList<>();

  static void DFS() {
    if (selected.size() == M) {
      System.out.println(selected.toString().replaceAll("[^0-9 ]", ""));
      return;
    }
    int start = selected.size() == 0 ? 1 : selected.get(selected.size() - 1);
    for (int i = start; i <= N; ++i) {
      selected.add(i);
      DFS();
      selected.remove(selected.size() - 1);
    }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());
    DFS();
  }
}