package baekjoon.b17472;
import java.io.*;
import java.util.*;

public class Main {
  static int INF = 1_000_000_000;
  static int ROW, COL, N; // R: 행의 수, C: 열의 수, N: 섬의 수
  static int[][] A;
  static int[][] distances; // 섬 사이 최단거리

  static void DFS1(int r, int c, int id) { // 섬의 id를 기록한다. id는 2, 3, 4,...
    if (A[r][c] != 1) return;
    A[r][c] = id;
    if (r > 0) DFS1(r-1, c, id);
    if (c > 0) DFS1(r, c-1, id);
    if (r < ROW-1) DFS1(r+1, c, id);
    if (c < COL-1) DFS1(r, c+1, id);
  }

  static void DFS2(int r, int c, int startId, int dir, int distance) { // 섬 사이 최단거리 찾기
    if (distance > 0 && A[r][c] != 0) {
      if (A[r][c] == startId) return;
      int endId = A[r][c];
      --distance;
      if (distance > 1 && distance < distances[startId-2][endId-2])
        distances[startId-2][endId-2] = distance;
      return;
    }
    switch (dir) {
    case 0: if (r > 0) DFS2(r-1, c, startId, dir, distance + 1); break;
    case 1: if (c < COL-1) DFS2(r, c+1, startId, dir, distance + 1); break;
    case 2: if (r < ROW-1) DFS2(r+1, c, startId, dir, distance + 1); break;
    case 3: if (c > 0) DFS2(r, c-1, startId, dir, distance + 1); break;
    }
  }

  static int prim() { // 최소 신장 트리 프림 알고리즘
    var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
    var visited = new boolean[N];
    queue.add(new int[] {0, 0});
    int costSum = 0, visitCount = 0;
    while (queue.size() > 0) {
      int[] edge = queue.remove();
      int node = edge[0], cost = edge[1];
      if (visited[node]) continue;
      visited[node] = true;
      costSum += cost;
      ++visitCount;
      for (int next = 0; next < N; ++next)
        if (visited[next] == false && distances[node][next] < INF)
          queue.add(new int[] { next, distances[node][next] });
    }
    return visitCount < N ? -1 : costSum;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
    ROW = Integer.parseInt(tokenizer.nextToken());
    COL = Integer.parseInt(tokenizer.nextToken());
    A = new int[ROW][COL];
    for (int r = 0; r < ROW; ++r) {
      tokenizer = new StringTokenizer(reader.readLine());
      for (int c = 0; c < COL; ++c)
        A[r][c] = Integer.parseInt(tokenizer.nextToken());
    }
    int id = 2;
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        if (A[r][c] == 1)
          DFS1(r, c, id++);
    N = id - 2;
    distances = new int[N][N];
    for (var d : distances)
      Arrays.fill(d, INF);
    for (int r = 0; r < ROW; ++r)
      for (int c = 0; c < COL; ++c)
        if (A[r][c] != 0)
          for (int dir = 0; dir < 4; ++dir)
            DFS2(r, c, A[r][c], dir, 0);
    System.out.println(prim());
  }
}