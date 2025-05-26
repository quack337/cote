package baekjoon.b2206;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 2178 참고
public class Main {
    static class Node {
        int r, c, distance, wall; // wall=벽 통과 수

        public Node(int r, int c, int distance, int wall) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.wall = wall;
        }

        public boolean equals(Node p) {
            return r == p.r && c == p.c;
        }
    }

    static int BFS(char[][] map, int N, int M) {
        final char WALL = '1';
        boolean[][][] visited = new boolean[N][M][2];

        Node 목적지 = new Node(N-1, M-1, 0, 0);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, 0));    // 시작 위치
        while (queue.size() > 0) {
            Node node = queue.remove();         // 현재위치
            if (node.r < 0 || node.r >= N) continue;
            if (node.c < 0 || node.c >= M) continue;
            if (map[node.r][node.c] == WALL) {
                if (node.wall == 1) continue; // 이미 벽을 통과했으면, 이 경로 기각
                node.wall++;                  // 벽을 통과하여 탐색 계속
            }
            if (node.equals(목적지)) return node.distance;
            if (visited[node.r][node.c][node.wall]) continue;
            visited[node.r][node.c][node.wall] = true;
            queue.add(new Node(node.r-1, node.c, node.distance+1, node.wall)); // 위
            queue.add(new Node(node.r, node.c-1, node.distance+1, node.wall)); // 왼쪽
            queue.add(new Node(node.r+1, node.c, node.distance+1, node.wall)); // 아래
            queue.add(new Node(node.r, node.c+1, node.distance+1, node.wall)); // 오른쪽
        }
        return -1; // 탐색 실패
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        char[][] map = new char[N][];
        for (int i = 0; i < N; ++i)
            map[i] = reader.readLine().toCharArray();
        System.out.println(BFS(map, N, M));
    }
}