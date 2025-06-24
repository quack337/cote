package baekjoon.b17471;
import java.io.*;
import java.util.*;

public class Main {
  static int N, 인구합계, answer;
  static int[] 인구;
  static List<Integer>[] neighbors;
  static Set<Integer> 구역1, 구역2;

  static boolean 연결그래프(Set<Integer> nodes) {
    var stack = new ArrayDeque<Integer>();
    var visited = new boolean[N+1];
    stack.push(nodes.iterator().next());
    int count = 0;
    while (stack.size() > 0) {
      int node = stack.pop();
      if (visited[node]) continue;
      visited[node] = true;
      ++count;
      for (int neighbor : neighbors[node])
        if (nodes.contains(neighbor))
          stack.push(neighbor);
    }
    return count == nodes.size();
  }

  static void subset(int index) {
    if (index > N) {
      if (구역1.size() > 0 && 구역2.size() > 0 && 연결그래프(구역1) && 연결그래프(구역2)) {
        int 구역1인구 = 구역1.stream().reduce(0, (sum, i) -> sum + 인구[i]);
        answer = Math.min(answer,  Math.abs(인구합계 - 구역1인구 * 2));
      }
      return;
    }
    구역1.add(index); subset(index + 1); 구역1.remove(index);
    구역2.add(index); subset(index + 1); 구역2.remove(index);
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    인구 = new int[N+1];
    for (int i = 1; i <= N; ++i)
      인구[i] = scanner.nextInt();
    인구합계 = Arrays.stream(인구).sum();
    neighbors = new ArrayList[N+1];
    for (int a = 1; a <= N; ++a) {
      neighbors[a] = new ArrayList<>();
      int count = scanner.nextInt();
      for (int j = 0; j < count; ++j)
        neighbors[a].add(scanner.nextInt());
    }
    구역1 = new HashSet<>();
    구역2 = new HashSet<>();
    scanner.close();
    answer = 999_999;
    subset(1);
    System.out.println(answer == 999_999 ? -1 : answer);
  }
}