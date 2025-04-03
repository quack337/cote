package programmers.e81305;

public class Test2b {

    static class Solution {
        static class Node {
            int value, left, right;

            public Node(int value, int left, int right) {
                this.value = value;
                this.left = left;
                this.right = right;
            }
        }

        Node[] nodes; int root;

        void createTree(int k, int[] num, int[][] links) {
            nodes = new Node[num.length];
            boolean[] hasParent = new boolean[num.length];
            for (int i = 0; i < num.length; ++i) {
                nodes[i] = new Node(num[i], links[i][0], links[i][1]);
                if (links[i][0] >= 0) hasParent[links[i][0]] = true;
                if (links[i][1] >= 0) hasParent[links[i][1]] = true;
            }
            for (root = 0; root < num.length; ++root)
                if (hasParent[root] == false) break;
        }

        int answer, groupMax;

        int sum(int index, boolean[] selected) {
            if (index == -1) return 0;
            Node node = nodes[index];
            int value = node.value + sum(node.left, selected) + sum(node.right, selected);
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

        public int solution(int k, int[] num, int[][] links) {
            answer = Integer.MAX_VALUE;
            createTree(k, num, links);
            solution(new boolean[num.length], 0, 0, k);
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