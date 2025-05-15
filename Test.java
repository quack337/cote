public class Test {
<<<<<<< HEAD
  public static void PrintIndicesForValue(int[] numbers, int target) {
    if (numbers == null)
      return;

    int low = 0, high = numbers.length - 1;
    // get the start index of target number
    int startIndex = -1;
    while (low <= high) {
      int mid = (high - low) / 2 + low;
      if (numbers[mid] > target) {
        high = mid - 1;
      } else if (numbers[mid] == target) {
        startIndex = mid;
        high = mid - 1;
      } else
        low = mid + 1;
    }

    // get the end index of target number
    int endIndex = -1;
    low = 0;
    high = numbers.length - 1;
    while (low <= high) {
      int mid = (high - low) / 2 + low;
      if (numbers[mid] > target) {
        high = mid - 1;
      } else if (numbers[mid] == target) {
        endIndex = mid;
        low = mid + 1;
      } else
        low = mid + 1;
    }

    if (startIndex != -1 && endIndex != -1) {
      for (int i = 0; i + startIndex <= endIndex; i++) {
        if (i > 0)
          System.out.print(',');
        System.out.print(i + startIndex);
      }
    }
=======

  static int nCr(int n, int r) {
    System.out.printf("%d %d\n", n, r);
      if (r < 0 || r > n) return 0;
      if (r == 0 || r == n) return 1;
      return nCr(n-1, r-1) + nCr(n - 1, r);
  }

  public static void main(String[] args) {
    System.out.println(nCr(3, 1));
>>>>>>> origin/main
  }
}
