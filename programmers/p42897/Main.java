package programmers.p42897;
public class Main {
  static class Solution {
    int[] DP;
    int[] money;

    int sol(int index) {
      if (index < DP.length && DP[index] >= 0) return DP[index];
      if (index >= money.length) return 0;
      if (index == money.length - 1) return money[index];
      int r1 = sol(index + 1);
      int r2 = money[index] + sol(index + 2);
      return DP[index] = r1 > r2 ? r1 : r2;
    }

    public int solution(int[] money) {
      this.money = money;
      DP = new int[money.length];
      java.util.Arrays.fill(DP, -1);
      var r1 = sol(1);

      DP = new int[money.length];
      java.util.Arrays.fill(DP, -1);
      money[money.length - 1] = 0;
      var r2 = money[0] + sol(2);
      return r1 > r2 ? r1 : r2;
    }
  }

  public static void main(String[] args) {
    var sol = new Solution();
    var r = sol.solution(new int[] {1,2,3,1});
    System.out.println(r);

    r = sol.solution(new int[1000]);
    System.out.println(r);
  }
}