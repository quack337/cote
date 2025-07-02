package baekjoon.b10819;
import java.io.*;
import java.util.*;

public class Main {
  static int N, R, answer = 0;
  static int[] A;
  static List<Integer> selected = new ArrayList<>();

  static void DFS() throws IOException {
      if (selected.size() == R) {
      int sum = 0;
      for (int i = 0; i < N-1; ++i)
        sum += Math.abs(A[selected.get(i)] - A[selected.get(i+1)]);
      if (sum > answer) answer = sum;
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
    tk.nextToken(); N = (int)tk.nval; R = N;
    A = new int[N];
    for (int i = 0; i < N; ++i) {
      tk.nextToken(); A[i] = (int)tk.nval;
    }
    DFS();
    System.out.println(answer);
  }
}