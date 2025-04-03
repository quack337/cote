package programmers.e60060;

import java.util.Arrays;

public class Test4 {

static class Solution {

    static class Node {
        int count = 0;
        Node[] nodes = null;

        public void add(String word, int index) {
            ++count;
            if (index == word.length()) return;
            if (nodes == null) nodes = new Node[26];
            int j = word.charAt(index) - 'a';
            if (nodes[j] == null) nodes[j] = new Node();
            nodes[j].add(word, index + 1);
        }

        public int count(String query, int index) {
            if (nodes == null) return count;
            char ch = query.charAt(index);
            if (ch == '?') return count;
            Node node = nodes[ch - 'a'];
            if (node == null) return 0;
            return node.count(query, index + 1);
        }
    }

    Node[] roots1 = new Node[10000], roots2 = new Node[10000];

    String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    void createTree(String[] words) {
        for (String word : words) {
            int i = word.length() - 1;
            if (roots1[i] == null) roots1[i] = new Node();
            if (roots2[i] == null) roots2[i] = new Node();
            roots1[i].add(word, 0);
            roots2[i].add(reverse(word), 0);
        }
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        createTree(words);
        for (int i = 0; i < queries.length; ++i) {
            String query = queries[i];
            int j = query.length() - 1;
            if (roots1[j] == null) continue;
            if (query.charAt(0) != '?')
                answer[i] = roots1[j].count(query, 0);
            else
                answer[i] = roots2[j].count(reverse(query), 0);
        }
        return answer;
    }
}

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?", "?????"};
        System.out.println(Arrays.toString(new Solution().solution(words, queries)));
    }
}