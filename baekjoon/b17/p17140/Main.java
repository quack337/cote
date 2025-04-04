package baekjoon.b17.p17140;

import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  @SuppressWarnings("unchecked")
  static int[] 정렬(int[] arr) {
    Map<Integer, Integer> counts = new HashMap<>();
    for (int key : arr)
      if (key != 0)
        counts.put(key, 1 + counts.getOrDefault(key, 0));
    Map.Entry<Integer, Integer>[] entries = counts.entrySet().toArray(new Map.Entry[counts.size()]);
    Arrays.sort(entries,  (a, b) -> {
      int r = a.getValue() - b.getValue();
      if (r != 0) return r;
      return a.getKey() - b.getKey();
    });
    int[] result = new int[entries.length * 2];
    for (int i = 0; i < entries.length; ++i) {
      result[i * 2] = entries[i].getKey();
      result[i * 2 + 1] = entries[i].getValue();
    }
    return result;
  }

  static void 크기조정(int[][] arr) {
    int size = 0;
    for (int i = 0; i < arr.length; ++i)
      size = Math.min(100, Math.max(size, arr[i].length));
    for (int i = 0; i < arr.length; ++i)
      arr[i] = Arrays.copyOf(arr[i], size);
  }

  static int[][] R연산(int[][] arr) {
    int[][] result = new int[arr.length][];
    for (int i = 0; i < result.length; ++i)
      result[i] = 정렬(arr[i]);
    크기조정(result);
    return result;
  }

  static int[][] 회전(int[][] arr) {
    int[][] results = new int[arr[0].length][arr.length];
    for (int r = 0; r < arr.length; ++r)
      for (int c = 0; c < arr[0].length; ++c)
      results[c][r] = arr[r][c];
    return results;
  }

  static int[][] C연산(int[][] arr) {
    arr = 회전(arr);
    arr = R연산(arr);
    return 회전(arr);
  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(new BufferedInputStream(System.in))) {
      int 목표_행 = scanner.nextInt() - 1;
      int 목표_열 = scanner.nextInt() - 1;
      int 목표_수 = scanner.nextInt();
      int[][] arr = new int[3][3];
      for (int r = 0; r < 3; ++r)
        for (int c = 0; c < 3; ++c)
          arr[r][c] = scanner.nextInt();

      for (int time = 0; time <= 100; ++time) {
        if (arr.length > 목표_행 && arr[0].length > 목표_열 && arr[목표_행][목표_열] == 목표_수) {
          System.out.println(time);
          return;
        }
        if (arr.length >= arr[0].length)
          arr = R연산(arr);
        else
          arr = C연산(arr);
      }
      System.out.println(-1);
    }
  }
}