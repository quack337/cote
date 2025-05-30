package programmers.p12978;

import java.util.*;

public class Solution {
  ArrayList<int[]>[] edges;

  int[] dijkstra(int N) {
    int[] distances = new int[N+1];
    Arrays.fill(distances, -1);
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    queue.add(new int[] {1, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int node = u[0], distance = u[1];
      if (distances[node] != -1) continue;
      distances[node] = distance;
      for (int[] edge : edges[node]) {
        int neighbor = edge[0], cost = edge[1];
        queue.add(new int[] {neighbor, distance + cost});
      }
    }
    return distances;
  }

  @SuppressWarnings("unchecked")
  public int solution(int N, int[][] road, int K) {
    edges = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i)
      edges[i] = new ArrayList<int[]>();
    for (int[] r : road) {
      int a = r[0], b = r[1], cost = r[2];
      edges[a].add(new int[] {b, cost});
      edges[b].add(new int[] {a, cost});
    }
    int[] distances = dijkstra(N);
    int answer = 0;
    for (int i = 1; i <= N; ++i)
        if (distances[i] <= K) ++answer;
    return answer;
  }

  public static void main(String[] args) {
    var s = new Solution();
    System.out.println(s.solution(5, new int[][] {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}}, 3)); // 4
    System.out.println(s.solution(6, new int[][] {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}}, 4)); // 4
  }
}