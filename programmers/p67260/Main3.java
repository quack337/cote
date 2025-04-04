package programmers.p67260;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main3 {

    @SuppressWarnings("unchecked")
    static class Solution {
        int N;
        ArrayList<Integer>[] parents, children;

        void findParent(int node, int parent) {
            parents[node].add(parent);
            children[node].remove((Integer)parent);
            for (int child : children[node])
                findParent(child, node);
        }

        boolean topological_sort() {
            int count = 0;
            var queue = new ArrayDeque<Integer>();
            queue.add(0);
            while (queue.size() > 0) {
                int node = queue.remove();
                ++count;
                for (int child : children[node]) {
                    parents[child].remove((Integer)node);
                    if (parents[child].size() == 0)
                        queue.add(child);
                }
            }
            return count == N;
        }

        public boolean solution(int n, int[][] path, int[][] order) {
            this.N = n;
            children = new ArrayList[N];
            parents = new ArrayList[N];
            for (int i = 0; i < N; ++i) {
                children[i] = new ArrayList<Integer>(2);
                parents[i] = new ArrayList<Integer>(2);
            }
            for (int[] p : path) {
                int a = p[0], b = p[1];
                children[a].add(b);
                children[b].add(a);
            }
            findParent(0, -1);
            for (int[] o : order) {
                int a = o[0], b = o[1];
                children[a].add(b);
                parents[b].add(a);
            }
            if (parents[0].size() > 1) return false;
            return topological_sort();
        }
    }

    public static void main(String[] args) {
        var path = new int[][] {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        var order = new int[][] {{8,5},{6,7},{4,1}};
        var sol = new Solution();
        System.out.println(sol.solution(9, path, order));

        path = new int[][] {{8,1},{0,1},{1,2},{0,7},{4,7},{0,3},{7,5},{3,6}};
        order = new int[][] {{4,1},{5,2}};
        System.out.println(sol.solution(9, path, order));

        path = new int[][] {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        order = new int[][] {{4,1},{8,7},{6,5}};
        System.out.println(sol.solution(9, path, order));

        path = new int[][] {{0,1},{0,2}};
        order = new int[][] {{1, 0}};
        System.out.println(sol.solution(3, path, order));
    }
}