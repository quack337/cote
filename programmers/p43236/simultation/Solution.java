package programmers.p43236.simultation;
import java.util.TreeSet;

class Solution {
  class Node { int value, index; Node next, prev; }
  Node dummy;
  TreeSet<Node> tree;

  void init() {
    dummy = new Node();
    dummy.value = Integer.MAX_VALUE;
    dummy.prev = dummy.next = dummy;
    tree = new TreeSet<>((a, b) -> a.value != b.value ? a.value - b.value : a.index - b.index);
  }

  void addNode(int value, int index) {
    var node = new Node();
    node.value = value;
    node.index = index;
    node.prev = dummy.prev;
    node.next = dummy;
    dummy.prev = node.prev.next = node;
  }

  void removeNode(Node node) {
    Node a = node.prev, b = node.next;
    a.next = b;
    b.prev = a;
  }

  void print() {
    System.out.print(" ");
    for (Node n = dummy.next; n != dummy; n = n.next)
      System.out.print(n.value + " ");
    System.out.println();
  }

  public int solution(int distance, int[] rocks, int n) {
    init();
    java.util.Arrays.sort(rocks);
    for (int i = 0; i < rocks.length; ++i) {
      addNode(rocks[i] - (i == 0 ? 0 : rocks[i - 1]), i);
      tree.add(dummy.prev);
    }
    addNode(distance - rocks[rocks.length - 1], rocks.length);
    tree.add(dummy.prev);
    for (int i = 0; i < n; ++i) {
      var a = tree.first();
      var b = a.prev.value < a.next.value ? a.prev : a.next;
      tree.remove(a);
      tree.remove(b);
      b.value += a.value;
      tree.add(b);
      removeNode(a);
    }
    while (tree.first().value == 0)
      tree.remove(tree.first());
    return tree.first().value;
  }

}