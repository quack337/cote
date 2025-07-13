package baekjoon;
import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL;
  static int[][] A;

  public static void main(String[] args) throws IOException {
   var wr = new BufferedWriter(new OutputStreamWriter(System.out));
   var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); ROW = COL = (int)tk.nval;
    A = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c) {
        tk.nextToken(); A[r][c] = (int)tk.nval;
      }
    wr.close();
  }

  /*
  static int N;
  static int[] A;

  public static void main(String[] args) throws IOException {
   var wr = new BufferedWriter(new OutputStreamWriter(System.out));
   var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int)tk.nval;
    A = new int[N];
    for (int i = 0; i < N; ++i) {
      tk.nextToken(); A[i] = (int)tk.nval;
    }
    wr.close();
  }

  static int ROW, COL;
  static char[][] A;

  public static void main1(String[] args) throws IOException {
   var wr = new BufferedWriter(new OutputStreamWriter(System.out));
   var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); ROW = (int)tk.nval;
    tk.nextToken(); COL = (int)tk.nval;
    A = new char[ROW][];
    for (int r = 0; r < ROW; ++r) {
      tk.nextToken(); A[r] = tk.sval.toCharArray();
    }
    wr.close();
  }
*/
}