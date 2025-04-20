package programmers.p42584;
public class Main {
  static class Solution {
    static final int PRICE = 0, INDEX = 1;

    void removeLarger(java.util.ArrayDeque<int[]> stack, int[] current, int[] answer) {
      while (!stack.isEmpty()) {
        int[] e = stack.peek();
        if (e[PRICE] <= current[PRICE]) return;
        answer[e[INDEX]] = current[INDEX] - e[INDEX];
        stack.pop();
      }
    }

    public int[] solution(int[] prices) {
      int[] answer = new int[prices.length];
      var stack = new java.util.ArrayDeque<int[]>();
      for (int i = 0; i < prices.length; i++) {
        int[] current = {prices[i], i};
        removeLarger(stack, current, answer);
        stack.push(current);
      }
      removeLarger(stack, new int[]{0, prices.length - 1}, answer);
      return answer;
    }
  }

  public static void main(String[] args) {
    int[] prices = {1, 2, 3, 2, 3};
    int[] result = new Solution().solution(prices);
    System.out.println(java.util.Arrays.toString(result));
  }
}