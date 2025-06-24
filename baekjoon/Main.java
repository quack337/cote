package baekjoon;
import java.io.*;
import java.util.*;

public class Main {
  static int N, E;
  static int[] A;
  static boolean[] visited;
  static List<Integer>[] neighbors;

  @SuppressWarnings("unchecked")
  public static void main1(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    E = scanner.nextInt();
    visited = new boolean[N+1];
    neighbors = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i)
      neighbors[i] = new ArrayList<>();
    for (int i = 0; i < E; ++i) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      neighbors[a].add(b);
      neighbors[b].add(a);
    }
    scanner.close();
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    A = new int[N];
    for (int i = 0; i < N; ++i)
      A[i] = scanner.nextInt();
    scanner.close();
  }
}