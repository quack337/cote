package baekjoon.b9466;

import java.io.*;
import java.util.*;

public class Main3 {
  static final int UNKNOWN = 0, TEAM = 1, NO_TEAM = 2;
  static int N, teamMemberCount;
  static int[] A;
  static Set<Integer> team, noteam;

  static void team(int start) {
    if (team.contains(start) || noteam.contains(start)) return;
    ++teamMemberCount;
    team.add(start);
    int node = A[start];
    while (node != start) {
      team.add(node);
      ++teamMemberCount;
      node = A[node];
    }
  }

  static void noTeam(Set<Integer> visited) {
    noteam.addAll(visited);
  }

  static void DFS(int start) {
    var visited = new HashSet<Integer>();
    visited.add(start);
    int node = A[start];
    while (true) {
      if (visited.contains(node)) {
        team(node);
        noTeam(visited);
        return;
      }
      if (team.contains(node) || noteam.contains(node)) {
        noTeam(visited);
        return;
      }
      visited.add(node);
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
      team = new HashSet<>();
      noteam = new HashSet<>();
      teamMemberCount = 0;
      for (int i = 1; i <= N; ++i)
        if (!team.contains(i) && !noteam.contains(i))
          DFS(i);
      System.out.println(N - teamMemberCount);
    }
    scanner.close();
  }
}