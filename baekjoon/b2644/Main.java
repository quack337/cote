package baekjoon.b2644;

import java.io.*;
import java.util.*;

public class Main {
  static int N;
  static ArrayList<Integer>[] neighbors;

  static int BFS(int start, int end) {
    boolean[] visited = new boolean[N];
    ArrayDeque<int[]> queue = new ArrayDeque<>();
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], distance = u[1];
      if (node == end) return distance;
      if (visited[node]) continue;
      visited[node] = true;
      for (int child : neighbors[node])
        if (!visited[child]) 
          queue.add(new int[] {child, distance+1});
    }
    return -1;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws NumberFormatException, IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    neighbors = new ArrayList[N];
    for (int i = 0; i < N; ++i)
      neighbors[i] = new ArrayList<Integer>();

    int start = scanner.nextInt() - 1;
    int end = scanner.nextInt() - 1;
    int M = scanner.nextInt();
    for (int i = 0; i < M; ++i) {
      int a = scanner.nextInt() - 1;
      int b = scanner.nextInt() - 1;
      neighbors[a].add(b);
      neighbors[b].add(a);
    }
    System.out.println(BFS(start, end));
    scanner.close();
  }
}