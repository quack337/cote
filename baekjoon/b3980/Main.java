package baekjoon.b3980;
import java.io.*;

public class Main {
  // 인덱스 i위치의 선수를 선택했는지 표시하기 위한 배열. 중복 선택을 막기 위함
  static boolean[] V = new boolean[11];

  static int[][] A = new int[11][11];
  static int 답;

  static void DFS(int n, int sum) { // n: 지금까지 선택한 선수들 수
                                   // sum: 지금까시 선택한 선수들 능력치 합계
    if (n == 11) { // 11 명을 선택했다면
      답 = Math.max(답, sum); // 능력치 합계 최대값을 찾는다
      return;
    }
    for (int i = 0; i < 11; i++) {
      if (!V[i] && A[i][n] > 0) { // 인덱스 i 선수를 아직 선택하지 않았고,
                                // 인덱스 i 선수의 n 포지션 능력치가 0 보다 크다면
        V[i] = true; // 인덱스 i 선수 선택
        DFS(n + 1, sum + A[i][n]); // 재귀 호출
        V[i] = false; // 재귀호출에서 리턴하자 마자 인덱스 i 선수 선택 취소
      }
    }
  }

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); int T = (int)tk.nval; // 테스트 케이스 수
    StringBuilder bd = new StringBuilder();
    for (int t = 0; t < T; t++) {
      for (int r = 0; r < 11; r++)
        for (int c = 0; c < 11; c++) {
          tk.nextToken(); A[r][c] = (int)tk.nval;  // 입력으로 주어진 2차원 배열
        }
      답 = 0;
      V = new boolean[11];
      DFS(0, 0);
      bd.append(답).append('\n');
    }
    System.out.print(bd);
  }
}
