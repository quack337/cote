package programmers.e42897;

public class Main {
  static class Solution {
    long[] DP;
    int[] money;

    long sol(int index) {
      if (index < DP.length && DP[index] > 0) return DP[index];
      if (index >= money.length) return 0;
      if (index == money.length - 1) return money[index];
      long r1 = sol(index + 1);
      long r2 = money[index] + sol(index + 2);
      return DP[index] = r1 > r2 ? r1 : r2;
    }

    public long solution(int[] money) {
      this.money = money;
      DP = new long[money.length];
      return sol(0);
    }
  }

  public static void main(String[] args) {
    var sol = new Solution();
    var r = sol.solution(new int[] {1,2,3,1});
    System.out.println(r);
  }
}