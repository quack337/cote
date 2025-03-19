package net.skhu.kakao.t2020.ex4;

public class Test3c {

    static class Node {
        int count;
        Node[] nodes;

        public void add(String word, int index) {
            ++count;
            if (index == word.length()) return;
            if (nodes == null) nodes = new Node[26];
            int c = word.charAt(index) - 'a';
            if (nodes[c] == null) nodes[c] = new Node();
            nodes[c].add(word, index + 1);
        }

        public void print(String s) {
            if (nodes != null) {
                for (int i = 0; i < nodes.length; ++i)
                    if (nodes[i] != null)
                        nodes[i].print(s + (char)('a' + i));
                System.out.printf("중간: %s %d\n", s, count);
            } else // leaf
                System.out.println("leaf: " + s);
        }
    }

    static Node[] roots = new Node[10000];  // 최대 단어 길이 10000, 인덱스 번위는 0 ~ 9999
                                            // 단어 길이 마다 trie 트리를 따로 만든다
    static void add(String word) {
        int i = word.length() - 1;  // 단어 길이 - 1 을 인덱스로 한다 (0 ~ 9999)
        if (roots[i] == null) roots[i] = new Node(); // 그 위치에 trie 루트 노드가 없다면 만든다

        roots[i].add(word, 0); // 그 trie에 단어를 추가한다
    }

    static void print() {
        for (Node root : roots)
            if (root != null) root.print("");
    }

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        for (String word : words)
            add(word);
        print();
    }
}
