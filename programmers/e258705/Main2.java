package programmers.e258705;

public class Main2 {

  static class Solution {

    public int solution(int N, int[] tops) {
      final int M = 10007;
      int[][] T = new int[3][N + 1];
      T[0][0] = 1;
      T[1][0] = 1;
      T[1][1] = 2 + tops[0];
      for (int n = 2; n <= N; ++n) {
        T[n % 3][0] = 1;
        T[n % 3][1] = T[(n - 1) % 3][1] + 2 + tops[n - 1];
        for (int i = 2; i <= n; ++i) {
          T[n % 3][i] = (T[(n - 1) % 3][i] + T[(n - 1) % 3][i - 1] * (2 + tops[n - 1]) - T[(n - 2) % 3][i - 2]);
          T[n % 3][i] %= M;
        }
      }
      int answer = 0;
      for (int i = 0; i <= N; ++i)
        answer = (answer + T[N % 3][i]) % M;
      return answer >= 0 ? answer : answer + M;
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().solution(4, new int[] { 1, 1, 0, 1 }));
    System.out.println(new Solution().solution(2, new int[] { 0, 1 }));
    System.out.println(new Solution().solution(10, new int[10]));
  }
}
