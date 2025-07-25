package baekjoon.b1443;
import java.io.*;

public class Main {
  static int D, N; // 문제의 입력으로 주어진 수. D: 계산기 자릿수, N: 곱셈 연산의 수
  static int MAX;
  static int 답 = -1; // 최대값을 구해야 하므로 -1로 초기화한다.

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); D = (int)tk.nval; // 계산기 자릿수
    tk.nextToken(); N = (int)tk.nval; // 곱셈 연산의 수
    MAX = (int) Math.pow(10, D);// 초과 컷을 구현하기 위한 값
      // 예를 들어 D=2 이라면, 답은 99 이하이어야 한다. 즉 100 이상이면 초과컷 해야 한다

    DFS(2, 1, 0); // 2: 2부터 9까지 선택 가능하다
            // 1: 지금까지 선택한 수들을 곱한 결과의 초기값
            // 0: 지금까지 선택한 수들의 갯수
    System.out.println(답);
  }

  static void DFS(int from, int x, int count) {// x: 지금까지 선택한 수들을 곱합 결과
                               // count: 지금까지 선택한 갯수
    if (x >= MAX) return; // 초과 컷
    if (count == N) {   // N개를 선택했다면
      if (x > 답) 답 = x;  // 최대값을 찾는다
      return;
    }
    for (int i = from; i <= 9; ++i)
      DFS(i, x*i, count+1);
  }
}
