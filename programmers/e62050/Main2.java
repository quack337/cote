package programmers.e62050;

public class Main2 {
  static class Solution {
    void findGroup(int[][] heights, int HeightLimit, int row, int col, int[][] noMap, int no) {
      var stack = new java.util.ArrayDeque<int[]>();
      stack.push(new int[] { row, col, heights[row][col]});
      while (stack.size() > 0) {
        var node = stack.pop();
        int r = node[0], c = node[1], prevHeight = node[2];
        if (r < 0 || r >= heights.length || c < 0 || c >= heights.length) continue;
        if (noMap[r][c] != -1) continue;
        if (Math.abs(heights[r][c] - prevHeight) > HeightLimit) continue;
        noMap[r][c] = no;
        stack.push(new int[] {r - 1, c, heights[r][c]});
        stack.push(new int[] {r + 1, c, heights[r][c]});
        stack.push(new int[] {r, c - 1, heights[r][c]});
        stack.push(new int[] {r, c + 1, heights[r][c]});
      }
    }

    void findMinCosts(int[][] heights, int[][] noMap, int[][] minCosts) {
      var visited = new boolean[heights.length][heights.length];
      var stack = new java.util.ArrayDeque<int[]>();
      stack.push(new int[] { 0, 0, heights[0][0], noMap[0][0]});
      while (stack.size() > 0) {
        var node = stack.pop();
        int r = node[0], c = node[1], prevHeight = node[2], prevNo = node[3];
        if (r < 0 || r >= heights.length || c < 0 || c >= heights.length) continue;
        int no = noMap[r][c], height = heights[r][c];
        if (no != prevNo) {
          int cost = Math.abs(height - prevHeight);
          if (minCosts[prevNo][no] > cost)
            minCosts[prevNo][no] = cost;
        }
        if (visited[r][c]) continue;
        visited[r][c] = true;
        stack.push(new int[] {r - 1, c, height, no});
        stack.push(new int[] {r + 1, c, height, no});
        stack.push(new int[] {r, c - 1, height, no});
        stack.push(new int[] {r, c + 1, height, no});
      }
    }

    public int solution(int[][] land, int height) {
      final int N = land.length;
      int[][] noMap = new int[N][N];
      for (int[] row : noMap) java.util.Arrays.fill(row, -1);
      int no = 0;
      for (int a = 0; a < N; a++)
        for (int b = 0; b < N; b++)
          if (noMap[a][b] == -1)
            findGroup(land, height, a, b, noMap, no++);
      int[][] minCosts = new int[no][no];
      for (int[] row : minCosts) java.util.Arrays.fill(row, Integer.MAX_VALUE);
      findMinCosts(land, noMap, minCosts);
      int costSum = 0, visitedCount = 0;
      var visited = new boolean[no];
      final int TO = 0, COST = 1;
      var queue = new java.util.PriorityQueue<int[]>((a, b) -> a[COST] - b[COST]);
      queue.add(new int[] {0, 0});
      while (queue.size() > 0) {
        int[] link = queue.remove();
        if (visited[link[TO]]) continue;
        costSum += link[COST];
        var node = link[TO];
        visited[node] = true;
        if (++visitedCount == no) break;
        for (int to = 0; to < no; to++)
          if (!visited[to] && minCosts[node][to] < Integer.MAX_VALUE)
            queue.add(new int[] {to, minCosts[node][to]});
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

    land = new int[500][500];
    System.out.println(s.solution(land, 1));
  }
}