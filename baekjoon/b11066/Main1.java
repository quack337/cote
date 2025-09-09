// 장 순서 상관없이 합쳐도 된다면, 이 구현이 맞다.
// 그러나 1,2,3 장 순서를 유지하며 합쳐야 한다.
package baekjoon.b11066;

import java.util.*;
import java.io.*;

public class Main1 {
  static int sol(PriorityQueue<Integer> queue) {
    int result = 0;
    while (queue.size() > 1) {
      int a = queue.remove();
      int b = queue.remove();
      int c = a + b;
      result += c;
      queue.add(c);
      System.out.printf("%d %d %d\n", a, b, c);
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); 
    int T = (int)tk.nval;
    var builder = new StringBuilder();
    for (int t=0; t < T; ++t) {
      tk.nextToken(); 
      int N = (int)tk.nval;
      var queue = new PriorityQueue<Integer>();
      for (int i=0; i < N; ++i) {
        tk.nextToken(); 
        System.out.printf("%d ", (int)tk.nval);
        queue.add((int)tk.nval);
      }
      System.out.println();
      builder.append(sol(queue)).append('\n');
    }
    System.out.println(builder.toString());
  }
}