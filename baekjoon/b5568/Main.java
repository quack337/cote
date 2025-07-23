package baekjoon.b5568;
import java.util.*;
import java.io.*;

public class Main {
  static int N, R;
  static int[] A;
  static boolean[] V;
  static Set<Integer> answer = new HashSet<>();

  static void DFS(int n, int x) { // n: 지금까지 선택한 갯수, x: 선택한 수들로 계산한 값
    if (n == R) {
      answer.add(x);
      return;
    }
    for (int i = 0; i < N; i++) {
      if (!V[i]) {
        V[i] = true;
        DFS(n+1, x * (A[i]>9 ? 100 : 10) + A[i]);
        V[i] = false; // 재귀호출에서 리턴하자 마자 A[i] 선택을 취소한다
      }
    }
  }

  public static void main(String[] args) throws IOException {
    var br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    R = Integer.parseInt(br.readLine());
    A = new int[N];
    V = new boolean[N];
    for (int i = 0; i < N; i++)
      A[i] = Integer.parseInt(br.readLine());
    DFS(0, 0);
    System.out.println(answer.size());
  }
}
