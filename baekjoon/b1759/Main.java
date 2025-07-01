package baekjoon.b1759;
import java.io.*;
import java.util.*;

public class Main {

  static int L, N, selectCount = 0;
  static char[] A, selected;
  static Writer wr = new BufferedWriter(new OutputStreamWriter(System.out));

  static void DFS(int from, int to) throws IOException {
    if (selectCount == L) {
      int 모음 = 0, 자음 = 0;
      for (char ch : selected)
        if (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') ++모음;
        else ++자음;
      if (모음 < 1 || 자음 < 2) return;
      for (char ch : selected) wr.write(ch);
      wr.write('\n');
      return;
    }
    for (int i = from; i <= to; ++i) {
      selected[selectCount] = A[i];
      ++selectCount;
      DFS(i + 1, to + 1);
      --selectCount;
    }
  }

  public static void main(String[] args) throws IOException {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var tk = new StringTokenizer(reader.readLine());
    L = Integer.parseInt(tk.nextToken());
    N = Integer.parseInt(tk.nextToken());
    selected = new char[L];
    A = new char[N];
    tk = new StringTokenizer(reader.readLine());
    for (int i = 0; i < N; ++i)
      A[i] = tk.nextToken().charAt(0);
    Arrays.sort(A);
    reader.close();
    DFS(0, N-L);
    wr.close();
  }
}