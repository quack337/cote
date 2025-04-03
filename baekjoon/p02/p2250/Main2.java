package baekjoon.p02.p2250;

import java.util.Scanner;

public class Main2 {
    static final int LEFT = 0, RIGHT = 1, ROW = 0, COL = 1, MIN = 0, MAX = 1;
    static int[][] location;
    static int[][] children;
    static int[][] minmax;
    static int maxWidth = 1;
    static int maxWidthDepth = 1;

    static int calcSubtreeWidth(int node) {
        if (node == -1) return 0;
        int[] child = children[node];
        return calcSubtreeWidth(child[LEFT]) + calcSubtreeWidth(child[RIGHT]) + 1;
    }

    static void calcLocation(int node, int depth, int 왼쪽끝) {
        if (node == -1) return;
        int[] child = children[node];
        calcLocation(child[LEFT], depth + 1, 왼쪽끝);
        int row = depth, col = 왼쪽끝 + calcSubtreeWidth(child[LEFT]);
        location[node] = new int[] { row, col };
        if (minmax[depth] == null)
            minmax[depth] = new int[] { col, col };
        else {
            if (col < minmax[depth][MIN]) minmax[depth][MIN] = col;
            if (col > minmax[depth][MAX]) minmax[depth][MAX] = col;
            int width = minmax[depth][MAX] - minmax[depth][MIN] + 1;
            if (width > maxWidth) {
                maxWidth = width;
                maxWidthDepth = depth;
            } else if (width == maxWidth)
                maxWidthDepth = Math.min(depth, maxWidthDepth);
        }
        calcLocation(child[RIGHT], depth + 1, location[node][COL] + 1);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int root = (1 + N) * N / 2;
            minmax = new int[N + 1][];
            children = new int[N + 1][];
            for (int i = 0; i < N; ++i) {
                int node = scanner.nextInt();
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                if (left > 0) root -= left;
                if (right > 0) root -= right;
                children[node] = new int[] { left, right };
            }
            location = new int[N + 1][];
            calcLocation(root, 1, 1);
            System.out.println(maxWidthDepth + " " + maxWidth);
        }
    }
}