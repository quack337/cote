package programmers.p72413;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("unchecked")
public class Test2 {

    static class Solution {

        static class Node {
            int 위치, 거리;

            public Node(int 위치, int 거리) {
                this.위치 = 위치;
                this.거리 = 거리;
            }
        }

        List<Node>[] 이웃목록;

        void 이웃목록생성(int n, int[][] fares) {
            이웃목록 = new List[n + 1];
            for (int i = 1; i <= n; ++i)
                이웃목록[i] = new ArrayList<>();
            for (int[] f : fares) {
                이웃목록[f[0]].add(new Node(f[1], f[2]));
                이웃목록[f[1]].add(new Node(f[0], f[2]));
            }
        }

        void 최단거리계산(int 출발지, boolean[] 방문, int[] 최단거리) {
            PriorityQueue<Node> queue = new PriorityQueue<>((n1, n2) -> n1.거리 - n2.거리);
            queue.add(new Node(출발지, 0));
            while (queue.size() > 0) {
                Node node = queue.remove();
                if (방문[node.위치]) continue;
                방문[node.위치] = true;
                최단거리[node.위치] = node.거리;
                for (Node 이웃 : 이웃목록[node.위치])
                    if (방문[이웃.위치] == false)
                        queue.add(new Node(이웃.위치, node.거리 + 이웃.거리));
            }
        }

        public int solution(int n, int s, int a, int b, int[][] fares) {
            이웃목록생성(n, fares);
            boolean[] 방문s, 방문a, 방문b;
            int[] 거리s, 거리a, 거리b;
            최단거리계산(s, 방문s = new boolean[n+1], 거리s = new int[n+1]);
            최단거리계산(a, 방문a = new boolean[n+1], 거리a = new int[n+1]);
            최단거리계산(b, 방문b = new boolean[n+1], 거리b = new int[n+1]);
            int 최소 = Integer.MAX_VALUE;
            for (int i = 1; i <= n; ++i)
                if (방문s[i] && 방문a[i] && 방문b[i])
                    최소 = Math.min(최소, 거리s[i] + 거리a[i] + 거리b[i]);
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