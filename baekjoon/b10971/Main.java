package baekjoon.b10971;
import java.io.*;
import java.util.*;

public class Main {
  static int N, R, answer = Integer.MAX_VALUE;
  static int[][] A;
  static List<Integer> selected = new ArrayList<>();

  static void DFS() throws IOException {
    if (selected.size() == R) {
      int costSum = 0;
      selected.add(selected.get(0));
      for (int i = 0; i < N; ++i) {
        int cost = A[selected.get(i)][selected.get(i+1)];
        if (cost == 0) { costSum = Integer.MAX_VALUE; break; }
        costSum += cost;
      }
      selected.remove(selected.size()-1);
      if (costSum < answer) answer = costSum;
      return;
    }
    for (int i = 0; i < N; ++i)
      if (!selected.contains(i)) {
        selected.add(i);
        DFS();
        selected.remove(selected.size() - 1);
      }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = R = (int)tk.nval;
    A = new int[N][N];
    for (int r = 0; r < N; ++r)
      for (int c = 0; c < N; ++c) {
        tk.nextToken(); A[r][c] = (int)tk.nval;
      }
    DFS();
    System.out.println(answer);
  }
}
