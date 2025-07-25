package baekjoon.b19949;
import java.io.*;

public class Main {
  static int[] A = new int[10];; // 입력으로 주어진 수
  static int[] S = new int[10]; // 지금까지 선택한 객관식 답 목록
  static int 답 = 0;

  static void DFS(int count, int 점수) { // count: 지금까지 선택한 객관식 답 갯수
              // 점수: 지금까지 선택한 객관식 답들의 점수 합계
    if (count == 10) {     // 10 문제를 다 선택했으면
      if (점수 >= 5) ++답;  // 5점을 초과하는 답안들의 수를 센다
      return;
    }
    for (int i = 1; i <= 5; ++i) { // 5지 선다식 각각을 선택 시도
      // 앞의 두 문제와 또 같은 답을 선택할 수는 없다
      if (count >= 2 && S[count - 1] == i && S[count - 2] == i) continue;
      S[count] = i; // count 번 문제의 답을 S 목록에 추가
      DFS(count + 1, 점수 + (A[count] == i ? 1 : 0)); // 재귀호출
                     // i가 count 번 문제의 정답과 일치하면 점수 +1

      // 선택한 갯수가 count 변수로 유지되기 때문에 S.pop() 할 필요 없다.
      //   재귀호출될 때 count 값이 count+1 되지만
      //   재귀호출에서 리턴하면 count 값은 재귀호출 전의 count 값 그대로이다
    }
  }

    public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    for (int i = 0; i < 10; ++i) {
      tk.nextToken(); A[i] = (int)tk.nval; // 입력으로 주어진 수
    }
    DFS(0, 0);
    System.out.println(답);
  }
}
