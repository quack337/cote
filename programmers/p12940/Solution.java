package programmers.p12940;
public class Solution {
  public static int 최대공약수(int a, int b) {
    while (b != 0) {
      int t = a % b;
      a = b;
      b = t;
    }
    return a;
  }

  public static int 최소공배수(int a, int b) {
    return (a * b) / 최대공약수(a, b);
  }

  public static int[] solution(int a, int b) {
    return new int[]{최대공약수(a, b), 최소공배수(a, b)};
  }

  public static void main(String[] args) {
    System.out.println(java.util.Arrays.toString(solution(3, 12)));
    System.out.println(java.util.Arrays.toString(solution(2, 5)));
  }
}