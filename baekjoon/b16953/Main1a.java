package baekjoon.b16953;
// 정답
// 왜 틀리는지는 모르겟다
import java.io.*;
import java.util.*;

public class Main1a {

  static int BFS(int A, int B) {
    var queue = new ArrayDeque<long[]>();
    queue.add(new long[] {A, 0});
    while (queue.size() > 0) {
      long[] u = queue.remove();
      long val = u[0], distance = u[1];
      if (val == B) return (int)distance + 1;
      if (val > B) continue;
      queue.add(new long[] {val*2, distance+1});
      queue.add(new long[] {val*10 + 1, distance+1});
    }
    return -1;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int A = scanner.nextInt(), B = scanner.nextInt();
    scanner.close();
    System.out.println(BFS(A, B));
  }
}