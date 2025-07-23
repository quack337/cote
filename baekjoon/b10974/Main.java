package baekjoon.b10974;
import java.io.*;
import java.util.*;

public class Main {
  static int N, R;
  static boolean[] V; // i 값을 선택했는지 표시하기 위한 배열. 중복 선택을 막기 위함.
  static List<Integer> S = new ArrayList<>(); // 지금까지 선택한 수 목록
  static StringBuilder bd = new StringBuilder(); // 출력할 문자열

  static void DFS() throws IOException {
    if (S.size() == R) { // R개를 선택했다면
      // 선택한 수 목록을 StringBuilder에 추가한다
      for (int i : S)
        bd.append(i).append(' ');
      bd.append('\n');
      return;
    }
    for (int i = 1; i <= N; ++i)
      if (!V[i]) { // i를 아직 선택하지 않았다면
        V[i] = true; // i를 선택했다고 표시
        S.add(i); // 선택한 수 목록에 i 추가
        DFS(); // 재귀호출
        V[i] = false; // 재귀호출에서 리턴하자 마자 i 선택을 취소한다
        S.remove(S.size() - 1);
      }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    var rd = new BufferedReader(new InputStreamReader(System.in));
    N = R = Integer.parseInt(rd.readLine());
    V = new boolean[N+1];
    DFS();
    System.out.println(bd.toString());
  }
}
