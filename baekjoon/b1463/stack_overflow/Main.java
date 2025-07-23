package baekjoon.b1463.stack_overflow;
import java.io.*;

public class Main {
  static int[] M = new int[1000001];

  static int DP(int x) {
    if (x==1) return 0;
    if (M[x]>0) return M[x];
    int r = x-1;
    if (x%3==0) r=Math.min(r,DP(x/3)+1);
    if (x%2==0) r=Math.min(r,DP(x/2)+1);
    r=Math.min(r,DP(x-1)+1);
    return M[x]=r;
  }

  public static void main(String[] args) throws Exception {
    var rd = new BufferedReader(new InputStreamReader(System.in));
    int x = Integer.parseInt(rd.readLine());
    System.out.println(DP(x));
  }
}