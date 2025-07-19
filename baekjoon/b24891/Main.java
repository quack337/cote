package baekjoon.b24891;
import java.io.*;
import java.util.*;

public class Main {
  static int N, L;
  static char[][] A;
  static char[][] S;
  static boolean[] V;
  static StringBuilder bd = new StringBuilder();

  static boolean valid() {
    for (int i=1; i<L; ++i)
      for (int j=0; j<i; ++j)
        if (S[i][j]!=S[j][i]) return false;
    return true;
  }

  static boolean DFS(int n) {
    if (n==L) {
      if (!valid()) return false;
      for (var s : S)
        bd.append(new String(s)).append('\n');
      return true;
    }
    for (int i=0; i<N; ++i)
      if (!V[i]) {
        V[i]=true; S[n]=A[i];
        if (DFS(n+1)) return true;
        V[i]=false;
      }
    return false;
  }

  public static void main(String[] args) throws IOException {
    var rd = new BufferedReader(new InputStreamReader(System.in));
    var tk = new StringTokenizer(rd.readLine());
    L = Integer.parseInt(tk.nextToken());
    N = Integer.parseInt(tk.nextToken());
    var SA = new String[N];
    for (int i=0; i<N; ++i)
      SA[i] = rd.readLine();
    Arrays.sort(SA);
    A = new char[N][];
    for (int i=0; i<N; ++i)
      A[i] = SA[i].toCharArray();
    S = new char[L][];
    V = new boolean[N];
    DFS(0);
    var s = bd.toString();
    System.out.println(s.length()>0 ? s : "NONE");
  }
}