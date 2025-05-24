package baekjoon.b24444;
import java.io.*;
import java.util.*;

public class Main {
  static int N, M, START, no = 1;
  static ArrayList<Integer>[] neighbors;
  static int[] answer;

  static void BFS() {
    answer = new int[N+1];
    var visited = new boolean[N+1];
    var queue = new ArrayDeque<Integer>();
    queue.add(START);
    visited[START] = true;
    while (queue.size() > 0) {
      int u = queue.remove();
      answer[u] = no;
      ++no;
      Collections.sort(neighbors[u]);
      for (int neighbor : neighbors[u])
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.add(neighbor);
        }
    }
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    M = scanner.nextInt();
    START = scanner.nextInt();
    neighbors = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i)
      neighbors[i] = new ArrayList<>();
    for (int i = 0; i < M; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      neighbors[a].add(b);
      neighbors[b].add(a);
    }
    scanner.close();
    BFS();
    var builder = new StringBuilder();
    for (int i = 1; i < answer.length; ++i)
      builder.append(answer[i]).append('\n');
    System.out.println(builder.toString());
  }
}
