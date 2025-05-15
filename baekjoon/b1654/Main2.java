package baekjoon.b1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
  static int[] A;
  static int K, N;


  static int compare(long length) {
    int count = 0;
    for (int lan : A)
      count += lan / length;
    return N - count;
  }

  static long 파라매트릭서치_최대값(long left, long right) {
    while (left < right) {
      long middle = (left + right) / 2;
      int r = compare(middle);
      if (r > 0)
        right = middle;
      else
        left = middle + 1;
    }
    return right - 1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    K = Integer.parseInt(tokenizer.nextToken());
    N = Integer.parseInt(tokenizer.nextToken());
    A = new int[K];
    for (int i = 0; i < K; ++i)
      A[i] = Integer.parseInt(reader.readLine());
    long 최대길이 = Integer.MAX_VALUE;
    long answer = 파라매트릭서치_최대값(1, 최대길이);
    System.out.println(answer);
  }
}