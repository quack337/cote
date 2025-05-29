package baekjoon.b1774;
import java.io.*;
import java.util.*;

public class Main {
  static int N, M;
  static ArrayList<double[]>[] links;

  static double prim(int start) {
    double costSum = 0;
    var visited = new boolean[N+1];
    var queue = new PriorityQueue<double[]>((a, b) -> Double.compare(a[1], b[1]));
    queue.add(new double[] {start, 0});
    while (queue.size() > 0) {
      double[] u = queue.remove();
      int node = (int)u[0]; double cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      costSum += cost;
      for (double[] link : links[node])
        queue.add(link);
    }
    return costSum;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    M = scanner.nextInt();
    var gods = new int[N][2];
    for (int i = 0; i < N; ++i) {
      gods[i][0] = scanner.nextInt();
      gods[i][1] = scanner.nextInt();
    }
    var connected = new HashSet<Integer>();
    for (int i = 0; i < M; ++i) {
      int a = scanner.nextInt() - 1;
      int b = scanner.nextInt() - 1;
      connected.add(a * 10000 + b);
      connected.add(b * 10000 + a);
    }
    links = new ArrayList[N+1];
    for (int a = 0; a < N; ++a)
      links[a] = new ArrayList<>();
    int minNode = 0;
    for (int a = 0; a < N-1; ++a)
      for (int b = a+1; b < N; ++b) {
        double dx = gods[a][0] - gods[b][0];
        double dy = gods[a][1] - gods[b][1];
        double cost = (double)Math.sqrt(dx*dx + dy*dy);
        if (connected.contains(a * 10000 + b)) {
          cost = 0; minNode = a;
        } 
        links[a].add(new double[] {b, cost});
        links[b].add(new double[] {a, cost});
      }
    scanner.close();
    double result = prim(minNode);
    if (result == 0) System.out.println("0");
    else System.out.printf("%.2f\n", result);
  }
}