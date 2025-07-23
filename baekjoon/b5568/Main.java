package baekjoon.b5568;
import java.util.*;
import java.io.*;

public class Main {
  static int N, R;
  static String[] A;  // 입력으로 주어진 수 목록
  static boolean[] V; // 인덱스 i 위치의 수를 선택했는지 표시하기 위한 배열. 중복 선택을 막기 위함.
  static ArrayList<String> S = new ArrayList<>(); // 지금까지 선택한 수 목록
  static Set<Integer> answer = new HashSet<>(); // 수를 선택해서 만든 정수를 담을 HashSet 객체.
                                                // 중복된 값이 자동으로 걸러진다
  static void DFS(int depth) {
    if (S.size() == R) {  // R개를 선택했다면
      // 선택한 수들을 연결하여 문자열을 만들고, 정수로 변환한다
      var sb = new StringBuilder();
      for (String s : S) sb.append(s);
      answer.add(Integer.parseInt(sb.toString()));
      return;
    }
    for (int i = 0; i < N; i++) {
      if (!V[i]) {
        V[i] = true;
        S.add(A[i]);
        DFS(depth + 1);
        V[i] = false;
        S.remove(S.size() - 1);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    var br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    R = Integer.parseInt(br.readLine());
    A = new String[N];
    V = new boolean[N];
    for (int i = 0; i < N; i++)
      A[i] = br.readLine(); // 선택한 수들을 문자열 연결할 거라고 정수로 변환하지 않는다
    DFS(0);
    System.out.println(answer.size()); // Set 객체 담긴 정수의 갯수를 출력한다
  }
}