package baekjoon.b16938;
import java.util.*;
import java.io.*;

public class Main {
  static int N, L, R, X, 답 = 0;
  static int[] A;
  static List<Integer> selected = new ArrayList<>();

  static void DFS(int index) {
    if (index == N) {
      if (selected.size() >= 2) {
        int sum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int val : selected) {
          sum += val;
          min = Math.min(min, val);
          max = Math.max(max, val);
        }
        if (sum >= L && sum <= R && max - min >= X) {
          답++;
        }
      }
      return;
    }
    selected.add(A[index]);
    DFS(index + 1);
    selected.remove(selected.size() - 1);
    DFS(index + 1);
  }

  public static void main(String[] args) throws Exception {
    var br = new BufferedReader(new InputStreamReader(System.in));
    var st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());
    A = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; ++i) {
      A[i] = Integer.parseInt(st.nextToken());
    }
    DFS(0);
    System.out.println(답);
  }
}
