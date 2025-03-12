// 메모리 초과
import java.util.Arrays;

public class Main {
  static class Solution {
    void findGroup(int[][] heights, int HeightLimit, int r, int c, int prevHeight, int[][] noMap, int no) {
      if (r < 0 || r >= heights.length || c < 0 || c >= heights.length) return;
      if (noMap[r][c] != -1) return;
      if (Math.abs(heights[r][c] - prevHeight) > HeightLimit) return;
      noMap[r][c] = no;
      findGroup(heights, HeightLimit, r - 1, c, heights[r][c], noMap, no);
      findGroup(heights, HeightLimit, r + 1, c, heights[r][c], noMap, no);
      findGroup(heights, HeightLimit, r, c - 1, heights[r][c], noMap, no);
      findGroup(heights, HeightLimit, r, c + 1, heights[r][c], noMap, no);
    }

    void findMinCosts(int[][] heights, int[][] noMap, int r, int c, int prevNo, int prevHeight, int[][] minCosts, boolean[][] visited) {
      if (r < 0 || r >= heights.length || c < 0 || c >= heights.length) return;
      int no = noMap[r][c];
      if (no != prevNo) {
        int cost = Math.abs(heights[r][c] - prevHeight);
        if (minCosts[prevNo][no] > cost)
          minCosts[prevNo][no] = cost;
      }
      if (visited[r][c]) return;
      visited[r][c] = true;
      findMinCosts(heights, noMap, r - 1, c, no, heights[r][c], minCosts, visited);
      findMinCosts(heights, noMap, r + 1, c, no, heights[r][c], minCosts, visited);
      findMinCosts(heights, noMap, r, c - 1, no, heights[r][c], minCosts, visited);
      findMinCosts(heights, noMap, r, c + 1, no, heights[r][c], minCosts, visited);
    }

    public int solution(int[][] land, int height) {
      int[][] noMap = new int[land.length][land.length];
      for (int[] row : noMap) Arrays.fill(row, -1);
      int no = 0;
      for (int a = 0; a < land.length; a++)
        for (int b = 0; b < land.length; b++)
          if (noMap[a][b] == -1)
            findGroup(land, height, a, b, land[a][b], noMap, no++);
      int[][] minCosts = new int[no][no];
      for (int[] row : minCosts) Arrays.fill(row, Integer.MAX_VALUE);
      boolean[][] visited = new boolean[land.length][land.length];
      findMinCosts(land, noMap, 0, 0, noMap[0][0], land[0][0], minCosts, visited);
      final int FROM = 0, TO = 1, COST = 2;
      int costSum = 0;
      var visited2 = new boolean[no];
      var queue = new java.util.PriorityQueue<int[]>((a, b) -> a[COST] - b[COST]);
      queue.add(new int[] {0, 0, 0});
      while (queue.size() > 0) {
        int[] link = queue.remove();
        if (visited2[link[TO]]) continue;
        costSum += link[COST];
        var node = link[TO];
        visited2[node] = true;
        for (int to = 0; to < no; to++)
          if (!visited2[to] && minCosts[node][to] < Integer.MAX_VALUE)
            queue.add(new int[] {node, to, minCosts[node][to]});
      }
      return costSum;
    }
  }

  public static void main(String[] args) {
    var s = new Solution();
    int[][] land = {{1, 2, 11, 12},{3, 42, 43, 13},{21, 41, 44, 33},{22, 23, 31, 32}};
    System.out.println(s.solution(land, 5));

    land = new int[][] {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
    System.out.println(s.solution(land, 3));

    land = new int[][] {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
    System.out.println(s.solution(land, 1));
  }
}
