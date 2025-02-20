package programmers.e118669;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class Main2 {

    static class Solution {
        List<int[]>[] edges;

        int dijkstra(int summit, Set<Integer> gates, Set<Integer> summits) {
            var visited = new HashSet<Integer>();
            var queue = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
            queue.add(new int[] {summit, 0});
            while (queue.size() > 0) {
                int[] p = queue.remove();
                int node = p[0], maxCost = p[1];
                if (gates.contains(node)) return maxCost;
                if (summits.contains(node)) continue;
                if (visited.contains(node)) continue;
                visited.add(node);
                for (int[] edge : edges[node]) {
                    int b = edge[0], cost = edge[1];
                    if (visited.contains(b)) continue;
                    queue.add(new int[] {b, Math.max(cost, maxCost)});
                }
            }
            return Integer.MAX_VALUE;
        }

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            edges = new ArrayList[n + 1];
            for (int i = 0; i < edges.length; ++i)
                edges[i] = new ArrayList<>();
            for (int[] path : paths) {
                int a = path[0], b = path[1], cost = path[2];
                edges[a].add(new int[] {b, cost});
                edges[b].add(new int[] {a, cost});
            }
            var gates1 = Arrays.stream(gates).boxed().collect(Collectors.toSet());
            int minSummit = 0, minCost = Integer.MAX_VALUE;
            for (int summit : summits) {
                var summits1 = Arrays.stream(summits).boxed().collect(Collectors.toSet());
                summits1.remove(summit);
                int cost = dijkstra(summit, gates1, summits1);
                if (cost < minCost || (cost == minCost && summit < minSummit)) {
                    minSummit = summit;
                    minCost = cost;
                }
            }
            return new int[] {minSummit, minCost};
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        var paths = new int[][] {{1,2,3},{2,3,5},{2,4,2},{2,5,4},{3,4,4},{4,5,3},{4,6,1},{5,6,1}};
        var gates = new int[] {1,3}; var summits = new int[] {5};
        var a = s.solution(6,paths,gates,summits);
        System.out.println(Arrays.toString(a));

        paths = new int[][] {{1,4,4},{1,6,1},{1,7,3},{2,5,2},{3,7,4},{5,6,6}};
        gates = new int[] {1}; summits = new int[] {2,3,4};
        a = s.solution(7,paths,gates,summits);
        System.out.println(Arrays.toString(a));

        paths = new int[][] {{1,2,5},{1,4,1},{2,3,1},{2,6,7},{4,5,1},{5,6,1},{6,7,1}};
        gates = new int[] {3,7}; summits = new int[] {1,5};
        a = s.solution(7,paths,gates,summits);
        System.out.println(Arrays.toString(a));

        paths = new int[][] {{1,3,10},{1,4,20},{2,3,4},{2,4,6},{3,5,20},{4,5,6}};
        gates = new int[] {1,2}; summits = new int[] {5};
        a = s.solution(5,paths,gates,summits);
        System.out.println(Arrays.toString(a));
    }
}
