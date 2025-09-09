package baekjoon.b11066;
import java.io.*;

public class Main2 {
  static int[] A;
  static int[][] SIZE;
  static int[][] COST;

  static void DFS(int from, int to) {
    if (from == to) {
      COST[from][from] = 0;
      SIZE[from][from] = A[from];
      return;
    }
    int cost = Integer.MAX_VALUE, size = 0;
    for (int i=from; i<to; ++i) {
      if (COST[from][i]==0) DFS(from, i);
      if (COST[i+1][to]==0) DFS(i+1, to);
      int size3 = SIZE[from][i] + SIZE[i+1][to];
      int cost3 = COST[from][i] + COST[i+1][to] + size3;
      if (cost3 < cost) {
        cost = cost3;
        size = size3;
      }
    }
    COST[from][to] = cost;
    SIZE[from][to] = size;
  }

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); 
    int T = (int)tk.nval;
    var builder = new StringBuilder();
    for (int t=0; t < T; ++t) {
      tk.nextToken(); 
      int N = (int)tk.nval;
      A = new int[N];
      for (int i=0; i < N; ++i) {
        tk.nextToken(); 
        A[i] = (int)tk.nval;
      }
      COST = new int[N][N];
      SIZE = new int[N][N];
      DFS(0, N-1);
      builder.append(COST[0][N-1]).append('\n');
    }
    System.out.println(builder.toString());
  }
}