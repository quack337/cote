package programmers.p42587;
public class Main {
  static class Solution {
    public int higherCount(java.util.ArrayDeque<Integer> queue, int priority) {
      int count = 0;
      for (int p : queue)
        if (Math.abs(p) > priority)
          count++;
      return count;
    }

    public int solution(int[] priorities, int location) {
      priorities[location] *= -1;
      var queue = new java.util.ArrayDeque<Integer>();
      for (int p : priorities)
        queue.add(p);
      int count = 0;
      while (true) {
        int p = queue.poll();
        if (p > 0) {
          if (higherCount(queue, p) == 0) count++;
          else queue.add(p);
        } else {
          if (higherCount(queue, -p) == 0) break;
          else queue.add(p);
        }
      }
      return count + 1;
    }
  }

  public static void main(String[] args) {
    var sol = new Solution();
    System.out.println(sol.solution(new int[]{2, 1, 3, 2}, 2));
    System.out.println(sol.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
  }
}