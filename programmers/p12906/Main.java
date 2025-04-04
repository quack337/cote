package programmers.p12906;

public class Main {
  static class Solution {
    public int[] solution(int[] arr) {
      var answer = new java.util.ArrayList<Integer>();
      answer.add(arr[0]);
      for (int value : arr)
        if (value != answer.get(answer.size() - 1))
          answer.add(value);
      return answer.stream().mapToInt(i -> i).toArray();
    }
  }

  public static void main(String[] args) {
    var sol = new Solution();
    int[] a1 = sol.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
    int[] a2 = sol.solution(new int[]{4, 4, 4, 3, 3});
    System.out.println(java.util.Arrays.toString(a1));
    System.out.println(java.util.Arrays.toString(a2));
  }
}