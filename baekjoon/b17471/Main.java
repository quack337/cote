package baekjoon.b17471;
import java.io.*;
import java.util.*;

public class Main {
  static int N, SUM, answer;
  static int[] A;
  static List<Integer>[] neighbors;
  static ArrayDeque<Integer> selected, notSelected;

  static boolean 연결그래프(ArrayDeque<Integer> nodes) {
    var stack = new ArrayDeque<Integer>();
    var visited = new boolean[N+1];
    stack.push(nodes.getFirst());
    while (stack.size() > 0) {
      int node = stack.pop();
      if (visited[node]) continue;
      visited[node] = true;
      for (int neighbor : neighbors[node])
        stack.push(neighbor);
    }
    for (int node : nodes)
      if (visited[node] == false) 
        return false;
    return true;
  }

  static int sum() {
    int r = 0;
    for (int node : selected)
      r += A[node];
    return r;
  }

  static void DFS(int index) {
    if (index > N) {
      if (selected.size() == 0 || !연결그래프(selected)) return;
      if (notSelected.size() > 0 && !연결그래프(notSelected)) return;
      answer = Math.min(answer,  Math.abs(SUM - sum() * 2));
      return;
    }
    selected.push(index);
    DFS(index + 1);
    selected.pop(); 
    notSelected.push(index);
    DFS(index + 1);
    notSelected.pop();
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    A = new int[N+1];
    SUM = 0;
    for (int i = 1; i <= N; ++i) {
      A[i] = scanner.nextInt();
      SUM += A[i];
    }
    neighbors = new ArrayList[N+1];
    for (int a = 1; a <= N; ++a) {
      neighbors[a] = new ArrayList<>();
      int count = scanner.nextInt();
      for (int j = 0; j < count; ++j) {
        int b = scanner.nextInt();
        neighbors[a].add(b);
      }
    }
    selected = new ArrayDeque<>();
    notSelected = new ArrayDeque<>();
    scanner.close();
    answer = Integer.MAX_VALUE;
    DFS(1);
    System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
  }
}