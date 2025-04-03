package programmers.e258705;

public class Main3 {

  static class Solution {

    public int solution(int N, int[] tops) {
      final int M = 10007;
      int[] T = new int[N + 1], U = new int[N + 1];
      T[0] = U[0] = 1;
      T[1] = 3 + tops[0];
      U[1] = 2 + tops[0];
      for (int n = 2; n <= N; ++n) {
          T[n] = (T[n - 1] * (2 + tops[n - 1]) + U[n - 1]) % M;
          U[n] = (U[n - 1] * (2 + tops[n - 1]) + T[n - 2] * (1 + tops[n - 1])) % M;
      }
      return T[N];
    }
  }

  public static void main(String[] args) {
    System.out.println(new Solution().solution(4, new int[] { 1, 1, 0, 1 }));
    System.out.println(new Solution().solution(2, new int[] { 0, 1 }));
    System.out.println(new Solution().solution(10, new int[10]));
  }
}