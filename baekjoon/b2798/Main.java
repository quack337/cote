package baekjoon.b2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int[] 카드;
  static int N, M, 카드합계_최대값 = 0;

  static void solution(int index, int 선택한_카드수, int 카드합계) {
    if (선택한_카드수 == 3) {
      if (카드합계 <= M && 카드합계 > 카드합계_최대값)
        카드합계_최대값 = 카드합계;
      return;
    }
    if (선택한_카드수 + 카드.length - index < 3) return;
    solution(index + 1, 선택한_카드수, 카드합계);
    solution(index + 1, 선택한_카드수 + 1, 카드합계 + 카드[index]);
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    M = Integer.parseInt(tokenizer.nextToken());
    카드 = new int[N];
    tokenizer = new StringTokenizer(reader.readLine());
    for (int i = 0; i < N; ++i)
      카드[i] = Integer.parseInt(tokenizer.nextToken());
    solution(0, 0, 0);
    System.out.println(카드합계_최대값);
  }
}