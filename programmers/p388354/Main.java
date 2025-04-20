package programmers.p388354;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    static class Solution {
        final static int 정홀짝 = 0, 역홀짝 = 1; // index

        void dfs(int node, int[] nodeValues, ArrayList<Integer>[] neighbors, boolean[] visited, int[] count) {
            if (visited[node]) return;
            visited[node] = true;
            if (nodeValues[node] % 2 == neighbors[node].size() % 2)
                count[정홀짝]++;
            else
                count[역홀짝]++;
            for (var neighbor : neighbors[node])
                dfs(neighbor, nodeValues, neighbors, visited, count);
        }

        @SuppressWarnings("unchecked")
        public int[] solution(int[] nodeValues, int[][] edges) {
            var nodeIndex = new HashMap<Integer, Integer>();
            for (int i = 0; i < nodeValues.length; ++i)
                nodeIndex.put(nodeValues[i], i);
            var neighbors = new ArrayList[nodeValues.length];
            for (int i = 0; i < nodeValues.length; ++i)
                neighbors[i] = new ArrayList<Integer>();
            for (var edge : edges) {
                int a = nodeIndex.get(edge[0]), b = nodeIndex.get(edge[1]);
                neighbors[a].add(b);
                neighbors[b].add(a);
            }
            var answer = new int[2];
            var visited = new boolean[nodeValues.length];
            for (int node = 0; node < nodeValues.length; ++node)
                if (visited[node] == false) {
                    var count = new int[2];
                    dfs(node, nodeValues, neighbors, visited, count);
                    if (count[정홀짝] == 1) answer[0]++;
                    if (count[역홀짝] == 1) answer[1]++;
                }
            return answer;
        }
    }

    public static void main(String[] args) {
        var nodeValues = new int[] {11, 9, 3, 2, 4, 6};
        var edges = new int[][] {{9, 11}, {2, 3}, {6, 3}, {3, 4}};
        var answer = (new Solution()).solution(nodeValues, edges);
        System.out.printf("%d %d\n", answer[0], answer[1]);

        nodeValues = new int[] {9, 15, 14, 7, 6, 1, 2, 4, 5, 11, 8, 10};
        edges = new int[][] {{5, 14}, {1, 4}, {9, 11}, {2, 15}, {2, 5}, {9, 7}, {8, 1}, {6, 4}};
        answer = (new Solution()).solution(nodeValues, edges);
        System.out.printf("%d %d\n", answer[0], answer[1]);
    }
}