package baekjoon.b2981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Main {
  static int 최대공약수(int a, int b) {
    while (b != 0) {
      int t = a % b;
      a = b;
      b = t;
    }
    return a;
  }

  static int 최대공약수(int[] a) {
    int result = a[0];
    for (int i = 1; i < a.length; ++i)
      result = 최대공약수(result, a[i]);
    return result;
  }

  static TreeSet<Integer> 약수찾기(int value) {
    var set = new TreeSet<Integer>();
    int end = (int) Math.sqrt(value);
    for (int i = 2; i <= end; ++i)
      if (value % i == 0) {
        set.add(i);
        set.add(value / i);
      }
    return set;
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());
    int[] A = new int[N];
    for (int i = 0; i < N; ++i)
      A[i] = Integer.parseInt(reader.readLine());
    Arrays.sort(A);
    int[] B = new int[N - 1];
    for (int i = 0; i < N - 1; ++i)
      B[i] = A[i + 1] - A[i];
    int gcd = 최대공약수(B);
    var list = 약수찾기(gcd);
    StringBuilder builder = new StringBuilder();
    for (int i : list)
      builder.append(i).append(' ');
    builder.append(gcd);
    System.out.println(builder.toString());
  }
}