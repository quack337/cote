package baekjoon.b2250;
import java.util.Scanner;

public class Main1 {

    static final int LEFT = 0, RIGHT = 1, ROW = 0, COL = 1;
    static int[][] location;
    static int[][] children;

    static int calcSubtreeWidth(int node) {
        if (node == -1) return 0;
        int[] child = children[node];
        return calcSubtreeWidth(child[LEFT]) + calcSubtreeWidth(child[RIGHT]) + 1;
    }

    static void calcLocation(int node, int depth, int 왼쪽끝) {
        if (node == -1) return;
        int[] child = children[node];
        calcLocation(child[LEFT], depth + 1, 왼쪽끝);
        location[node][ROW] = depth;
        location[node][COL] = 왼쪽끝 + calcSubtreeWidth(child[LEFT]);
        calcLocation(child[RIGHT], depth + 1, location[node][COL] + 1);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int root = (1 + N) * N / 2;
            children = new int[N + 1][];
            for (int i = 0; i < N; ++i) {
                int node = scanner.nextInt();
                int left = scanner.nextInt();
                int right = scanner.nextInt();
                if (left > 0) root -= left;
                if (right > 0) root -= right;
                children[node] = new int[] { left, right };
            }
            location = new int[N + 1][2];
            calcLocation(root, 1, 1);
            for (int i = 1; i <= N; ++i)
                System.out.printf("(%d, %d) ", location[i][ROW], location[i][COL]);
        }
    }
}