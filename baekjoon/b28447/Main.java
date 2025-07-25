package baekjoon.b28447;
import java.io.*;

public class Main {
  static int N, R; // N개의 재료 중에서 R개를 선택해야 한다
  static int[][] A;
  static int[] S;
  static int 답 = Integer.MIN_VALUE;

    static void DFS(int from, int to, int count) { // count: 지금까지 선택한 재료 갯수
    if (count == R) { // R개를 선택했다면
      int 맛 = 0;
      for (int i = 0; i < R - 1; ++i) // nC2 조합 각각에 대해서 맛을 계산한다
        for (int j = i + 1; j < R; ++j)
          맛 += A[S[i]][S[j]];
      if (맛 > 답) 답 = 맛; // 맛의 최대값을 찾는다
      return;
    }
    for (int i = from; i <= to; ++i) {
      S[count] = i; // i 번째 재료를 선택하고
      DFS(i + 1, to + 1, count + 1); // 재귀호출
            // 선택한 갯수가 count 변수로 유지되기 때문에 S.pop() 할 필요 없다.
            //   재귀호출될 때 count 값이 count+1 되지만
            //   재귀호출에서 리턴하면 count 값은 재귀호출 전의 count 값 그대로이다
    }
  }

  public static void main(String[] args) throws Exception {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int)tk.nval; // N개의 재료 중에서 R개를 선택해야 한다
    tk.nextToken(); R = (int)tk.nval;
    A = new int[N][N];
    for (int i = 0; i < N; ++i)
      for (int j = 0; j < N; ++j) {
        tk.nextToken(); A[i][j] = (int)tk.nval; // 입력으로 주어진 2차원 배열
      }
    S = new int[R];
    DFS(0, N - R, 0);
    System.out.println(답);
  }
}
