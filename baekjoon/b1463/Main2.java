package baekjoon.b1463;
import java.io.*;

public class Main2 {

  public static void main(String[] args) throws IOException {
    var rd = new BufferedReader(new InputStreamReader(System.in));
    int X = Integer.parseInt(rd.readLine());
    final int INF = 1_000_000;
    int[] M = new int[X + 1];
    M[1] = 0;
    for (int x=2; x <= X; ++x) {
      int a = INF, b = INF;
      if (x % 3 == 0) a = M[x/3];
      if (x % 2 == 0) b = M[x/2];
      int c = M[x-1];
      M[x] = Math.min(Math.min(a, b), c) + 1;
    }
    System.out.println(M[X]);
  }
}
