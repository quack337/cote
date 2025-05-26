package baekjoon.b15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N, M;

  static void DFS(List<Integer> selected) {
    if (selected.size() == M) {
      System.out.println(selected.toString().replaceAll("[^0-9 ]", ""));
      return;
    }
    for (int i = 1; i <= N; ++i)
      if (!selected.contains(i)) {
        selected.add(i);
        DFS(selected);
        selected.remove(selected.size() - 1);
      }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());
    DFS(new ArrayList<Integer>());
  }
}