import java.util.*;

class Solution {
  public static int diff(String word1, String word2) {
    int count = 0;
    for (int i = 0; i < word1.length(); ++i)
      if (word1.charAt(i) != word2.charAt(i))
        ++count;
    return count;
  }

  static class Node {
    String word; int distance;
    public Node(String word, int distance) {
      this.word = word;
      this.distance = distance;
    }
  }

  public static int solution(String begin, String target, String[] words) {
    Queue<Node> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    queue.add(new Node(begin, 0));
    while (!queue.isEmpty()) {
      Node node = queue.remove();
      String current = node.word;
      int distance = node.distance;
      if (current.equals(target)) return distance;
      if (visited.contains(current)) continue;
      visited.add(current);
      for (String next : words)
        if (!visited.contains(next) && diff(current, next) == 1)
          queue.add(new Node(next, distance + 1));
    }
    return 0;
  }

  public static void main(String[] args) {
    System.out.println(solution("hit", "cog",
                    new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    System.out.println(solution("hit", "cog",
                    new String[]{"hot", "dot", "dog", "lot", "log"}));
  }
}
