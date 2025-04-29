package programmers.p43162;

class Solution {
  public int solution(int n, int[][] linked) {
    int answer = 0;
    boolean[] visited = new boolean[n];
    for (int a = 0; a < n; ++a)
      if (!visited[a]) {
        answer++;
        DFS(a, n, linked, visited);
      }
    return answer;
  }

  private void DFS(int a, int n, int[][] linked, boolean[] visited) {
    visited[a] = true;
    for (int b = 0; b < n; ++b)
      if (linked[a][b] == 1 && !visited[b])
        DFS(b, n, linked, visited);
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    System.out.println(sol.solution(3,
                        new int[][]{{1,1,0},{1,1,0},{0,0,1}})); // 2
    System.out.println(sol.solution(3,
                        new int[][]{{1,1,0},{1,1,1},{0,1,1}})); // 1
  }
}
