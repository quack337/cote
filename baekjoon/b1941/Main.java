package baekjoon.b1941;
import java.io.*;
import java.util.*;

public class Main {
  static char[][] A = new char[5][]; // 입력으로 주어진 2차원 배열
  static int[][] S = new int[7][2];
  static int ROW=5, COL=5, N=25, R=7, answer = 0; // 5행 5열
                                            // N==25개의 좌표에서 R==7개를 선택해야 한다

  static void DFS(int from, int to, int count) { // count: 지금까지 선택한 좌표 갯수
    if (count == R) { // R개를 선택했다면
      if (isValid()) answer++; // 선택한 7개의 좌표가 문제의 조건을 만족하면 ++답
      return;
    }
    for (int i = from; i <= to; ++i) {
      // i 번째 좌표를 S 목록에 추가하기 위해, i값으로부터 행, 열 좌표를 계산한다
      int c = i % COL, r = i / COL;
      S[count][0] = r; // i 번째 좌표를 S 목록에 추가
      S[count][1] = c;
      DFS(i + 1, to + 1, count + 1); // 재귀호출
            // 선택한 갯수가 count 변수로 유지되기 때문에 S.pop() 할 필요 없다.
            //   재귀호출될 때 count 값이 count+1 되지만
            //   재귀호출에서 리턴하면 count 값은 재귀호출 전의 count 값 그대로이다
    }
  }

  static int[][] B = new int[ROW][COL]; // 7개의 좌표가 연결 그래프인지 확인하기 위한 2차원 배열
  static int size = 0; // 연결 그래프 크기를 구하기 위한 전역 변수

  static void DFS2(int r, int c) { // 연결 그래프 크기를 구하는 재귀호출 메소드
    if (B[r][c] != 1) return;
    B[r][c] = 0;
    size++;
    if (r > 0) DFS2(r-1, c);
    if (c > 0) DFS2(r, c-1);
    if (r < ROW - 1) DFS2(r+1, c);
    if (c < COL - 1) DFS2(r, c+1);
  }

  // 선택한 7개의 좌표가 문제의 조건을 만족하는지 확인한다
  static boolean isValid() {
    int count = 0; // 'S' 문자의 수를 센다
    for (int[] row : B) // B 2차원 배열을 0으로 채운다
      Arrays.fill(row, 0);
    for (int[] pos : S) { // 선택된 7개의 좌표 각각에 대해서
      int r = pos[0], c = pos[1];
      B[r][c] = 1; // 선택된 좌표에 1 표시한다
      if (A[r][c] == 'S') count++; // 선택된 좌표의 'S' 문자 수를 센다
    }
    if (count < 4) return false; // 'S' 문자가 4개 이상이어야 한다

    size = 0; // 연결그래프 크기 전역 변수를 0으로 초기화한다
    int r = S[0][0], c = S[0][1]; // 첫번째 좌표에서 시작하는
    DFS2(r, c); // 연결 그래프의 크기를 구한다
    return size == 7; // 연결 그래프의 크기가 7이어야 한다. 즉 7개 좌표가 모두 인접해있어야 한다
  }

  public static void main(String[] args) throws IOException {
    var rd = new BufferedReader(new InputStreamReader(System.in));
    for (int r = 0; r < ROW; ++r)
        A[r] = rd.readLine().toCharArray();
    DFS(0, N - R, 0);
    System.out.println(answer);
  }
}
