package baekjoon.b24480;
import java.io.*;
import java.util.*;

public class Main {
  static int N, E, no = 0;
  static List<Integer>[] neighbors;
  static int[] visited;

  static void DFS(int node) {
    if (visited[node] > 0) return;
    visited[node] = ++no;
    Collections.sort(neighbors[node], Collections.reverseOrder());
    for (int neighbor : neighbors[node])
      DFS(neighbor);
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    E = scanner.nextInt();
    int start = scanner.nextInt();
    visited = new int[N+1];
    neighbors = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i)
      neighbors[i] = new ArrayList<>();
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      neighbors[a].add(b);
      neighbors[b].add(a);
    }
    scanner.close();
    DFS(start);
    var builder = new StringBuilder();
    for (int i = 1; i <= N; ++i)
      builder.append(visited[i]).append('\n');
    System.out.println(builder.toString());
  }
}