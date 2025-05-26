package baekjoon.b18352;

import java.io.*;
import java.util.*;

public class Main {
  static int N, M, K, X; // 도시 수, 도로 수, 목표거리, 출발
  static ArrayList<Integer>[] neighbors;

  static List<Integer> BFS() {
    var result = new ArrayList<Integer>();
    var visited = new boolean[N+1];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {X, 0});
    while (queue.size() > 0) {
      var u = queue.remove();
      int node = u[0], distance = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      if (distance == K) result.add(node); // visited 보다 먼저 하면 안됨. data1 예제에서 오류
      else if (distance > K) break;
      for (int neighbor : neighbors[node])
        queue.add(new int[] {neighbor, distance+1});
    }
    return result;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    M = scanner.nextInt();
    K = scanner.nextInt();
    X = scanner.nextInt();
    neighbors = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i)
      neighbors[i] = new ArrayList<>();
    for (int i = 0; i < M; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      neighbors[a].add(b);
    }
    scanner.close();
    var result = BFS();
    if (result.size() == 0)
      System.out.println(-1);
    else {
      Collections.sort(result);
      System.out.println(result.toString().replaceAll("[^0-9 ]","").replaceAll(" ", "\n"));
    }
  }
}
