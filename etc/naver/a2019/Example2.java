package net.skhu.naver.a2019;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Example2 {

    static class Tree {
        int x;
        Tree l, r;
        public Tree(int x, Tree l, Tree r) {
            this.x = x;
            this.l = l;
            this.r = r;
        }
    }

    static class Solution {
        int max = Integer.MIN_VALUE;

        void 탐색(Tree node, Stack<Integer> 경로) {
            if (node == null) { // 리프 노드에 도착 했으면
                Set<Integer> set = new HashSet<>();
                set.addAll(경로);
                int size = set.size(); // 경로에서 고유한 값들의 수 구하기
                if (size > max) max = size;
                return;
            }
            경로.push(node.x);  // 경로에 현재노드 값 추가
            탐색(node.l, 경로); // 재귀호출
            탐색(node.r, 경로); // 재귀호출
            경로.pop(); // 현재 노드에서 리턴하면서, 경로에서도 현재노드 값 제거
        }

        public int solution(Tree node) {
            if (node == null) return 0;
            탐색(node, new Stack<Integer>());
            return max;
        }
    }

    public static void main(String[] args) {
        Tree g = new Tree(5, null, null); // 문제 그림의 트리 구현
        Tree d = new Tree(4, g, null);
        Tree b = new Tree(5, d, null);
        Tree e = new Tree(1, null, null);
        Tree f = new Tree(6, null, null);
        Tree c = new Tree(6, e, f);
        Tree a = new Tree(4, b, c);
        Solution s = new Solution();
        System.out.println(s.solution(a));
    }
}
