package programmers.e150364;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main1 {

    @SuppressWarnings("unchecked")
    static class Solution {
        int N;
        int[] target, link;
        boolean[] isLeaf;
        ArrayList<Integer>[] children, drops;

            void drop(int node, int dropNo) {
            if (isLeaf[node]) {
                drops[node].add(dropNo);
            } else {
                drop(children[node].get(link[node]), dropNo);
                link[node] = (link[node] + 1) % children[node].size();
            }
        }

        public int[] solution(int[][] edges, int[] target) {
            N = edges.length + 1;
            this.target = target;
            link = new int[N];
            isLeaf = new boolean[N];
            children = new ArrayList[N];
            drops = new ArrayList[N];
            for (int i = 0;i < N; ++i) {
                children[i] = new ArrayList<Integer>(4);
                drops[i] = new ArrayList<Integer>(4);
            }
            for (var edge : edges) {
                int parent = edge[0] - 1, child = edge[1] - 1;
                children[parent].add(child);
            }
            for (int i = 0; i < children.length; ++i) {
                if (children[i].size() == 0)
                    isLeaf[i] = true;
                else
                    Collections.sort(children[i]);
            }
            int sum = Arrays.stream(target).sum();
            for (int d = 0; d < sum; ++d)
                drop(0, d);
            for (int i = 0; i < N; ++i)
                System.out.printf("%d %s\n", i+1, drops[i]);
            System.out.println();
            return null;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var edges = new int[][] {{2,4},{1,2},{6,8},{1,3},{5,7},{2,5},{3,6},{6,10},{6,9}};
        var target = new int[] {0,0,0,3,0,0,5,1,2,3};
        sol.solution(edges, target);
        edges = new int[][] {{1,2},{1,3}};
        target = new int[] {0,7,3};
        sol.solution(edges, target);
        edges = new int[][] {{1,3},{1,2}};
        target = new int[] {0,7,1};
        sol.solution(edges, target);
    }
}