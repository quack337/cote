package programmers.e67260;

import java.util.ArrayList;

public class Main1 {

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

        void print() {
            for (int i = 0; i < N; ++i)
                System.out.printf("%d %s %s\n", i, parents[i], children[i]);
            System.out.println();
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
            print();
            return true;
        }
    }

    public static void main(String[] args) {
        var path = new int[][] {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        var order = new int[][] {{8,5},{6,7},{4,1}};
        var sol = new Solution();
        System.out.println(sol.solution(9, path, order));
    }

}