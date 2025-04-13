public class Test {
  static int 최대공약수(int a, int b){
    while (b != 0) {
        int t = a % b;
        a = b;
        b = t;
    }
    return a;
  }

  static int 최소공배수(int a, int b) {
    return a * b / 최대공약수(a, b);
  }

  static int 최소공배수(int[] a) {
    int result = a[0];
    for (int i = 1; i < a.length; ++i)
        result = 최소공배수(result, a[i]);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(최소공배수(new int[] {2, 3}));  // 6
    System.out.println(최소공배수(new int[] {3, 4, 5})); // 60
    System.out.println(최소공배수(new int[] {4, 5, 6, 7})); // 420
  }
}
