package baekjoon.p02.p2931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int N=1, S=2, W=3, E=4; // 동 남 서 동
    static int R, C;
    static char[][] map;

    static class Node {
        int r, c, distance, from;
        Pipe pipe; // 추가된 파이프

        public Node(int r, int c, int distance, int from, Pipe pipe) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.from = from; // 진입방향 (동서남북)
            this.pipe = pipe;
        }
    }

    static class Pipe {
        int r, c;
        char ch;

        public Pipe(int r, int c, char ch) {
            this.r = r;
            this.c = c;
            this.ch = ch;
        }
    }

    static Pipe BFS(int r0, int c0) {
        Queue<Node> queue = new ArrayDeque<Node>();
        queue.add(new Node(r0-1, c0, 1, S, null));
        queue.add(new Node(r0+1, c0, 1, N, null));
        queue.add(new Node(r0, c0-1, 1, E, null));
        queue.add(new Node(r0, c0+1, 1, W, null));
        Node lastNode = null;
        while (queue.size() > 0) {
            Node node = queue.remove();
            int r = node.r, c = node.c, distance = node.distance, from = node.from;
            Pipe pipe = node.pipe;
            if (r < 0 || r >= R) continue;
            if (c < 0 || c >= C) continue;
            char ch = map[r][c];
            if (pipe != null && r == pipe.r && c == pipe.c)
                ch = pipe.ch;

            if (ch == 'Z')
                lastNode = node;
            else if (ch == '|' || ch == '-' || ch == '+') {
                if (ch == '|' || ch == '+') {
                    if (from == N) queue.add(new Node(r+1, c, distance+1, N, pipe));
                    if (from == S) queue.add(new Node(r-1, c, distance+1, S, pipe));
                }
                if (ch == '-' || ch == '+') {
                    if (from == E) queue.add(new Node(r, c-1, distance+1, E, pipe));
                    if (from == W) queue.add(new Node(r, c+1, distance+1, W, pipe));
                }
            }
            else if (ch == '1') {
                if (from == S) queue.add(new Node(r, c+1, distance+1, W, pipe));
                if (from == E) queue.add(new Node(r+1, c, distance+1, N, pipe));
            }
            else if (ch == '2') {
                if (from == N) queue.add(new Node(r, c+1, distance+1, W, pipe));
                if (from == E) queue.add(new Node(r-1, c, distance+1, S, pipe));
            }
            else if (ch == '3') {
                if (from == N) queue.add(new Node(r, c-1, distance+1, E, pipe));
                if (from == W) queue.add(new Node(r-1, c, distance+1, S, pipe));
            }
            else if (ch == '4') {
                if (from == S) queue.add(new Node(r, c-1, distance+1, E, pipe));
                if (from == W) queue.add(new Node(r+1, c, distance+1, N, pipe));
            }
            else if (ch == '.') {
                if (pipe != null) continue;
                if (from == N) {
                    queue.add(new Node(r+1, c, distance+1, N, new Pipe(r, c, '+')));
                    queue.add(new Node(r+1, c, distance+1, N, new Pipe(r, c, '|')));
                    queue.add(new Node(r, c+1, distance+1, W, new Pipe(r, c, '2')));
                    queue.add(new Node(r, c-1, distance+1, E, new Pipe(r, c, '3')));
                } else if (from == S) {
                    queue.add(new Node(r-1, c, distance+1, S, new Pipe(r, c, '+')));
                    queue.add(new Node(r-1, c, distance+1, S, new Pipe(r, c, '|')));
                    queue.add(new Node(r, c+1, distance+1, W, new Pipe(r, c, '1')));
                    queue.add(new Node(r, c-1, distance+1, E, new Pipe(r, c, '4')));
                } else if (from == E) {
                    queue.add(new Node(r, c-1, distance+1, E, new Pipe(r, c, '+')));
                    queue.add(new Node(r, c-1, distance+1, E, new Pipe(r, c, '-')));
                    queue.add(new Node(r+1, c, distance+1, N, new Pipe(r, c, '1')));
                    queue.add(new Node(r-1, c, distance+1, S, new Pipe(r, c, '2')));
                } else if (from == W) {
                    queue.add(new Node(r, c+1, distance+1, W, new Pipe(r, c, '+')));
                    queue.add(new Node(r, c+1, distance+1, W, new Pipe(r, c, '-')));
                    queue.add(new Node(r-1, c, distance+1, S, new Pipe(r, c, '3')));
                    queue.add(new Node(r+1, c, distance+1, N, new Pipe(r, c, '4')));
                }
            }
        }
        return lastNode.pipe;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        R = Integer.parseInt(tokenizer.nextToken());
        C = Integer.parseInt(tokenizer.nextToken());
        map = new char[R][];
        int r0 = 0, c0 = 0;
        for (int r = 0; r < R; ++r) {
            map[r] = reader.readLine().toCharArray();
            for (int c = 0; c < C; ++c)
                if (map[r][c] == 'M') { r0 = r; c0 = c; }
        }
        Pipe pipe = BFS(r0, c0);
        System.out.printf("%d %d %c\n", pipe.r+1, pipe.c+1, pipe.ch);
    }
}
