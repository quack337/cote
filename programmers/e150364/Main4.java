package programmers.e150364;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main4 {

    @SuppressWarnings("unchecked")
    static class Solution {
        int N, leafCount, validLeafCount;
        int[] target, link;;
        boolean[] isLeaf, isValidLeaf;
        ArrayList<Integer>[] children, drops;
        static ArrayList<Integer>[][] DP;

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

        void drop(int index, int dropNo) {
            if (isLeaf[index]) {
                drops[index].add(dropNo);
                if (isValidLeaf[index]) {
                    isValidLeaf[index] = false;
                    --validLeafCount;
                }
                if (DP[drops[index].size()][target[index]] != null) {
                    isValidLeaf[index] = true;
                    ++validLeafCount;
                }
            } else {
                drop(children[index].get(link[index]), dropNo);
                link[index] = (link[index] + 1) % children[index].size();
            }
        }

        public int[] solution(int[][] edges, int[] target) {
            N = edges.length + 1;
            this.target = target;
            link = new int[N];
            isLeaf = new boolean[N];
            isValidLeaf = new boolean[N];
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
            validLeafCount = leafCount = 0;
            for (int i = 0; i < children.length; ++i) {
                if (children[i].size() == 0) {
                    isLeaf[i] = true;
                    ++leafCount;
                } else
                    Collections.sort(children[i]);
            }
            DP = new ArrayList[101][101];
            DP[0][0] = new ArrayList<Integer>();
            createDP(0, 0);

            int sum = Arrays.stream(target).sum();
            for (int d = 0; d < sum; ++d) {
                drop(0, d);
                if (validLeafCount == leafCount) {
                    int[] answer = new int[d + 1];
                    for (int i = 0; i < N; ++i) {
                        int count = drops[i].size();
                        var cardList = DP[count][target[i]];
                        for (int j = 0; j < count; ++j) {
                            int cardValue = cardList.get(j);
                            int index = drops[i].get(j);
                            answer[index] = cardValue;
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
