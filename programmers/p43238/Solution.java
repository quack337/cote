package programmers.p43238;

public class Solution {
  int N;
  int[] times;

  long compare(long middle) {
    long sum = 0;
    for (int time : times) {
      long temp = middle / time;
      if (temp > N) return 1;
      sum += temp;
      if (sum > N) return 1;
    }
    return sum - N;
  }

  long 파라매트릭서치_최소값(long left, long right) {
    while (left <= right) {
      long middle = (left + right) / 2;
      long r = compare(middle);
      if (r >= 0)
        right = middle - 1;
      else
        left = middle + 1;
    }
    return left;
  }

  public long solution(int N, int[] times) {
    this.N = N;
    this.times = times;
    return 파라매트릭서치_최소값(1, 1_000_000_000_000_000_000L);
  }

  public static void main(String[] args) {
    var sol = new Solution();
    System.out.println(sol.solution(6, new int[] {7, 10}));
  }
}