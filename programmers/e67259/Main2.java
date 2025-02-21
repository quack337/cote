import java.util.PriorityQueue;

public class Main2 {

    static class Solution {
        static final int S = 0, V = 1, H = 2; // S:출발, V:수직이동, H:수평이동

        public int solution(int[][] map) {
            int N = map.length;
            var visited = new boolean[N][N][3];
            var queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
            queue.add(new int[] {0, 0, 0, S});
            while (queue.size() > 0) {
                int[] a = queue.remove();
                int r = a[0], c = a[1], cost = a[2], dir = a[3];
                if (r < 0 || r >= N) continue;
                if (c < 0 || c >= N) continue;
                if (r == N-1 && c == N-1) return cost;
                if (map[r][c] == 1) continue;
                if (visited[r][c][dir]) continue;
                visited[r][c][dir] = true;
                queue.add(new int[] { r-1, c, cost + 100 + (dir == H ? 500 : 0), V });
                queue.add(new int[] { r+1, c, cost + 100 + (dir == H ? 500 : 0), V });
                queue.add(new int[] { r, c-1, cost + 100 + (dir == V ? 500 : 0), H });
                queue.add(new int[] { r, c+1, cost + 100 + (dir == V ? 500 : 0), H });
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        var maps = new int[][][] {
                {{0,0,0},{0,0,0},{0,0,0}},
                {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},
                 {0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}},
                {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}},
                {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},
                 {1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}}};
        var sol = new Solution();
        for (var map : maps)
            System.out.println(sol.solution(map));
    }
}