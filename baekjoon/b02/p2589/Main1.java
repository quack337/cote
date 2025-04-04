package baekjoon.b02.p2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main1 {
    static int R, C;
    static char[][] map;

    static class Node {
        int r, c, distance;

        public Node(int r, int c, int distance) {
            this.r = r;
            this.c = c;
            this.distance = distance;
        }
    }

    static Node BFS(int row, int col, boolean[][] visited) {
        if (visited == null) visited = new boolean[R][C];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col, 0));
        Node lastNode = null;
        while (queue.size() > 0) {
            Node node = queue.remove();
            int r = node.r, c = node.c, distance = node.distance;
            if (r < 0 || r >= R) continue;
            if (c < 0 || c >= C) continue;
            if (map[r][c] != 'L') continue;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            lastNode = node;
            queue.add(new Node(r-1, c, distance+1));
            queue.add(new Node(r+1, c, distance+1));
            queue.add(new Node(r, c-1, distance+1));
            queue.add(new Node(r, c+1, distance+1));
        }
        return lastNode;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        map = new char[R][C];
        for (int r = 0; r < R; ++r)
            map[r] = reader.readLine().toCharArray();

        boolean[][] visited = new boolean[R][C];
        int maxDistance = 0;
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (map[r][c] == 'L' && visited[r][c] == false) {
                    Node lastNode1 = BFS(r, c, null);
                    Node lastNode2 = BFS(lastNode1.r, lastNode1.c, visited);
                    System.out.printf("%d %d %d\n", lastNode1.r, lastNode1.c, lastNode1.distance);
                    System.out.printf("%d %d %d\n", lastNode2.r, lastNode2.c, lastNode2.distance);
                    if (lastNode2.distance > maxDistance) maxDistance = lastNode2.distance;
                }
            }
        }
        System.out.println(maxDistance);
    }
}


/*
반례

4 4
LLLL
LWLW
LLLW
LWWW
*/