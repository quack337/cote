import java.util.*;

public class Solution {
  static ArrayList<int[]>[] links;

  int prim(int start) {
    int costSum = 0;
    var visited = new HashSet<Integer>();
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {start, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], cost = u[1];
      if (visited.contains(node)) continue;
      visited.add(node);
      costSum += cost;
      for (int[] link : links[node])
        queue.add(link);
    }
    return costSum;
  }

  @SuppressWarnings("unchecked")
  public int solution(int n, int[][] costs) {
    links = new ArrayList[n];
    for (int i = 0; i < n; ++i)
      links[i] = new ArrayList<>();
    int min = 0;
    for (int i = 0; i < costs.length; ++i) {
      if (costs[i][2] < costs[min][2]) min = i;
      int a = costs[i][0], b = costs[i][1], cost = costs[i][2];
      links[a].add(new int[] {b, cost});
      links[b].add(new int[] {a, cost});
    }
    return prim(costs[min][0]);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int n = 4; int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}; // 4
    System.out.println(s.solution(n, costs));

    n = 2; costs = new int[][] {{0,1,2}}; // 2
    System.out.println(s.solution(n, costs));

    n = 3; costs = new int[][] {{0,1,2},{0,2,3},{1,2,1}}; // 3
    System.out.println(s.solution(n, costs));

    n = 4; costs = new int[][] {{0,1,1},{0,2,2},{1,2,3},{1,3,2},{2,3,1}}; // 4
    System.out.println(s.solution(n, costs));

    n = 4; costs = new int[][] {{0,1,1},{0,2,1},{1,2,1},{1,3,2},{2,3,2}}; // 4
    System.out.println(s.solution(n, costs));
  }
}