package baekjoon.b10423;
// 출발 노드를 여러 개 넣으면, 그 수 만큼의 트리가 찾아진다.
// visited된 노드를 다시 방문하지 않기 때문에, 각 출발노드에서 시작한 트리가 서로 연결될 수 없다.
import java.io.*;
import java.util.*;

public class Main {
  static int V, E, K;
  static ArrayList<int[]>[] links;

  static int prim(int[] power) {
    int costSum = 0;
    var visited = new boolean[V+1];
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    for (int i = 0; i < K; ++i)
      queue.add(new int[] {power[i], 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      costSum += cost;
      for (int[] link : links[node])
        queue.add(link);
    }
    return costSum;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    V = scanner.nextInt();
    E = scanner.nextInt();
    K = scanner.nextInt();
    int[] power = new int[K];
    for (int i = 0; i < K; ++i)
      power[i] = scanner.nextInt();
    links = new ArrayList[V+1];
    for (int i = 1; i <= V; ++i)
      links[i] = new ArrayList<>();
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int cost = scanner.nextInt();
      links[a].add(new int[] {b, cost});
      links[b].add(new int[] {a, cost});
    }
    System.out.println(prim(power));
    scanner.close();
  }
}