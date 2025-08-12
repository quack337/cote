package baekjoon.b12865;
import java.io.*;

public class Main {
  static int N, K;
  static int[] W, V;
  static int[][] DP;

  static int DFS(int index, int weight) {
    if (index >= N || weight <= 0) return 0;
    if (DP[index][weight] > 0) return DP[index][weight];
    int value1 = 0, value2 = 0;
    value1 = DFS(index + 1, weight);
    if (W[index] <= weight)
      value2 = V[index] + DFS(index + 1, weight - W[index]);
    return DP[index][weight] = Math.max(value1, value2);
  }

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int) tk.nval;
    tk.nextToken(); K = (int) tk.nval;
    W = new int[N]; V = new int[N];
    DP = new int[N][K + 1];
    for (int i = 0; i < N; ++i) {
      tk.nextToken(); W[i] = (int) tk.nval;
      tk.nextToken(); V[i] = (int) tk.nval;
    }
    System.out.println(DFS(0, K));
  }
}
