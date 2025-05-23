import java.util.*;

public class Main {
  static int ROW, COL;
  static char[][] A;

  static int BFS() {
    var visited = new boolean[ROW][COL];
    var queue = new ArrayDeque<int[]>();
    queue.add(new int[] {0, 0, 0});
    while (queue.size() > 0) {
      int[] u = queue.remove();
      int r = u[0], c = u[1], distance = u[2];
      if (A[r][c] == '#') continue;
      if (visited[r][c]) continue;
      visited[r][c] = true;
      if (r == ROW-1 && c == COL-1) return distance;
      if (r > 0) queue.add(new int[] {r-1, c, distance+1});
      if (c > 0) queue.add(new int[] {r, c-1, distance+1});
      if (r < ROW-1) queue.add(new int[] {r+1, c, distance+1});
      if (c < COL-1) queue.add(new int[] {r, c+1, distance+1});
    }
    return -1;
  }

  public static void main(String[] args) {
    ROW = 5; COL = 9;
    String[] input = {
      ".#...#...",
      ".#.#...#.",
      "...#.#.#.",
      "##.#.#.#.",
      ".....#..."};
    A = new char[ROW][];
    for (int r = 0; r < ROW; ++r)
      A[r] = input[r].toCharArray();
    System.out.println(BFS());
  }
}
