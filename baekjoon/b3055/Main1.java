package baekjoon.b3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 정답이었으나 오답됨
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

    static int[][] waterDistance() {
        int[][] water = new int[R][C];
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                int distance =  BFS(r, c, '*', null);
                water[r][c] = (distance == -1 ? Integer.MAX_VALUE : distance);
            }
        return water;
    }

    static int BFS(int row, int col, char destination, int[][] waterDistance) {
        boolean[][] visited = new boolean[R][C];
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col, 0));
        while (queue.size() > 0) {
            Node node = queue.remove();
            int r = node.r, c = node.c, distance = node.distance;
            if (r < 0 || r >= R) continue;
            if (c < 0 || c >= C) continue;
            if (map[r][c] == destination) return distance;
            if (map[r][c] != '.') continue;
            if (waterDistance != null && waterDistance[r][c] <= distance) continue;
            if (visited[r][c]) continue;
            visited[r][c] = true;
            queue.add(new Node(r-1, c, distance+1));
            queue.add(new Node(r+1, c, distance+1));
            queue.add(new Node(r, c-1, distance+1));
            queue.add(new Node(r, c+1, distance+1));
        }
        return -1;
    }

    static Node find(char ch) {
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c)
                if (map[r][c] == ch)
                    return new Node(r, c, 0);
        return null;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        map = new char[R][C];
        for (int r = 0; r < R; ++r)
            map[r] = reader.readLine().toCharArray();
        Node start = find('S');
        map[start.r][start.c] = '.';
        int distance = BFS(start.r, start.c, 'D', waterDistance());
        System.out.println(distance < 0 ? "KAKTUS" : distance);
    }
}