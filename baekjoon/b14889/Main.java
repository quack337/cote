package baekjoon.b14889;
import java.io.*;
import java.util.*;

public class Main {
  static int N, ROW, COL, answer = Integer.MAX_VALUE;
  static int[][] A;
  static Set<Integer> selected = new HashSet<>();

  static int skill(Set<Integer> list) {
    int val = 0;
    for (int a : list)
      for (int b : list)
        if (a != b) val += A[a][b];
    return val;
  }

  static void DFS(int from, int to) {
    if (selected.size() == N/2) {
      var notSelected = new HashSet<Integer>();
      for (int i = 0; i < N; ++i)
        if (!selected.contains(i)) notSelected.add(i);
      int temp = Math.abs(skill(selected) - skill(notSelected));
      if (temp < answer) answer = temp;
      return;
    }
    for (int i = from; i <= to; ++i) {
      selected.add(i);
      DFS(i + 1, to + 1);
      selected.remove(i);
    }
  }

  public static void main(String[] args) throws IOException {
   var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = ROW = COL = (int)tk.nval;
    A = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        tk.nextToken(); A[r][c] = (int)tk.nval;
      }
    DFS(0, N - N/2);
    System.out.println(answer);
  }
}