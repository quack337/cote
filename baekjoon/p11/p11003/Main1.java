package baekjoon.p11.p11003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 초과
public class Main1 {

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
    var queue = new PriorityQueue<long[]>((a, b) -> {
      long r = a[0] - b[0];
      return (r > 0) ? 1 : (r < 0) ? -1 : 0;
    });
    for (int i = 0; i < N; ++i) {
      int left = Math.max(0, i - L + 1);
      while (queue.size() > 0 && queue.peek()[1] < left)
        queue.remove();
      queue.add(new long[] { A[i], i });
      writer.write(queue.peek()[0] + " ");
    }
    writer.write("\n");
    reader.close();
    writer.close();
  }
}