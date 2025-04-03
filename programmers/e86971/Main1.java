package programmers.e86971;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class Main1 {

    static class Solution {

        ArrayList<Integer>[] children;
        int[] subtreeSize;

        int 노드수DFS(int index, boolean[] visited) {
            if (visited[index]) return 0;
            visited[index] = true;
            int size = 1;
            for (int child : children[index])
                size += 노드수DFS(child, visited);
            return subtreeSize[index] = size;
        }

        public int solution(int n, int[][] wires) {
            children = new ArrayList[n + 1];
            for (int i = 1; i <= n; ++i)
                children[i] = new ArrayList<Integer>();
            for (int[] w : wires) {
                int a = w[0], b = w[1];
                children[a].add(b);
                children[b].add(a);
            }
            subtreeSize = new int[n + 1];
            int treeSize = 노드수DFS(1, new boolean[n + 1]);
            int answer = Integer.MAX_VALUE;
            for (int i = 1; i <= n; ++i) {
                int temp = Math.abs(subtreeSize[i] - (treeSize - subtreeSize[i]));
                if (temp < answer) answer = temp;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[][] w1 = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int[][] w2 = {{1,2},{2,3},{3,4}};
        int[][] w3 = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        Solution sol = new Solution();
        System.out.println(sol.solution(9, w1));
        System.out.println(sol.solution(4, w2));
        System.out.println(sol.solution(7, w3));
    }
}