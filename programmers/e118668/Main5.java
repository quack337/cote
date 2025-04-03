package programmers.e118668;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main5 {

    static class Solution {
        int maxAlp, maxCop;
        int[][] problems;

        int dijkstra(int start_alp, int start_cop) {
            var visited = new boolean[maxAlp + 1][maxCop + 1];
            var queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
            queue.add(new int[] {start_alp, start_cop, 0});
            while (queue.size() > 0) {
                var node = queue.remove();
                int alp = node[0], cop = node[1], distance = node[2];
                if (alp >= maxAlp && cop >= maxCop) return distance;
                if (alp > maxAlp) alp = maxAlp;
                if (cop > maxCop) cop = maxCop;
                if (visited[alp][cop]) continue;
                visited[alp][cop] = true;
                if (alp < maxAlp) queue.add(new int[] { alp + 1, cop, distance + 1});
                if (cop < maxCop) queue.add(new int[] { alp, cop + 1, distance + 1});
                for (int[] p : problems)
                    if (p[0] <= alp && p[1] <= cop)
                        queue.add(new int[] { alp + p[2], cop + p[3], distance + p[4] });
            }
            return -1;
        }

        public int solution(int alp, int cop, int[][] problems) {
            this.problems = problems;
            maxAlp = Arrays.stream(problems).mapToInt(p -> p[0]).max().getAsInt();
            maxCop = Arrays.stream(problems).mapToInt(p -> p[1]).max().getAsInt();
            return dijkstra(alp, cop);
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        int cost = s.solution(10, 10, new int[][] {{10,15,2,1,2},{20,20,3,3,4}});
        System.out.println(cost);
        cost = s.solution(0, 0, new int[][] {{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}});
        System.out.println(cost);
        cost = s.solution(0, 0, new int[][] {{0,0,0,2,2},{10,10,2,2,2}});
        System.out.println(cost);
    }
}