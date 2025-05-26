package baekjoon.b2805;
import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[] A;

  static long compare(int middle) {
    long sum = 0;
    for (int tree : A)
      if (tree > middle)
        sum += tree - middle;
    return M - sum;
  }

  static int 파라매트릭서치_최대값(int left, int right) {
    while (left <= right) {
      int middle = (left + right) / 2;
      long r = compare(middle);
      if (r <= 0)
        left = middle + 1;
      else
        right = middle - 1;
    }
    return right;
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    M = scanner.nextInt();
    A = new int[N];
    int max = 0;
    for (int i = 0; i < N; ++i) {
      A[i] = scanner.nextInt();
      if (A[i] > max) max = A[i];
    }
    scanner.close();
    System.out.println(파라매트릭서치_최대값(0, max));
  }
}