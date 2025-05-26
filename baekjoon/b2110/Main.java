package baekjoon.b2110;
import java.io.*;
import java.util.*;

public class Main {
  static int N, C;
  static int[] A;

  static int compare(int middle) {
    int count = 1, prev = A[0];
    for (int i = 1; i < A.length; ++i)
      if (A[i] - prev >= middle) {
        ++count;
        prev = A[i];
      }
    return C - count;
  }

  static int 파라매트릭서치_최대값(int left, int right) {
    while (left <= right) {
      int middle = (left + right) / 2;
      int r = compare(middle);
      if (r <= 0)
        left = middle + 1;
      else
        right = middle - 1;
    }
    return right;
  }


  public static void main(String[] args) throws Exception {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    C = scanner.nextInt();
    A = new int[N];
    for (int i = 0; i < N; ++i)
      A[i] = scanner.nextInt();
    scanner.close();
    Arrays.sort(A);
    System.out.println(파라매트릭서치_최대값(1, A[N - 1] - A[0]));
  }
}