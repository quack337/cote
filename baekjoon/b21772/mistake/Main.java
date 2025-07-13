package baekjoon.b21772;
import java.io.*;
import java.util.*;

public class Main {
  static int RN, CN, T, ANS=0;
  static char[][] A;
  static int[] G;
  static int[][] DIST;
  static boolean[] V;
  static List<int[]> B = new ArrayList<>();

  static int BFS(int i0, int ig) {
    if (DIST[i0][ig] > 0) return DIST[i0][ig];
    int rg = B.get(ig)[0], cg = B.get(ig)[1];
    var visited = new boolean[RN][CN];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {B.get(i0)[0], B.get(i0)[1], 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r=u[0], c=u[1], dist=u[2];
      if (visited[r][c] || A[r][c]=='#') continue;
      visited[r][c] = true;
      if (r==rg && c==cg) return DIST[i0][ig]=DIST[ig][i0]=dist;
      if (r>0) queue.add(new int[] {r-1,c,dist+1});
      if (c>0) queue.add(new int[] {r,c-1,dist+1});
      if (r<RN-1) queue.add(new int[] {r+1,c,dist+1});
      if (c<CN-1) queue.add(new int[] {r,c+1,dist+1});
    }
    return 99_999_999;
  }

  static void DFS(int a, int t, int ans) {
    if (t >= 0 && ans > ANS) ANS = ans;
    if (t <= 0) return;
    for (int b=1; b < B.size(); ++b)
      if (!V[b]) { V[b]=true; DFS(b,t-BFS(a,b), ans+1); V[b]=false; }
  }

  public static void main(String[] args) throws IOException {
    var rd = new BufferedReader(new InputStreamReader(System.in));
    var tk = new StringTokenizer(rd.readLine());
    RN = Integer.parseInt(tk.nextToken());
    CN = Integer.parseInt(tk.nextToken());
    T = Integer.parseInt(tk.nextToken());
    A = new char[RN][];
    for (int r = 0; r < RN; ++r) {
      A[r] = rd.readLine().toCharArray();
      for (int c = 0; c < CN; ++c) {
        if (A[r][c]=='G') G = new int[] {r,c};
        else if (A[r][c]=='S') B.add(new int[] {r,c});
      }
    }
    B.add(0, G);
    int n = B.size();
    V = new boolean[n];
    DIST = new int[n][n];
    DFS(0, T, 0);
    System.out.println(ANS);
  }
}