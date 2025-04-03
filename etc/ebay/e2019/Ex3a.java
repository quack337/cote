package ebay.e2019;

class Node {
    int value;
    Node left, right;

    public Node(int value) {
        this.value = value;
    }
};

public class Ex3a {
    static int[] a;
    static int index = 0;

    static Node createTree() throws Exception {
        if (index >= a.length) throw new Exception(); // 입력 배열의 값이 모자라면 실패.
        int value = a[index++];
        Node node = new Node(value);
        if (value != -1) {
            node.left = createTree();
            node.right = createTree();
        }
        return node;
    }

    static void preorder(Node node) {
        if (node == null) return;
        System.out.printf("%d ", node.value);
        preorder(node.left);
        preorder(node.right);
    }

    static boolean solution(int[] A) {
        try {
            a = A;
            index = 0;
            Node root = createTree();
            preorder(root);
            return index == a.length; // 입력 배열의 값이 남아도 실패
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {-1}));
        System.out.println(solution(new int[] {3,5,6,8, -1,-1,-1, 1,7, -1,-1,-1, 4, -1, 2, -1,-1}));
        System.out.println(solution(new int[] {1, -1, 2, -1, -1, 3, -1, -1}));
        System.out.println(solution(new int[] {1, -1, 2, -1}));
    }

}
