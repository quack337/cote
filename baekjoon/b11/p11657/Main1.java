package baekjoon.b11.p11657;

import java.util.Arrays;
import java.util.Scanner;

// int 타입이라서 출력초과 에러
public class Main1 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] 거리 = new int[N];
        int[][] 간선 = new int[M][3];
        for (int i = 0; i < M; ++i) {
            int a = scanner.nextInt() - 1;
            int b = scanner.nextInt() - 1;
            int c = scanner.nextInt();
            간선[i] = new int[] {a, b, c};
        }
        scanner.close();
        final int 무한대 = Integer.MAX_VALUE;
        Arrays.fill(거리, 무한대);
        거리[0] = 0;
        for (int n = 0; n < N-1; ++n) {
            for (int i = 0; i < M; ++i) {
                int a = 간선[i][0], b = 간선[i][1], c = 간선[i][2];
                if (거리[a] != 무한대 && 거리[b] > 거리[a] + c)
                    거리[b] = 거리[a] + c;
            }
            System.out.println(Arrays.toString(거리));
        }
        for (int i = 0; i < M; ++i) {
            int a = 간선[i][0], b = 간선[i][1], c = 간선[i][2];
            if (거리[a] != 무한대 && 거리[b] > 거리[a] + c) {
                System.out.println(-1);
                return;
            }
        }
        for (int i = 1; i < N; ++i)
            System.out.println(거리[i] == 무한대 ? -1 : 거리[i]);
    }
}