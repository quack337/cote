package baekjoon.b17471;
import java.io.*;
import java.util.*;

// 단계1: 부분집합
public class Main1 {
  static int N;
  static int[] A;
  static List<Integer>[] neighbors;
  static boolean[] selected;

  static void DFS(int index) {
    if (index > N) {
      for (int i = 1; i <= N; ++i)
        System.out.print(selected[i] ? i + " " : "");
      System.out.println();
      return;
    }
    selected[index] = true;
    DFS(index + 1);
    selected[index] = false;
    DFS(index + 1);
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    A = new int[N+1];
    for (int i = 1; i <= N; ++i)
      A[i] = scanner.nextInt();
    neighbors = new ArrayList[N+1];
    for (int a = 1; a <= N; ++a) {
      neighbors[a] = new ArrayList<>();
      int count = scanner.nextInt();
      for (int j = 0; j < count; ++j) {
        int b = scanner.nextInt();
        neighbors[a].add(b);
      }
    }
    selected = new boolean[N+1];
    scanner.close();
    DFS(1);
  }
}