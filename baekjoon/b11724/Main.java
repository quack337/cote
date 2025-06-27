package baekjoon.b11724;
import java.io.*;
import java.util.*;

public class Main {
  static ArrayList<Integer>[] neighbors;
  static boolean[] visited;

  static void DFS(int node) {
    if (visited[node]) return;
    visited[node] = true;
    for (int neighbor : neighbors[node])
      DFS(neighbor);
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    int N = Integer.parseInt(tokenizer.nextToken());
    int M = Integer.parseInt(tokenizer.nextToken());
    neighbors = new ArrayList[N+1];
    for (int i = 1; i <= N; ++i)
      neighbors[i] = new ArrayList<Integer>();
    for (int i = 0; i < M; ++i) {
      tokenizer = new StringTokenizer(reader.readLine());
      int a = Integer.parseInt(tokenizer.nextToken());
      int b = Integer.parseInt(tokenizer.nextToken());
      neighbors[a].add(b);
      neighbors[b].add(a);
    }
    visited = new boolean[N+1];
    int answer = 0;
    for (int i = 1; i <= N; ++i)
      if (visited[i] == false) {
        ++answer;
        DFS(i);
      }
    System.out.println(answer);
  }
}
