/* 오류: long overflow

시간의 최대값은 10억*10억 이다.
창구 타임의 최소값은 1,
시간 / 창구 타임 최대값은 10억*10억
최대창구 갯수는 10만.
answer 최대갑은 10억*10억*10만
long 범위를 초과한다.
 */
package baekjoon.b3079;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main1 {
  static int N, M;
  static int[] A;

  static long compare(long 시간) {
    long count = 0;
    for (int i : A) {
      long temp = 시간 / i;
      if (temp >= M) return 1;
      count += 시간 / i;
      if (count >= M) return 1;
    }
    return count - M;
  }

  static long 파라매트릭서치_최소값(long left, long right) {
    while (left <= right) {
      long middle = (left + right) / 2;
      long r = compare(middle);
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
    for (int i = 0; i < N; ++i)
      A[i] = scanner.nextInt();
    scanner.close();
    System.out.println(파라매트릭서치_최소값(1, 1_000_000_000_000_000_000L));
  }
}
