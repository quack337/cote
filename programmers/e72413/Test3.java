package net.skhu.kakao.t2021.ex4;

public class Test3 {

    static class Solution {
        static final int MAX = Integer.MAX_VALUE;

        void floydWarshall(int n, int[][] 최단거리) {
            for (int k = 0; k < n; ++k)
                for (int i = 0; i < n; ++i)
                    for (int j = 0; j < n; ++j) {
                        if (최단거리[i][k] == MAX || 최단거리[k][j] == MAX)
                            continue;
                        int 거리 = 최단거리[i][k] + 최단거리[k][j];
                        if (거리 < 최단거리[i][j]) 최단거리[i][j] = 거리;
                    }
        }

        public int solution(int n, int s, int a, int b, int[][] fares) {
            --s; --a; --b;
            int[][] 최단거리 = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j)
                    최단거리[i][j] = MAX;
                최단거리[i][i] = 0;
            }
            for (int[] f : fares) {
                int v = f[0] - 1, w = f[1] - 1;
                최단거리[v][w] = 최단거리[w][v] = f[2];
            }
            floydWarshall(n, 최단거리);
            int 최소 = MAX;
            for (int i = 0; i < n; ++i) {
                if (최단거리[s][i] == MAX || 최단거리[i][a] == MAX || 최단거리[i][b] == MAX)
                    continue;
                int 거리 = 최단거리[s][i] + 최단거리[i][a] + 최단거리[i][b];
                if (거리 < 최소) 최소 = 거리;
            }
            return 최소;
        }
    }

    public static void main(String[] args) {
        int[][] fares1 = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int[][] fares2 = {{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        int[][] fares3 = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};
        Solution s = new Solution();
        System.out.println(s.solution(6, 4, 6, 2, fares1));
        System.out.println(s.solution(7, 3, 4, 1, fares2));
        System.out.println(s.solution(6, 4, 5, 6, fares3));
    }

}

