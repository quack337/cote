package programmers.p42628;
import java.util.PriorityQueue;

public class Solution2 {

  public int[] solution(String[] operations) {
    var minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
    var maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    for (String op : operations) {
      if (op.charAt(0) == 'I') {
        int i = Integer.parseInt(op.substring(2));
        minHeap.add(i); maxHeap.add(i);
      } else {
        if (minHeap.size() == 0) continue;
        if (op.charAt(2) == '-')
          maxHeap.remove(minHeap.remove());
        else
          minHeap.remove(maxHeap.remove());
      }
    }
    if (minHeap.size() == 0) return new int[] {0,0};
    return new int[] {maxHeap.peek(), minHeap.peek()};
  }

  public static void main(String[] args) {
    var sol = new Solution2();
    System.out.println(java.util.Arrays.toString(sol.solution(
      new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
      System.out.println(java.util.Arrays.toString(sol.solution(
        new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}