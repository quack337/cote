import java.util.Arrays;

public class Arr1 {

  static int[][] test1(int n) {
    var a = new int[n][n];
    for (int r = 0; r < n; ++r)
      for (int c = 0; c < n; ++c)
        a[r][c] = r * n + c + 1;
    return a;
  }

  static void print(int[][] a) {
    for (int r = 0; r < a.length; ++r)
      System.out.println(Arrays.toString(a[r]));
  }

  public static void main(String[] args) {
    print(test1(5));
  }
}