package programmers.p49189;

import java.util.*;

public class Solution {
  ArrayList<Integer>[] neighbors;
  int[] distances;

  void BFS(int N) {
    Arrays.fill(distances, -1);
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] { 0, 0 });
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], distance = u[1];
      if (distances[node] > -1)
        continue;
      distances[node] = distance;
      for (int v : neighbors[node])
        if (distances[v] == -1)
          queue.add(new int[] { v, distance + 1 });
    }
  }

  @SuppressWarnings("unchecked")
  public int solution(int n, int[][] edge) {
    neighbors = new ArrayList[n];
    for (int i = 0; i < n; ++i)
      neighbors[i] = new ArrayList<Integer>();
    for (int[] e : edge) {
      int a = e[0] - 1, b = e[1] - 1;
      neighbors[a].add(b);
      neighbors[b].add(a);
    }
    distances = new int[n];
    BFS(n);
    int maxDistance = 0, count = 0;
    for (int distance : distances)
      if (distance > maxDistance) {
        maxDistance = distance;
        count = 1;
      } else if (distance == maxDistance)
        ++count;
    return count;
  }

  public static void main(String[] args) {
    var sol = new Solution();
    System.out.println(sol.solution(6,new int[][]
                {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
  }
}