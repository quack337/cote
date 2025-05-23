import java.util.*;

public class Main {
  static int N;
  static ArrayList<Integer>[] children;

  static int[] BFS(int start) {
    var distances = new int[N+1];
    Arrays.fill(distances, -1);
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], distance = u[1];
      distances[node] = distance;
      for (int child : children[node])
        queue.add(new int[] {child, distance+1});
    }
    return distances;
  }

  void t() {
int ROW = 5, COL = 9;
int[][] A = {
  {0,1,0,0,0,1,0,0,0},
  {0,1,0,1,0,0,0,1,0},
  {0,0,0,1,0,1,0,1,0},
  {1,1,0,1,0,1,0,1,0},
  {0,0,0,0,0,1,0,0,0}};

  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    N = 7;
    children = new ArrayList[N + 1];
    for (int i = 1; i <= N; ++i)
      children[i] = new ArrayList<Integer>();
    int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 7}};
    for (int[] edge : edges) {
      int a = edge[0], b = edge[1];
      children[a].add(b);
    }
    int[] distances = BFS(2);
    for (int node = 1; node <= N; ++node)
      System.out.printf("%d: %d\n", node, distances[node]);
  }
}
