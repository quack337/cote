import java.util.*;

public class Main {
  static int N;
  static ArrayList<int[]>[] edges;

  static int dijkstra(int start, int goal) {
    var visited = new boolean[N+1];
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], distance = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      if (node == goal) return distance;
      for (int[] edge : edges[node]) {
        int neighbor = edge[0], cost = edge[1];
        queue.add(new int[] {neighbor, distance + cost});
      }
    }
    return -1;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    N = 6;
    edges = new ArrayList[N + 1];
    for (int i = 1; i <= N; ++i)
      edges[i] = new ArrayList<int[]>();
    final int[][] EDGES = {{1,2,1},{1,3,2},{2,3,2},{2,4,3},{2,5,1},
      {3,4,1},{3,6,3},{4,5,1},{4,6,1}};
    for (int[] edge : EDGES) {
      int a = edge[0], b = edge[1], cost = edge[2];
      edges[a].add(new int[]{b, cost});
      edges[b].add(new int[]{a, cost});
    }
    System.out.println(dijkstra(1, 6));
  }
}
