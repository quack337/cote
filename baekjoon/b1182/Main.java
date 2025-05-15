package baekjoon.b1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, S, answer = 0;
  static int[] A;

  static void DFS(int index, int count, int sum) {
    if (index == A.length) {
      if (count > 0 && sum == S) ++answer;
      return;
    }
    DFS(index + 1, count, sum);
    DFS(index + 1, count + 1, sum + A[index]);
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    N = Integer.parseInt(tokenizer.nextToken());
    S = Integer.parseInt(tokenizer.nextToken());
    A = new int[N];
    tokenizer = new StringTokenizer(reader.readLine());
    for (int i = 0; i < N; ++i)
      A[i] = Integer.parseInt(tokenizer.nextToken());
    DFS(0, 0, 0);
    System.out.println(answer);
  }
}
