package programmers.p42892;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {

    static class Solution {
        static class Node {
            int x, y, no;
            Node left, right;

            public Node(int no, int x, int y) {
                this.no = no;
                this.x = x;
                this.y = y;
            }

            public void preorder(List<Integer> result) {
                result.add(no);
                if (left != null) left.preorder(result);
                if (right != null) right.preorder(result);
            }

            public void postorder(List<Integer> result) {
                if (left != null) left.postorder(result);
                if (right != null) right.postorder(result);
                result.add(no);
            }
        }

        Node findTopNode(List<Node> nodes) {
            Node top = nodes.get(0);
            for (Node node : nodes)
                if (node.y > top.y) top = node;
            return top;
        }

        Node createTree(List<Node> nodes) {
             if (nodes.size() == 0) return null;
             Node root = findTopNode(nodes);
             var leftNodes = new ArrayList<Node>();
             var rightNodes = new ArrayList<Node>();
             for (Node node : nodes)
                 if (node.x < root.x) leftNodes.add(node);
                 else if (node.x > root.x) rightNodes.add(node);
             root.left = createTree(leftNodes);
             root.right = createTree(rightNodes);
             return root;
        }

        public int[][] solution(int[][] nodeinfo) {
            var nodes = new ArrayList<Node>();
            for (int i = 0; i < nodeinfo.length; ++i)
                nodes.add(new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]));
            Node root = createTree(nodes);
            var result1 = new ArrayList<Integer>();
            var result2 = new ArrayList<Integer>();
            root.preorder(result1);
            root.postorder(result2);
            return new int[][] { result1.stream().mapToInt(i->i).toArray(),
                                 result2.stream().mapToInt(i->i).toArray() };
        }
    }

    public static void main(String[] args) {
        int[][] a = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        System.out.println(Arrays.deepToString(new Solution().solution(a)));
    }
}