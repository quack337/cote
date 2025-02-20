package baekjoon.p11.p11003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    var writer = new BufferedWriter(new OutputStreamWriter(System.out));
    String s = reader.readLine();
    var tokennizer = new StringTokenizer(s);
    int N = Integer.parseInt(tokennizer.nextToken());;
    int L = Integer.parseInt(tokennizer.nextToken());;
    long[] A = new long[N];
    s = reader.readLine();
    tokennizer = new StringTokenizer(s);
    for (int i = 0; i < N; ++i)
      A[i] = Long.parseLong(tokennizer.nextToken());
    var deque = new ArrayDeque<long[]>();
    for (int i = 0; i < N; ++i) {
      int left = Math.max(0, i - L + 1);
      while (deque.size() > 0 && deque.peekFirst()[1] < left)
        deque.removeFirst();
      while (deque.size() > 0 && deque.peekLast()[0] > A[i])
        deque.removeLast();
      deque.addLast(new long[] { A[i], i });
      writer.write(deque.peek()[0] + " ");
    }
    writer.write("\n");
    reader.close();
    writer.close();
  }
}
