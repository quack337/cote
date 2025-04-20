package programmers.p42748;
import java.util.Arrays;

public class Main {
  static class Solution {
    public int[] solution(int[] array, int[][] cmd) {
      int[] answer = new int[cmd.length];
      for (int i = 0; i < cmd.length; ++i) {
        int from = cmd[i][0] - 1, to = cmd[i][1], kIndex = cmd[i][2] - 1;
        int[] a = Arrays.copyOfRange(array, from, to);
        Arrays.sort(a);
        answer[i] = a[kIndex];
      }
      return answer;
    }
  }

  public static void main(String[] args) {
    int[] array = { 1, 5, 2, 6, 3, 7, 4 };
    int[][] cmd = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
    Solution sol = new Solution();
    System.out.println(Arrays.toString(sol.solution(array, cmd)));
  }
}