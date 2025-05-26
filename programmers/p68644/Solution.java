import java.util.*;

public class Solution {
  public int[] solution(int[] numbers) {
    Set<Integer> set = new TreeSet<>();
    int N = numbers.length;
    for (int i = 0; i < N - 1; ++i)
      for (int j = i + 1; j < N; ++j)
        set.add(numbers[i] + numbers[j]);
    return set.stream().mapToInt(Integer::intValue).toArray();
  }

  public static void main(String[] args) {
    var sol = new Solution();
    var out = System.out;
    out.println(Arrays.toString(sol.solution(new int[] {2,1,3,4,1})));
    out.println(Arrays.toString(sol.solution(new int[] {5,0,2,7})));
  }
}
