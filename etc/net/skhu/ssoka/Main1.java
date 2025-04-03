package net.skhu.ssoka;

public class Main1 {

    static int[] _height, _width;
    static Node _root; // segment tree의 루트
    static int N; // 책의 수

    // segment tree의 노드
    static class Node {
        int minHeight, minIndex; // 구간에서 최소 높이 책의 높이와 index
        long width; // 구간의 넓이
        Node left, right;
    }

    // segment tree 만들기
    static Node createTree(int start, int end) {
        if (start > end) return new Node();
        if (start == end) {
            Node node = new Node();
            node.minHeight = _height[start];
            node.minIndex = start;
            node.width = _width[start];
            return node;
        }
        int middle = (start + end) / 2;
        Node node = new Node();
        node.left = createTree(start, middle);
        node.right = createTree(middle + 1, end);
        node.minHeight = Math.min(node.left.minHeight, node.right.minHeight);
        node.minIndex = (node.minHeight == node.left.minHeight) ? node.left.minIndex : node.right.minIndex;
        node.width = node.left.width + node.right.width;
        return node;
    }

    // segment tree 알고리즘: 구간에서 최소 높이를 찾는다
    static int[] findMin(Node node, int start, int end, int from, int to) {
        if (start == from && end == to) return new int[] {node.minHeight, node.minIndex};
        int middle = (start + end) / 2;
        if (to <= middle) return findMin(node.left, start, middle, from, to);
        else if (middle + 1 <= from) return findMin(node.right, middle + 1, end, from, to);
        int[] min1 = findMin(node.left, start, middle, from, middle);
        int[] min2 = findMin(node.right, middle + 1, end, middle + 1, to);
        if (min1[0] < min2[0]) return min1;
        if (min1[0] > min2[0]) return min2;
        int i1 = min1[1], i2 = min2[1];
        return _width[i1] < _width[i2] ? min1 : min2;
    }

    // segment tree 알고리즘: 구간의 넓이를 찾는다
    static long findWidth(Node node, int start, int end, int from, int to) {
        if (start == from && end == to) return node.width;
        int middle = (start + end) / 2;
        if (to <= middle) return findWidth(node.left, start, middle, from, to);
        else if (middle + 1 <= from) return findWidth(node.right, middle + 1, end, from, to);
        long width1 = findWidth(node.left, start, middle, from, middle);
        long width2 = findWidth(node.right, middle + 1, end, middle + 1, to);
        return width1 + width2;
    }

    static void removeBook(Node node, int index, int start, int end) {
        if (start == end) {
            node.minHeight = Integer.MAX_VALUE;
            node.width = 0;
        } else {
            int middle = (start + end) / 2;
            if (index <= middle) removeBook(node.left, index, start, middle);
            else removeBook(node.right, index, middle + 1, end);
            Node minChild = null;
            if (node.left.minHeight < node.right.minHeight)
                minChild = node.left;
            else if (node.left.minHeight > node.right.minHeight)
                minChild = node.right;
            else {
                int i1 = node.left.minIndex, i2 = node.right.minIndex;
                minChild = _width[i1] < _width[i2] ? node.left : node.right;
            }
            node.minHeight = minChild.minHeight;
            node.minIndex = minChild.minIndex;
            node.width = node.left.width + node.right.width;
        }
    }

    static long 최대면적찾기(int from, int to) {
        if (from > to) return 0;
        int[] min = findMin(_root, 0, N-1, from, to);
        long width = findWidth(_root, 0, N-1, from, to);
        int minHeight = min[0], minIndex = min[1];
        long 면적1 = minHeight * width;
        long 면적2 = 최대면적찾기(from, minIndex - 1);
        long 면적3 = 최대면적찾기(minIndex + 1, to);
        return Math.max(면적1, Math.max(면적2, 면적3));
    }

    static long solution(int[] height, int[] width) {
        N = height.length;
        _height = height;
        _width = width;
        _root = createTree(0, N-1);
        long maxAnswer = 0;
        while (true) {
            long answer = 최대면적찾기(0, N-1);
            if (answer < maxAnswer) break;
            if (answer > maxAnswer) maxAnswer = answer;
            int[] min = findMin(_root, 0, N-1, 0, N-1);
            removeBook(_root, min[1], 0, N-1);
        }
        return maxAnswer;
    }

    public static void main(String[] args) {
        int[] height = new int[] {140, 21, 21, 32};
        int[] width = new int[] {2, 1, 3, 7};
        System.out.println(solution(height, width)); // 288

        height = new int[] {10};
        width = new int[] {2};
        System.out.println(solution(height, width)); // 20

        height = new int[] {10, 20};
        width = new int[] {2, 3};
        System.out.println(solution(height, width)); // 60

        height = new int[] {10, 20, 10};
        width = new int[] {2, 3, 2};
        System.out.println(solution(height, width)); // 70

        height = new int[] {10, 20, 2, 10};
        width = new int[] {2, 3, 2, 2};
        System.out.println(solution(height, width)); // 70

        height = new int[] {10, 2, 20, 2, 10};
        width = new int[] {2, 3, 3, 2, 2};
        System.out.println(solution(height, width)); // 70
    }

}