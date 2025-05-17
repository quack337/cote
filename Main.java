import java.util.Arrays;
import java.util.Comparator;

public class Main {

  public static void main(String[] args) {
    int[][] A = new int[][] {{4, 2}, {3, 5}, {1, 2}, {7, 5}, {4, 3}, {2, 2}};
    Comparator<int[]> comparator = (a, b) -> {
      if (a[0] != b[0]) return a[0] - b[0];
      return a[1] - b[1];
    };
    Arrays.sort(A, comparator);
    int i = Arrays.binarySearch(A, new int[] {4, 3}, comparator);
    System.out.println(i);

    int j = Arrays.binarySearch(A, new int[] {4, 4}, comparator);
    System.out.printf("%d, %d\n", j, -j - 1);
  }
}
