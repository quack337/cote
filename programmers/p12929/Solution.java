public class Solution {
  int solution(int n, int prev) {
    if (n == 0) return 1;
    int result = 0;
    for (int i = prev + 1; i >= 1; --i) {
      result += solution(n - 1, i);
    }
    return result;
  }

  public int solution(int n) {
    return solution(n, 0);
  }

  public static void main(String[] args) {
    var sol = new Solution();
    System.out.println(sol.solution(1));
    System.out.println(sol.solution(2));
    System.out.println(sol.solution(3));
    System.out.println(sol.solution(4));
  }
}
