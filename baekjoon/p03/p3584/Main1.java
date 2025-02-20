package baekjoon.p03.p3584;

import java.util.Scanner;

public class Main1 {

    static int 부모들탐색(int[] 부모, boolean[] visited, int 노드) {
        while (노드 != 0) { // 루트의 부모는 0
            if (visited[노드]) break; // 공통 부모 발견
            visited[노드] = true;
            노드 = 부모[노드];
        }
        return 노드;
    }

    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            int T = scanner.nextInt();
            for (int t = 0; t < T; ++t) {
                int N = scanner.nextInt();
                var 부모 = new int[N + 1];
                for (int n = 0; n < N-1; ++n) {
                    int parent = scanner.nextInt();
                    int child = scanner.nextInt();
                    부모[child] = parent;
                }
                int 노드1 = scanner.nextInt();
                int 노드2 = scanner.nextInt();
                var visited = new boolean[N + 1];
                부모들탐색(부모, visited, 노드1);
                System.out.println(부모들탐색(부모, visited, 노드2));
            }
        }
    }
}
