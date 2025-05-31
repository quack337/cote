package baekjoon.b4386;
import java.io.*;
import java.util.*;

public class Main {
  static int N, E;
  static ArrayList<float[]>[] links;

  static float prim(int start) {
    float costSum = 0;
    var visited = new boolean[N+1];
    var queue = new PriorityQueue<float[]>((a, b) -> Float.compare(a[1], b[1]));
    queue.add(new float[] {start, 0});
    while (queue.size() > 0) {
      float[] u = queue.remove();
      int node = (int)u[0]; float cost = u[1];
      if (visited[node]) continue;
      visited[node] = true;
      costSum += cost;
      for (float[] link : links[node])
        queue.add(link);
    }
    return costSum;
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    N = scanner.nextInt();
    var stars = new float[N][2];
    for (int i = 0; i < N; ++i) {
      stars[i][0] = scanner.nextFloat();
      stars[i][1] = scanner.nextFloat();
    }
    links = new ArrayList[N+1];
    for (int a = 0; a < N; ++a)
      links[a] = new ArrayList<>();
    float min = Float.MAX_VALUE; int minNode = 0;
    for (int a = 0; a < N-1; ++a)
      for (int b = a+1; b < N; ++b) {
        float dx = stars[a][0] - stars[b][0];
        float dy = stars[a][1] - stars[b][1];
        float cost = (float)Math.sqrt(dx*dx + dy*dy);
        links[a].add(new float[] {b, cost});
        links[b].add(new float[] {a, cost});
        if (cost < min) { min = cost; minNode = a; }
      }
    System.out.println(prim(minNode));
    scanner.close();
  }
}