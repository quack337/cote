package baekjoon.b2251;
import java.io.*;
import java.util.*;

public class Main {
  static final int MAX = 200;
  static boolean[][][] visited = new boolean[MAX+1][MAX+1][MAX+1];
  static boolean[] answer = new boolean[MAX+1];
  static int[] 물통;

  static void DFS(int[] 물) {
    int a = 물[0], b = 물[1], c = 물[2];
    if (visited[a][b][c]) return;
    visited[a][b][c] = true;
    if (a == 0) answer[c] = true;
    for (int from = 0; from < 3; ++from)
      for (int to = 0; to < 3; ++to) {
        if (from == to) continue;
        if (물[from] == 0) continue;
        if (물[to] == 물통[to]) continue;
        int water = Math.min(물[from], 물통[to] - 물[to]); // 옮길 물의 양
        물[from] -= water; 물[to] += water; // 물 옮기기
        DFS(물);
        물[from] += water; 물[to] -= water; // 물 옮기기 취소
      }
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int A = Integer.parseInt(tokenizer.nextToken());
    int B = Integer.parseInt(tokenizer.nextToken());
    int C = Integer.parseInt(tokenizer.nextToken());
    물통 = new int[] { A, B, C };
    DFS(new int[] { 0, 0, C });
    StringBuilder builder = new StringBuilder();
    for (int c = 0; c <= MAX; ++c)
      if (answer[c])
        builder.append(c).append(' ');
    System.out.println(builder.toString());
  }
}