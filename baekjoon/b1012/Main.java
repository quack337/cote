package baekjoon.b1012;
import java.io.*;
import java.util.*;

public class Main {
  static int ROW, COL, 배추 = 1;
  static boolean[][] visited;
  static int[][] A;

  static void DFS(int r, int c) {
    if (visited[r][c] || A[r][c] != 배추) return;
    visited[r][c] = true;
    if (r > 0) DFS(r-1, c);
    if (c > 0) DFS(r, c-1);
    if (r < ROW-1) DFS(r+1, c);
    if (c < COL-1)DFS(r, c+1);
  }

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(reader.readLine());
    for (int t = 0; t < T; ++t) {
      StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
      ROW = Integer.parseInt(tokenizer.nextToken());
      COL = Integer.parseInt(tokenizer.nextToken());
      int K = Integer.parseInt(tokenizer.nextToken());
      A = new int[ROW][COL];
      for (int k = 0; k < K; ++k) {
        tokenizer = new StringTokenizer(reader.readLine());
        int r = Integer.parseInt(tokenizer.nextToken());
        int c = Integer.parseInt(tokenizer.nextToken());
        A[r][c] = 1;
      }
      int answer = 0;
      visited = new boolean[ROW][COL];
      for (int r = 0; r < ROW; ++r)
        for (int c = 0; c < COL; ++c)
          if (!visited[r][c] && A[r][c] == 배추) { // 방문하지 않은 배추칸
            ++answer;
            DFS(r, c);
          }
      System.out.println(answer);
    }
  }
}