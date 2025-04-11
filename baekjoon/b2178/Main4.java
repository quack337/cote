package baekjoon.b2178;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main4 {

    static class Node {
        int r, c, distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    static int R, C;
    static char[][] map;
    static boolean[][] visited = new boolean[R][C];

    static int BFS(int r0, int c0) {
        Queue<Node> queue = new ArrayDeque<>(); // 방문할 칸 목록
        queue.add(new Node(r0, c0, 1));           // 시작 위치
        while (queue.size() > 0) {
            Node current = queue.remove();         // 현재 위치
            int r = current.r, c = current.c, distance = current.distance;
            if (r < 0 || r >= R) continue;
            if (c < 0 || c >= C) continue;
            if (map[r][c] == 'G') return current.distance;  // 목적지 도착
            if (map[r][c] == '#') continue;   // 벽
            if (visited[r][c]) continue;      // 이미 방문한 칸인가?
            visited[r][c] = true;
            queue.add(new Node(r - 1, c, distance + 1)); // 위로
            queue.add(new Node(r + 1, c, distance + 1)); // 아래쪽으로
            queue.add(new Node(r, c - 1, distance + 1)); // 왼쪽으로
            queue.add(new Node(r, c + 1, distance + 1)); // 오른쪽으로
        }
        return -1; // 탐색 실패
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        visited = new boolean[R][C];
        map = new char[R][];
        for (int r = 0; r < R; ++r)
            map[r] = reader.readLine().toCharArray();
        System.out.println(BFS(0, 0));
    }
}