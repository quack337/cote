package baekjoon.b2961;
import java.io.*;
import java.util.*;

public class Main {
  static int N, 답 = Integer.MAX_VALUE;
  static int[][] A;
  static List<int[]> selected = new ArrayList<>();

  static void DFS(int index) {
  if (index == N) {
    if (selected.size() > 0) {
      int 신=1, 쓴=0;
      for (int[] e : selected) {
        신 *= e[0];
        쓴 += e[1];
      }
      답 = Math.min(답, Math.abs(신 - 쓴));
    }
    return;
  }
  selected.add(A[index]);
  DFS(index + 1);
  selected.remove(selected.size() - 1);
  DFS(index + 1);
}

  public static void main(String[] args) throws IOException {
   var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int)tk.nval;
    A = new int[N][2];
    for (int i = 0; i < N; ++i) {
      tk.nextToken(); A[i][0] = (int)tk.nval;
      tk.nextToken(); A[i][1] = (int)tk.nval;
    }
    DFS(0);
    System.out.println(답);
  }
}