package baekjoon.b9466;
// 시간초과
import java.io.*;
import java.util.*;

public class Main2 {
  static final int UNKNOWN = 0, TEAM = 1, NO_TEAM = 2;
  static int N, teamMemberCount;
  static int[] A;
  static int[] state;

  static void team(int start) {
    if (state[start] != UNKNOWN) return;
    ++teamMemberCount;
    state[start] = TEAM;
    int node = A[start];
    while (node != start) {
      state[node] = TEAM;
      ++teamMemberCount;
      node = A[node];
    }
  }

  static void noTeam(boolean[] visited) {
    for (int i = 1; i <= N; ++i)
      if (visited[i] && state[i] == UNKNOWN)
        state[i] = NO_TEAM;
  }

  static void DFS(int start) {
    var visited = new boolean[N+1];
    visited[start] = true;
    int node = A[start];
    while (true) {
      if (visited[node]) {
        team(node);
        noTeam(visited);
        return;
      }
      if (state[node] != UNKNOWN) {
        noTeam(visited);
        return;
      }
      visited[node] = true;
      node = A[node];
    }
  }

  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    int T = scanner.nextInt();
    for (int t = 0; t < T; ++t) {
      N = scanner.nextInt();;
      A = new int[N+1];
      for (int i = 1; i <= N; ++i)
        A[i] = scanner.nextInt();
      state = new int[N+1];
      teamMemberCount = 0;
      for (int i = 1; i <= N; ++i)
        if (state[i] == UNKNOWN) {
          DFS(i);
        }
      System.out.println(N - teamMemberCount);
    }
    scanner.close();
  }
}