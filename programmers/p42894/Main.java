package programmers.p42894;

public class Main {
  static class Solution {
    public int solution(int rowCount, int colCount, int[][] puddles) {
      var DP = new int[rowCount+1][colCount+1];
      var 홍수 = new boolean[rowCount+1][colCount+1];
      for (var p : puddles) 홍수[p[0]][p[1]] = true;
      DP[1][0] = 1;
      for (int r = 1; r <= rowCount; ++r)
      for (int c = 1; c <= colCount; ++c)
        if (!홍수[r][c])
          DP[r][c] = (DP[r - 1][c] + DP[r][c - 1]) % 1_000_000_007;
      return DP[rowCount][colCount];   
    }
  }

  public static void main(String[] args) {
    var sol = new Solution();
    System.out.println(sol.solution(4,3,new int[][] {{2,2}}));
  }
}