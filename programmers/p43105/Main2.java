package programmers.p43105;

public class Main2 {
  static class Solution {
    public int solution(int[][] dp) {
      for (int r = dp.length - 2; r >= 0; --r)
      for (int c = 0; c < dp[r].length; ++c)
        dp[r][c] += Math.max(dp[r+1][c], dp[r+1][c+1]);
      return dp[0][0];
    }
  }

  public static void main(String[] args) {
    var sol = new Solution();
    var a = new int[][] {{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}};
    System.out.println(sol.solution(a));
  }
}