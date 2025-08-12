package baekjoon.b9461;
import java.io.*;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    var P = new long[101];
    P[1] = P[2] = P[3] = 1;
    P[4] = P[5] = 2;
    for (int i = 6; i <= 100; ++i)
      P[i] = P[i-1] + P[i-5];
    var rd = new BufferedReader(new InputStreamReader(System.in));
    var sb = new StringBuilder();
    int T = Integer.parseInt(rd.readLine());
    for (int t = 0; t < T; ++t) {
      int N = Integer.parseInt(rd.readLine());
      sb.append(P[N]).append('\n');
    }
    System.out.println(sb);
  }
}