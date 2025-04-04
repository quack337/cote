package programmers.p92343;

import java.util.ArrayList;

public class Main1 {
    static class Solution {
        static final int 양 = 0, 늑대 = 1;
        Node[] nodes;

        static class Node {
            int animal;
            Node left, right;
        }

        void createTree(int[] info, int[][] edges) {
            nodes = new Node[info.length];
            for (int i = 0; i < info.length; ++i) {
                nodes[i] = new Node();
                nodes[i].animal = info[i];
            }
            for (int[] e : edges) {
                Node parent = nodes[e[0]], child = nodes[e[1]];
                if (parent.left == null) parent.left = child;
                else parent.right = child;
            }
        }

        void 노드방문DFS(Node node, ArrayList<Node> 늑대노드목록, int[] 동행) {
            동행[node.animal]++;
            if (node.left != null) {
                if (node.left.animal == 양) 노드방문DFS(node.left, 늑대노드목록, 동행);
                else 늑대노드목록.add(node.left);
            }
            if (node.right != null) {
                if (node.right.animal == 양) 노드방문DFS(node.right, 늑대노드목록, 동행);
                else 늑대노드목록.add(node.right);
            }
        }

        int solution(Node node, ArrayList<Node> 늑대노드목록, int[] 동행) {
            노드방문DFS(node, 늑대노드목록, 동행);
            int 최대 = 동행[양];
            if (동행[양] > 동행[늑대] + 1)
                for (int i = 0; i < 늑대노드목록.size(); ++i) {
                    var 늑대노드목록1 = new ArrayList<Node>(늑대노드목록);
                    var node1 = 늑대노드목록1.get(i);
                    늑대노드목록1.remove(i);
                    int 결과 = solution(node1, 늑대노드목록1, 동행.clone());
                    if (결과 > 최대) 최대 = 결과;
                }
            return 최대;
        }

        public int solution(int[] info, int[][] edges) {
            createTree(info, edges);
            return solution(nodes[0], new ArrayList<Node>(), new int[2]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] info1 = {0,0,1,1,1,0,1,0,1,0,1,1};
        int[][] edges1 = {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}};
        System.out.println(sol.solution(info1, edges1));

        int[] info2 = {0,1,0,1,1,0,1,0,0,1,0};
        int[][] edges2 = {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}};
        System.out.println(sol.solution(info2, edges2));

        int[] info3 = {0,0};
        int[][] edges3 = {{0,1}};
        System.out.println(sol.solution(info3, edges3));
    }

}