package baekjoon.b03.p3860;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 답
public class Main1 {
    static final int 무한대 = Integer.MAX_VALUE;

    static boolean 모든간선수정(int[][] 거리, ArrayList<int[]> 간선) {
        boolean 수정됨 = false;
        for (int i = 0; i < 간선.size(); ++i) {
            int[] a = 간선.get(i);
            int x1 = a[0], y1 = a[1], x2 = a[2], y2 = a[3], t = a[4];
            if (거리[x1][y1] != 무한대 && 거리[x2][y2] > 거리[x1][y1] + t) {
                거리[x2][y2] = 거리[x1][y1] + t;
                수정됨 = true;
            }
        }
        return 수정됨;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int W = scanner.nextInt();
            int H = scanner.nextInt();
            if (W + H == 0) break;
            int G = scanner.nextInt();
            boolean[][] 묘비 = new boolean[W][H];
            for (int i = 0; i < G; ++i) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                묘비[x][y] = true;
            }
            int E = scanner.nextInt();
            int[][][] 구멍 = new int[W][H][];
            for (int i = 0; i < E; ++i) {
                int x1 = scanner.nextInt();
                int y1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                int y2 = scanner.nextInt();
                int t = scanner.nextInt();
                구멍[x1][y1] = new int[] {x1, y1, x2, y2, t};
            }
            var 간선 = new ArrayList<int[]>();
            for (int x = 0; x < W; ++x)
                for (int y = 0; y < H; ++y) {
                    if (x == W-1 && y == H-1) continue;
                    if (묘비[x][y]) continue;
                    if (구멍[x][y] != null) 간선.add(구멍[x][y]);
                    else {
                        if (x > 0 && !묘비[x-1][y]) 간선.add(new int[] {x, y, x-1, y, 1});
                        if (y > 0 && !묘비[x][y-1]) 간선.add(new int[] {x, y, x, y-1, 1});
                        if (x < W-1 && !묘비[x+1][y]) 간선.add(new int[] {x, y, x+1, y, 1});
                        if (y < H-1 && !묘비[x][y+1]) 간선.add(new int[] {x, y, x, y+1, 1});
                    }
                }
            int[][] 거리 = new int[W][H];
            for (int x = 0; x < W; ++x)
                Arrays.fill(거리[x], 무한대);
            거리[0][0] = 0;
            for (int n = 0; n < W * H - 1; ++n)
                모든간선수정(거리, 간선);
            if (모든간선수정(거리, 간선))
                System.out.println("Never");
            else
                System.out.println(거리[W-1][H-1] == 무한대 ? "Impossible" : 거리[W-1][H-1]);
        }
        scanner.close();
    }
}