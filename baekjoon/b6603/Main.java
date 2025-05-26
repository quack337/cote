package baekjoon.b6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int[] S;

  static void DFS(int index, List<Integer> selected) {
    if (selected.size() == 6) {
      System.out.println(selected.toString().replaceAll("[^0-9 ]", ""));
      return;
    }
    if (selected.size() + S.length - index < 6) return;
    selected.add(S[index]);
    DFS(index + 1, selected);
    selected.remove(selected.size() - 1);
    DFS(index + 1, selected);
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      int K = Integer.parseInt(tokenizer.nextToken());
      if (K == 0) break;
      S = new int[K];
      for (int i = 0; i < K; ++i)
        S[i] = Integer.parseInt(tokenizer.nextToken());
      DFS(0, new ArrayList<Integer>());
      System.out.println();
    }
  }
}