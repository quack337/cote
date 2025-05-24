package baekjoon.b2343;
import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static int[] A;

  static int compare(int middle) {
    int count = 1, 남은용량 = middle;
    for (int 영상 : A)
      if (영상 <= 남은용량)
        남은용량 -= 영상;
      else  {
        ++count;
        남은용량 = middle - 영상;
      }
    return M - count;
  }

  static int 파라매트릭서치_최소값(int left, int right) {
    while (left <= right) {
      int middle = (left + right) / 2;
      int r = compare(middle);
      if (r >= 0)
        right = middle - 1;
      else
        left = middle + 1;
    }
    return left;
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
    System.out.println(파라매트릭서치_최소값(max, 1_000_000_000));
  }
}