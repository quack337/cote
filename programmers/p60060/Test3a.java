package programmers.p60060;
public class Test3a {

    static class Node {
        Node[] nodes;

        public void add(String word, int index) {
            if (index == word.length()) return;       // 인덱스가 범위를 벗어났다.
            if (nodes == null) nodes = new Node[26];  // 알파벳 숫자 만큼 자식 노드를 만든다
            int c = word.charAt(index) - 'a';         // word에서 index위치 문자가 'a' 이면 0 번째,
                                                      // 'b' 이면 1 번째, 'c' 이면 2 번째 자식 노드이어야 한다
            if (nodes[c] == null) nodes[c] = new Node(); // 그 자식 노드가 아직 없다면, 만든다
            nodes[c].add(word, index + 1);               // 자식 노드 재귀 호출
        }

        public void print(String s) {
            if (nodes != null) {                            // 아직 leaf 노드가 아니다.
                for (int i = 0; i < nodes.length; ++i)      // 자식 노드 재귀 호출 해야 한다
                    if (nodes[i] != null)
                        nodes[i].print(s + (char)('a' + i)); // 현재 노드의 문자를 더해서, 자식 노드 재귀호출
            } else // leaf
                System.out.println(s);  // leaf 이다. 단어가 하나 완성되었다.
        }
    }

    static Node root = new Node();

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        for (String word : words)
            root.add(word, 0);
        root.print("");
    }
}