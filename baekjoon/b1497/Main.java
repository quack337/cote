package baekjoon.b1497;
import java.io.*;

public class Main {
  static int N, M;
  static long[] A;
  static long CNT=0, SONG=0;

  static void DFS(int i, int cnt, long song) {
    if (i==N) {
      if (song > SONG) { SONG=song; CNT=cnt; }
      else if (song==SONG && cnt < CNT) CNT=cnt;
      return;
    }
    DFS(i+1, cnt, song);
    DFS(i+1, cnt+1, song | A[i]);
  }

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N=(int)tk.nval;
    tk.nextToken(); M=(int)tk.nval;
    A = new long[N];
    for (int i=0; i < N; ++i) {
      tk.nextToken(); tk.nextToken(); var s=tk.sval;
      var a = 0L;
      for (int j=0; j < s.length(); ++j)
        a = (a<<1) | (s.charAt(j)=='Y' ? 1 : 0);
      A[i] = a;
    }
    DFS(0,0,0L);
    System.out.println(SONG > 0 ? CNT : -1);
  }
}