package baekjoon.b16928;
import java.io.*;
import java.util.*;

public class Main {
  static int BFS(Map<Integer, Integer> jumpMap) {
    var visited = new boolean[101];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {1, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int val = u[0], distance = u[1];
      if (val == 100) return distance;
      if (visited[val]) continue;
      visited[val] = true;
      if (jumpMap.containsKey(val)) {
        val = jumpMap.get(val);
        if (visited[val]) continue;
        visited[val] = true;
      }
      for (int i = 1; i <= 6; ++i)
        if (val + i <= 100)
          queue.add(new int[] {val+i, distance+1});
    }
    return -1;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int N = scanner.nextInt();;
    int M = scanner.nextInt();;
    //int[] A = new int[N];
    var jumpMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < N + M; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      jumpMap.put(a, b);
    }
    scanner.close();
    System.out.println(BFS(jumpMap));
  }
}