package baekjoon.b16953;
// 오답
// 왜 틀리는지는 모르겟다. int overflow 였군.
import java.io.*;
import java.util.*;

public class Main1 {

  static int BFS(int A, int B) {
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {A, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int val = u[0], distance = u[1];
      if (val == B) return distance + 1;
      if (val <= 0 || val > B) continue;
      queue.add(new int[] {val*2, distance+1});
      queue.add(new int[] {val*10+1, distance+1});
    }
    return - 1;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int A = scanner.nextInt(), B = scanner.nextInt();
    scanner.close();
    System.out.println(BFS(A, B));
  }
}