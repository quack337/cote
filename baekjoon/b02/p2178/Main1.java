package baekjoon.b02.p2178;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {

    static class Node {
        int r, c, distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    static int 탐색(char[][] map) {
        final int R = map.length, C = map[0].length;
        boolean[][] visited = new boolean[R][C];
        Queue<Node> queue = new ArrayDeque<>(); // 방문할 칸 예약 목록
        queue.add(new Node(0, 0, 1));           // 시작 칸 방문 예약
        while (queue.size() > 0) {
            Node current = queue.remove();         // 예약된 칸을 방문한다
            int r = current.r, c = current.c, distance = current.distance;
            if (r < 0 || r >= R) continue;
            if (c < 0 || c >= C) continue;
            if (r == R-1 && c == C-1) return current.distance;  // 목적지에 도착했는가?
            if (map[r][c] == '0') continue;   // 벽인가?
            if (visited[r][c]) continue;      // 이미 방문한 칸인가?
            visited[r][c] = true;             // 방문 표시
            queue.add(new Node(r - 1, c, distance + 1)); // 윗 칸 방문 예약
            queue.add(new Node(r + 1, c, distance + 1)); // 아래 칸 방문 예약
            queue.add(new Node(r, c - 1, distance + 1)); // 왼쪽 칸 방문 예약
            queue.add(new Node(r, c + 1, distance + 1)); // 오른쪽 칸 방문 예약
        }
        return -1; // 탐색 실패
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            char[][] map = new char[R][];
            for (int r = 0; r < R; ++r)
                map[r] = scanner.next().toCharArray();
            System.out.println(탐색(map));
        }
    }
}