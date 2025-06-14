package baekjoon.b2206.old;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 2178 참고
public class Main1 {
    static class Node {
        int r, c, distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }

        public boolean equals(Node p) {
            return r == p.r && c == p.c;
        }
    }

    static int BFS(char[][] map) {
        final char WALL = '1', VISITED = '.';

        Node 목적지 = new Node(map.length - 1, map[0].length - 1, 0);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1));    // 시작 위치
        while (queue.size() > 0) {
            Node node = queue.remove();        // 현재위치
            if (node.r < 0 || node.r >= map.length) continue;
            if (node.c < 0 || node.c >= map[0].length) continue;
            if (map[node.r][node.c] == WALL) continue;
            if (map[node.r][node.c] == VISITED) continue;
            if (node.equals(목적지)) return node.distance;
            map[node.r][node.c] = VISITED;
            queue.add(new Node(node.r-1, node.c, node.distance+1)); // 위
            queue.add(new Node(node.r, node.c-1, node.distance+1)); // 왼쪽
            queue.add(new Node(node.r+1, node.c, node.distance+1)); // 아래
            queue.add(new Node(node.r, node.c+1, node.distance+1)); // 오른쪽
        }
        return -1; // 탐색 실패
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        char[][] map = new char[N][];
        for (int i = 0; i < N; ++i)
            map[i] = reader.readLine().toCharArray();
        System.out.println(BFS(map));
    }
}