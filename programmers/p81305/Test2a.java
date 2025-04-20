package programmers.p81305;
public class Test2a {

    static class Solution {
        int[] values; int[][] links; int root;
        int answer, groupMax;

        void findRoot() {
            boolean[] hasParent = new boolean[links.length];
            for (int i = 0; i < links.length; ++i) {
                if (links[i][0] >= 0) hasParent[links[i][0]] = true;
                if (links[i][1] >= 0) hasParent[links[i][1]] = true;
            }
            for (root = 0; root < links.length; ++root)
                if (hasParent[root] == false) break;
        }

        int sum(int index, boolean[] selected) {
            if (index == -1) return 0;
            int value = values[index] + sum(links[index][0], selected) + sum(links[index][1], selected);
            if (index == root || selected[index]) {
                groupMax = Math.max(groupMax, value);
                return 0;
            }
            return value;
        }

        void solution(boolean[] selected, int selectedCount, int index, int k) {
            if (selectedCount == k - 1) {
                groupMax = 0;
                sum(root, selected);
                answer = Math.min(answer, groupMax);
            }
            if (index == selected.length) return;
            solution(selected, selectedCount, index + 1, k);

            boolean[] selected1 = selected.clone();
            selected1[index] = true;
            solution(selected1, selectedCount + 1, index + 1, k);
        }

        public int solution(int k, int[] values, int[][] links) {
            this.values = values;
            this.links = links;
            findRoot();
            answer = Integer.MAX_VALUE;
            solution(new boolean[values.length], 0, 0, k);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int answer = sol.solution(3, new int[] {12,30,1,8,8,6,20,7,5,10,4,1},
                         new int[][] {{-1,-1},{-1,-1},{-1,-1},{-1,-1},{8,5},{2,10},{3,0},
                                      {6,1},{11,-1},{7,4},{-1,-1},{-1,-1}});
        System.out.println(answer);
        answer = sol.solution(1, new int[] {6,9,7,5}, new int[][] {{-1,-1}, {-1,-1}, {-1,0}, {2,1}});
        System.out.println(answer);
        answer = sol.solution(2, new int[] {6,9,7,5}, new int[][] {{-1,-1}, {-1,-1}, {-1,0}, {2,1}});
        System.out.println(answer);
        answer = sol.solution(4, new int[] {6,9,7,5}, new int[][] {{-1,-1}, {-1,-1}, {-1,0}, {2,1}});
        System.out.println(answer);
    }
}