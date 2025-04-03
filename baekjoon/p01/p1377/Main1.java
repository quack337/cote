package baekjoon.p01.p1377;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1 {

    static int run1(int[] A) {
      int[] B = Arrays.copyOf(A, A.length);
      Arrays.sort(B);
      int answer = 0;
      for (int i = 0; i < A.length; ++i) {
        int index = Arrays.binarySearch(B, A[i]);
        answer = Math.max(i - index, answer);
      }
      return answer + 1;
    }

    static int run2(int[] A) {
      int[] B = Arrays.copyOf(A, A.length);
      boolean changed = false;
      for (int i = 0; i <= B.length - 1; i++) {
        changed = false;
        for (int j = 0; j < B.length - 1 - i; j++) {
          if (B[j] > B[j+1]) {
            changed = true;
            int t = B[j];
            B[j] = B[j+1];
            B[j+1] = t;
          }
        }
        if (changed == false)
          return i + 1;
      }
      return -1;
    }

    public static void main(String[] args) throws Exception {
      int N = 5;
      int[] A = new int[N];
      for (int i = 0; i < N; ++i)
        A[i] = (int)(Math.random() * 100000000);
      int a1 = run1(A);
      int a2 = run2(A);
      if (a1 != a2) {
        System.out.println(Arrays.toString(A));
        System.out.printf("%d %d\n", a1, a2);
      }
    }

    public static void main2(String[] args) throws Exception {
    var reader = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(reader.readLine());
    int[] A = new int[N];
    for (int i = 0; i < N; ++i)
        A[i] = Integer.parseInt(reader.readLine());
    int[] B = Arrays.copyOf(A, N);
    Arrays.sort(B);
    int answer = 0;
    for (int i = 0; i < N; ++i) {
      int index = Arrays.binarySearch(B, A[i]);
      answer = Math.max(i - index, answer);
    }
    System.out.println(answer + 1);
    reader.close();
  }
}