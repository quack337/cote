package programmers.e150364;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main6 {
    @SuppressWarnings("unchecked")
    static class Solution {
        int[] target, link;;
        ArrayList<Integer>[] children, drops;
        ArrayList<Integer>[][] DP = new ArrayList[101][101];

        void createDP(int count, int target) {
            for (int i = 1; i <= 3; ++i) {
                if (target + i > 100) continue;
                if (DP[count + 1][target + i] != null) continue;
                var list = new ArrayList<Integer>(DP[count][target]);
                list.add(i);
                DP[count + 1][target + i] = list;
                createDP(count + 1, target + i);
            }
        }

        void drop(int node, int dropNo) {
            if (children[node].size() == 0)
                drops[node].add(dropNo);
            else {
                drop(children[node].get(link[node]), dropNo);
                link[node] = (link[node] + 1) % children[node].size();
            }
        }

        boolean success() {
            for (int i = 0; i < children.length; ++i)
                if (children[i].size() == 0)
                    if (DP[drops[i].size()][target[i]] == null) return false;
            return true;
        }

        public int[] solution(int[][] edges, int[] target) {
            int N = edges.length + 1;
            this.target = target;
            link = new int[N];
            children = new ArrayList[N];
            drops = new ArrayList[N];
            for (int i = 0;i < N; ++i) {
                children[i] = new ArrayList<Integer>(4);
                drops[i] = new ArrayList<Integer>(4);
            }
            for (var edge : edges)
                children[edge[0] - 1].add(edge[1] - 1);
            for (int i = 0; i < children.length; ++i)
                Collections.sort(children[i]);
            DP[0][0] = new ArrayList<Integer>();
            createDP(0, 0);
            int sum = Arrays.stream(target).sum();
            for (int d = 0; d < sum; ++d) {
                drop(0, d);
                if (success()) {
                    int[] answer = new int[d + 1];
                    for (int i = 0; i < N; ++i) {
                        int count = drops[i].size();
                        var cardList = DP[count][target[i]];
                        for (int j = 0; j < count; ++j) {
                            int index = drops[i].get(j);
                            answer[index] = cardList.get(j);
                        }
                    }
                    return answer;
                }
            }
            return new int[] { -1 };
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var edges = new int[][] {{2,4},{1,2},{6,8},{1,3},{5,7},{2,5},{3,6},{6,10},{6,9}};
        var target = new int[] {0,0,0,3,0,0,5,1,2,3};
        System.out.println(Arrays.toString(sol.solution(edges, target)));
        edges = new int[][] {{1,2},{1,3}};
        target = new int[] {0,7,3};
        System.out.println(Arrays.toString(sol.solution(edges, target)));
        edges = new int[][] {{1,3},{1,2}};
        target = new int[] {0,7,1};
        System.out.println(Arrays.toString(sol.solution(edges, target)));

        edges = new int[][] {{1,2},{1,3}};
        target = new int[] {0,0,1};
        System.out.println(Arrays.toString(sol.solution(edges, target)));
        edges = new int[][] {{1,2},{1,3}};
        target = new int[] {0,1,0};
        System.out.println(Arrays.toString(sol.solution(edges, target)));
    }
}
