package programmers.p42897;
public class Main1 {
  static class Solution {

    public int solution(int[] money) {
      int N = money.length;
      var DP = new int[N];
      DP[0] = 0;
      DP[1] = money[1];
      for (int i = 2; i < N; ++i)
        DP[i] = Math.max(money[i] + DP[i - 2], DP[i - 1]);
      DP[0] = money[0];
      DP[1] = Math.max(money[0], money[1]);
      for (int i = 2; i < N - 1; ++i)
        DP[i] = Math.max(money[i] + DP[i - 2], DP[i - 1]);
      return Math.max(DP[N - 2], DP[N - 1]);
    }
  }

  public static void main(String[] args) {
    var sol = new Solution();
    var r = sol.solution(new int[] {1,2,3,1});
    System.out.println(r);

    r = sol.solution(new int[1000000]);
    System.out.println(r);
  }
}