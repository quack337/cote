package baekjoon.b2638;
import java.io.*;
import java.util.*;

public class Main2 {
  static int ROW, COL;
  static int[][] A, distances;
  static boolean[][] visited;

  static int 이미방문한주변칸(int r, int c, int distance) {
    int count = 0;
    if (r > 0 && visited[r-1][c] && distances[r-1][c] < distance) ++count;
    if (c > 0 && visited[r][c-1] && distances[r][c-1] < distance) ++count;
    if (r < ROW-1 && visited[r+1][c] && distances[r+1][c] < distance) ++count;
    if (c < COL-1 && visited[r][c+1] && distances[r][c+1] < distance) ++count;
    return count;
  }

  static int dijkstra() {
    int maxDistance = 0;
    distances = new int[ROW][COL];
    visited = new boolean[ROW][COL];
    var queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
    queue.add(new int[] {0, 0, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (visited[r][c]) continue;
      if (A[r][c] == 1 && 이미방문한주변칸(r, c, distance) < 2) continue;
      visited[r][c] = true;
      distances[r][c] = distance;
      maxDistance = distance;
      if (r > 0) queue.add(new int[] {r-1, c, distance + A[r-1][c]});
      if (c > 0) queue.add(new int[] {r, c-1, distance + A[r][c-1]});
      if (r < ROW-1) queue.add(new int[] {r+1, c, distance + A[r+1][c]});
      if (c < COL-1) queue.add(new int[] {r, c+1, distance + A[r][c+1]});
    }
    return maxDistance;
  }

  public static void main(String[] args) {
    var scanner = new Scanner(new BufferedInputStream(System.in));
    ROW = scanner.nextInt();
    COL = scanner.nextInt();
    A = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        A[r][c] = scanner.nextInt();
    scanner.close();
    System.out.println(dijkstra());
  }
}