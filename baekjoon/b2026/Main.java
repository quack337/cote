package baekjoon.b2026;
import java.io.*;
import java.math.BigInteger;

public class Main {
  static int K, N, F;
  static BigInteger[] A;

  static BigInteger group(int a) {
    var g = A[a];
    if (g.bitCount() < K) return g;
    for (int b=1, cnt=0; b <= N; ++b)
      if (g.testBit(b)) {
        g = g.and(A[b]);
        if (++cnt >= K && g.bitCount() >= K) return g; 
         // K명의 친구 그룹을 전부 AND 했는데 K명 이상이면 바로 리턴.
         // 계속 더 AND를 하면 그룹의 크기가 줄어든다.
      }
    return g;
  }

  public static void main(String[] args) throws IOException {
   var wr = new BufferedWriter(new OutputStreamWriter(System.out));
   var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); K = (int)tk.nval;
    tk.nextToken(); N = (int)tk.nval;
    tk.nextToken(); F = (int)tk.nval;
    A = new BigInteger[N+1];
    for (int i=1; i <= N; ++i)
      A[i] = new BigInteger("0").setBit(i);
    for (int i=0; i < F; ++i) {
      tk.nextToken(); int a = (int)tk.nval;
      tk.nextToken(); int b = (int)tk.nval;
      A[a] = A[a].setBit(b); 
      A[b] = A[b].setBit(a);
    }

    // for (int a=1; a <= N; ++a)
    // System.out.println(Integer.toBinaryString(A[a].intValue()));

    for (int a=1; a <= N; ++a) {
      var g = group(a);
      if (g.bitCount() >= K) {
        for (int b=1, k=0; b <= N; ++b)
          if (g.testBit(b)) {
            wr.write(b + "\n");
            if (++k == K) break; // K명까지만 출력
          }
        wr.close();
        return;
      }
    }
    wr.write("-1\n");
    wr.close();
  }
}