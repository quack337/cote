package programmers.p43236;
import java.util.*;

public class Solution {
  int N;
  int[] rocks;

  int compare(int middle) {
    int count = 0, prev = 0;
    for (int rock : rocks) {
      int 구간간격 = rock - prev;
      if (구간간격 < middle)
        ++count;
      else
        prev = rock;
    }
    return count - N;
  }

  int 파라매트릭서치_최대값(int left, int right) {
    while (left <= right) {
      int middle = (left + right) / 2;
      int r = compare(middle);
      if (r <= 0)
        left = middle + 1;
      else
        right = middle - 1;
    }
    return right;
  }

  public int solution(int distance, int[] rocks, int n) {
    this.N = n;
    this.rocks = Arrays.copyOf(rocks, rocks.length + 1);
    this.rocks[this.rocks.length - 1] = distance;
    Arrays.sort(this.rocks);
    return 파라매트릭서치_최대값(1, distance);
  }

  public static void main(String[] args) {
    var s = new Solution();
    var o = System.out;
    o.println(s.solution(4, new int[] {1,2,3}, 1)); // 1
    o.println(s.solution(4, new int[] {1,2,3}, 2)); // 2
    o.println(s.solution(4, new int[] {1,2,3}, 3)); // 4
    o.println(s.solution(25, new int[] {2,14,11,21,17}, 2)); // 4
  }
}