public class Solution {
  public static int sum(int from, int to) {
    System.out.printf("%d %d\n", from, to); // 가)
    if (from == to) return from;
    return from + sum(from + 1, to);
  }

  public static void main(String[] args) {
    System.out.println(sum(2, 5)); // 나)
  }
}
