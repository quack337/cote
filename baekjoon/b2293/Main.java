package baekjoon.b2293;
import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {
    var br = new BufferedReader(new InputStreamReader(System.in));
    var tk = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(tk.nextToken());
    int K = Integer.parseInt(tk.nextToken());
    int[] A = new int[N];
    for (int i=0; i < N; ++i)
      A[i] = Integer.parseInt(br.readLine());
    int[] M  = new int[K+1];
    M[K] = 1;
    for (int i=0; i < N; ++i) 
      for (int 동전=A[i], 금액=K; 금액-동전 >=0; --금액)
        M[금액-동전] += M[금액];
    System.out.println(M[0]);
  }
}