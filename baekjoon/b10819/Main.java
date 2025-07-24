package baekjoon.b10819;
import java.io.*;
import java.util.*;

public class Main {
  static int N, R, 답 = 0;
  static int[] A; // 입력으로 주어진 수 목록
  static boolean[] V;  // 인덱스 i 위치의 수를 선택했는지 표시하기 위한 배열. 중복 선택을 막기 위함
  static List<Integer> S = new ArrayList<>();  // 지금까지 선택한 선택한 숫자 목록

  static void DFS() throws IOException {
      if (S.size() == R) { // N개를 선택했다면
      int sum = 0; // 문제가 요구한 계산식을 계산한다
      for (int i = 0; i < N-1; ++i)
        sum += Math.abs(S.get(i) - S.get(i+1));
      if (sum > 답) 답 = sum; // 최대값 찾기
      return;
    }
    for (int i = 0; i < N; ++i)
    if (!V[i]) { // 인덱스 i 위치의 수를 아직 선택하지 않았다면
        V[i] = true;  // 인덱스 i 위치의 수를 선택했다고 표시
        S.add(A[i]); // 인덱스 i 위치의 수를 선택 목록에 추가
        DFS(); // 재귀호출
        V[i] = false; // 재귀호출에러 리턴하자 마자 인덱스 i 위치의 수 선택을 취소한다
        S.remove(S.size() - 1);
      }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); N = (int)tk.nval; R = N;
    A = new int[N];
    for (int i = 0; i < N; ++i) {
      tk.nextToken(); A[i] = (int)tk.nval;
    }
    V = new boolean[N];
    DFS();
    System.out.println(답);
  }
}