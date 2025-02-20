package baekjoon.p01.p1725;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.Scanner;

public class Main2 {
    static class Node {
        int value, index;
        Node left, right;
    }

    static Node createTree(int[] a, int start, int end) {
        if (start > end) return new Node();
        if (start == end) {
            Node node = new Node();
            node.value = a[start];
            node.index = start;
            return node;
        }
        int middle = (start + end) / 2;
        Node node = new Node();
        node.left = createTree(a, start, middle);
        node.right = createTree(a, middle + 1, end);
        node.value = min(node.left.value, node.right.value);
        node.index = (node.value == node.left.value) ? node.left.index : node.right.index;
        return node;
    }

    static int[] findMin(Node node, int start, int end, int from, int to) {
        if (start == from && end == to) return new int[] {node.value, node.index};
        int middle = (start + end) / 2;
        if (to <= middle) return findMin(node.left, start, middle, from, to);
        else if (middle + 1 <= from) return findMin(node.right, middle + 1, end, from, to);
        int[] min1 = findMin(node.left, start, middle, from, middle);
        int[] min2 = findMin(node.right, middle + 1, end, middle + 1, to);
        return min1[0] < min2[0] ? min1 : min2;
    }

    static Node root;
    static int N;

    static int solution(int from, int to) {
        if (from > to) return 0;
        int[] min = findMin(root, 0, N-1, from, to);
        int value = min[0], index = min[1];
        int 면적1 = value * (to - from + 1);
        int 면적2 = solution(from, index - 1);
        int 면적3 = solution(index + 1, to);
        return max(면적1, max(면적2, 면적3));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; ++i)
            A[i] = scanner.nextInt();
        scanner.close();
        root = createTree(A, 0, N-1);
        System.out.println(solution(0, N-1));
    }
}
