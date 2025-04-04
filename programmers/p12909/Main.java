package programmers.p12909;

public class Main {
  static class Solution {
    public boolean solution(String s) {
      int count = 0;
      for (char ch : s.toCharArray()) {
        if (ch == '(') ++count;
        else if (ch == ')') --count;
        if (count < 0) return false;
      }
      return count == 0;
    }
  }

  public static void main(String[] args) {
    var sol = new Solution();
    System.out.println(sol.solution("()()"));
    System.out.println(sol.solution("(())()"));
    System.out.println(sol.solution(")()("));
    System.out.println(sol.solution("(()("));
  }
}