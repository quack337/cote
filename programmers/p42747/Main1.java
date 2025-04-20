package programmers.p42747;
public class Main1 {
  static class Solution {
    public int solution(int[] citations) {
      for (int h = citations.length; h > 0; --h) {
        int count = 0;
        for (int value : citations)
          if (value >= h)
            ++count;
        if (count >= h)
          return h;
      }
      return 0;
    }
  }

  public static void main(String[] args) {
    var sol = new Solution();
    System.out.println(sol.solution(new int[] { 3, 0, 6, 1, 5 }));
    System.out.println(sol.solution(new int[] { 3, 3 }));
    System.out.println(sol.solution(new int[] {0}));
  }
}