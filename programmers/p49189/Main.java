package programmers.p49189;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static class Solution {
        ArrayList<Integer>[] 이웃목록;

        int[] BFS(int N) {
            int[] distances = new int[N];
            Arrays.fill(distances, -1);
            var queue = new ArrayDeque<int[]>();
            queue.add(new int[] {0, 0});
            while (queue.size() > 0) {
                int[] current = queue.remove();
                int index = current[0], distance = current[1];
                if (distances[index] != -1) continue;
                distances[index] = distance;
                for (int v : 이웃목록[index])
                    if (distances[v] == -1)
                        queue.add(new int[] {v, distance + 1});
            }
            return distances;
        }

        @SuppressWarnings("unchecked")
        public int solution(int n, int[][] edge) {
            이웃목록 = new ArrayList[n];
            for (int i = 0; i < n; ++i)
                이웃목록[i] = new ArrayList<Integer>();
            for (int[] e : edge) {
                int a = e[0] - 1, b = e[1] - 1;
                이웃목록[a].add(b);
                이웃목록[b].add(a);
            }
            int[] distances = BFS(n);
            int maxDistance = 0, count = 0;
            for (int distance : distances)
                if (distance > maxDistance) {
                    maxDistance = distance;
                    count = 1;
                } else if (distance == maxDistance)
                    ++count;
            return count;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(6, new int[][] {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
    }
}