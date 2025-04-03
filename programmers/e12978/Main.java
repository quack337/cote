package programmers.e12978;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    static class Solution {
        static final int INDEX=0, DISTANCE=1;

        static class Node {
            int index, distance;

            public Node(int index, int distance) {
                this.index = index;
                this.distance = distance;
            }
        }
        ArrayList<int[]>[] edges;

        int[] dijkstra(int N) {
            int[] distance = new int[N + 1];
            Arrays.fill(distance, -1);
            var queue = new PriorityQueue<Node>((a, b) -> a.distance - b.distance);
            queue.add(new Node(1, 0));
            while (queue.size() > 0) {
                Node current = queue.remove();
                if (distance[current.index] != -1) continue;
                distance[current.index] = current.distance;
                for (int[] edge : edges[current.index])
                    if (distance[edge[INDEX]] == -1)
                        queue.add(new Node(edge[INDEX], edge[DISTANCE] + current.distance));
            }
            return distance;
        }

        public int solution(int N, int[][] road, int K) {
            edges = new ArrayList[N + 1];
            for (int i = 1; i <= N; ++i)
                edges[i] = new ArrayList<int[]>();
            for (int[] r : road) {
                int a = r[0], b = r[1], c = r[2];
                edges[a].add(new int[] {b, c});
                edges[b].add(new int[] {a, c});
            }
            int[] distance = dijkstra(N);
            int answer = 0;
            for (int i = 1; i <= N; ++i)
                if (distance[i] <= K) ++answer;
            return answer;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[][] road1 = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        System.out.println(sol.solution(5, road1, 3));
        int[][] road2 = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        System.out.println(sol.solution(6, road2, 4));
    }

}