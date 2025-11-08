package baekjoon.b17090;
import java.io.*;
import java.util.*;

public class Main {
  static int R, C;
  static char[][] A;
  static int[][] DP;
  static boolean[][] V;

  public static int BT(int r, int c) {
    if (r<0 || r>=R || c<0 || c>=C) return 1;
    if (DP[r][c] != 0) return DP[r][c];
    if (V[r][c]) return DP[r][c]=-1;
    V[r][c] = true;
    int y=0,x=0;
    switch (A[r][c]) {
      case 'U': y=-1; break;
      case 'D': y=1; break;
      case 'L': x=-1; break;
      case 'R': x=1; break;
    }
    return DP[r][c] = BT(r+y,c+x);
  }

  public static void main(String[] args) throws IOException {
    var br = new BufferedReader(new InputStreamReader(System.in));
    var tk = new StringTokenizer(br.readLine());
    R = Integer.parseInt(tk.nextToken());
    C = Integer.parseInt(tk.nextToken());
    DP = new int[R][C];
    V = new boolean[R][C];
    A = new char[R][];
    for (int i=0; i<R; ++i)
      A[i] = br.readLine().toCharArray();
    int X=0;
    for (int r=0;r<R;++r)
    for (int c=0;c<C;++c)
      if (BT(r,c)==1) ++X;
    System.out.println(X);
  }
}
