package baekjoon.b2533;
import java.io.*;
import java.util.*;

public class Main {
  static ArrayList<Integer>[] links;
  static int[][] DP;

  static int DFS(int node, int parent, int parentSelected) {
    if (DP[parentSelected][node] != -1) return DP[parentSelected][node];
    int a = 0;
    int b = 1;
    for (int child : links[node]) {
      if (child == parent) continue;
      if (parentSelected == 1) a += DFS(child, node, 0);
      b += DFS(child, node, 1);
    }
    return DP[parentSelected][node] = parentSelected == 1 ? Math.min(a, b) : b;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    links = new ArrayList[N];
    for (int i = 0; i < N; i++) links[i] = new ArrayList<>();
    DP = new int[2][N];
    for (int i = 0; i < N - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) - 1;
      int b = Integer.parseInt(st.nextToken()) - 1;
      links[a].add(b);
      links[b].add(a);
    }
    for (int[] arr : DP) Arrays.fill(arr, -1);
    System.out.println(DFS(0, -1, 1));
  }
}
