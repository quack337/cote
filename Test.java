public class Test {

  static int nCr(int n, int r) {
    System.out.printf("%d %d\n", n, r);
      if (r < 0 || r > n) return 0;
      if (r == 0 || r == n) return 1;
      return nCr(n-1, r-1) + nCr(n - 1, r);
  }

  public static void main(String[] args) {
    System.out.println(nCr(3, 1));
  }
}
