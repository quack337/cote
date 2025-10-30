package baekjoon.b4781;
import java.io.*;
import java.util.*;

public class Main {
  static int N,M;
  static int[] P,C;
  static int[][] DP;
  static StringBuilder bd = new StringBuilder();

  static int BT(int n, int m) {
    if (n==N) return 0;
    if (DP[n][m] > -1)return DP[n][m];
    int c=C[n], p=P[n], x=0;
    for(int cc=0,pp=0; pp<=m; cc+=c,pp+=p)
      x = Math.max(x, BT(n+1,m-pp)+cc);
    return DP[n][m]=x;
  }

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    for(;;) {
      tk.nextToken(); N = (int)tk.nval; if(N==0) break;
      tk.nextToken(); M = (int)(tk.nval * 100);
      C = new int[N]; P = new int[N]; 
      for (int i=0; i<N; ++i) {
        tk.nextToken(); C[i]=(int)tk.nval;
        tk.nextToken(); P[i]=(int)(tk.nval * 100);
      }
      DP = new int[N][M+1];
      for (int[] row : DP) Arrays.fill(row,-1);
      bd.append(BT(0,M)).append('\n');
    }
    System.out.println(bd);
  }
}