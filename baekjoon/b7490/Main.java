package baekjoon.b7490;
import java.io.*;
import java.util.*;

public class Main {
  static final char[] OP = {' ', '+', '-'}; // 숫자 사이에 삽입할 문자 목록
  static int N; // 삽입해야할 문자 갯수
  static char[] S = new char[9]; // 지금까지 선택한 문자 목록
  static StringBuilder 답 = new StringBuilder(); // 출력할 답

  public static void main(String[] args) throws IOException {
    var tk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    tk.nextToken(); int T = (int)tk.nval; // 테스트 케이스 수
    for (int t = 0; t < T; ++t) {
      tk.nextToken(); N = (int)tk.nval - 1; // 삽입해야할 문자 갯수는 수의 갯수-1 이다
      DFS(0);
      답.append('\n'); // 테스트 케이스 출력 사이에 빈줄을 출력하다
    }
    System.out.println(답);
  }

  static void DFS(int count) { // count: 지금까지 선택한 문자 갯수
    if (count == N) { // N개의 문자를 선택했다면,
      // 선택된 N개의 문자를, N+1개의 숫자 사이에 끼워넣은 표현식 문자열을 만든다
      String expr = createExpr();
      // 표현식 문자열에서 공백 문자들을 전부 제거한 표현식을 실행한다
      if (eval(expr.replace(" ", "")) == 0)
        답.append(expr).append('\n'); // 실행 결과가 0이면 그 표현식 문자열을 출력한다
      return;
    }
    for (char op : OP) {
      S[count] = op; // op 문자를 선택하고
      DFS(count + 1);// 재귀호출
      // 선택한 갯수가 count 변수로 유지되기 때문에 S.pop() 할 필요 없다.
      //   재귀호출될 때 count 값이 count+1 되지만
      //   재귀호출에서 리턴하면 count 값은 재귀호출 전의 count 값 그대로이다
    }
  }

  // 선택된 N개의 문자를, N+1개의 숫자 사이에 끼워넣은 표현식 문자열을 만든다
  static String createExpr() {
    StringBuilder sb = new StringBuilder();
    sb.append(1);
    for (int i = 0; i < N; ++i) {
      sb.append(S[i]);
      sb.append(i + 2);
    }
    return sb.toString();
  }

  // 표현식 문자열을 실행한 값을 계산한다
  static int eval(String expr) {
    int sum = 0, num = 0, sign = 1; // sum: 계산결과값, num: 지금 읽고 있는 수
      // sign: 지금 읽고 있는 수 바로 앞의 연산자가 + 이면 sign==1 이고, - 이면 sign==-1 이다
    for (char ch : expr.toCharArray()) { // 표현식의 문자를 순서대로 읽는다
      if (ch == '+' || ch == '-') { // + - 연산자를 읽었다면, 연산자 앞의 num 숫자를 다 읽은 거
        sum += sign * num; // num 숫자 앞의 연산자가 - 였다면 -num을, + 이였다면 +num을 sum에 더한다
        num = 0;// 숫자를 새로 읽기 시작해야 한다
        sign = (ch=='-') ? -1 : 1;
      } else // + - 연산자가 아니고 숫자를 읽었다면, 그 숫자를 num에 추가한다
        num = num * 10 + (ch - '0');
            // 예를 들어 처음에 '2'를 읽었다면, num = 0 * 10 + ('2' - '0') = 2 이고,
            // 그 다음 '3'을 읽었다면, num = 2 * 10 + ('3' - '0') = 23 이다
    }
    sum += sign * num; // 마지막에 끝의 숫자를 sum에 더한다
    return sum;
  }
}
