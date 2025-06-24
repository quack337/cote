package baekjoon.b2458;
import java.io.*;
import java.util.*;

// 메모리 초과
public class Main1 {
  static int N, E;
  static int[] A;
  static List<Integer>[] 작다, 크다;

  static int DFS(int start, List<Integer>[] neighbors) {
    int size = 0;
    var visited = new boolean[N+1];
    var stack = new ArrayDeque<Integer>();
    stack.push(start);
    while (stack.size() > 0) {
      int node = stack.pop();
      if (visited[node]) continue;
      visited[node] = true;
      ++size;
      for (int neighbor : neighbors[node])
        stack.push(neighbor);
    }
    return size;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    E = scanner.nextInt();
    작다 = new ArrayList[N+1];
    크다 = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i) {
      작다[i] = new ArrayList<>();
      크다[i] = new ArrayList<>();
    }
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      크다[a].add(b);
      작다[b].add(a);
    }
    scanner.close();
    int answer = 0;
    for (int node = 1; node <= N; ++node)
      if (DFS(node, 작다) + DFS(node, 크다) == N+1)
        ++answer;
    System.out.println(answer);
  }
}