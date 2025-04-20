package programmers.p42628;
// 정답

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution1 {
  PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
  PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
  HashMap<Integer, Integer> map = new HashMap<>();

  void removeGhost() {
    while (map.containsKey(maxHeap.peek()) == false)
      maxHeap.remove();
    while (map.containsKey(minHeap.peek()) == false)
      minHeap.remove();    
  }

  public int[] solution(String[] operations) {
    for (String op : operations) {
      if (op.charAt(0) == 'I') {
        int i = Integer.parseInt(op.substring(2));
        if (map.containsKey(i))
          map.put(i, 1 + map.get(i));
        else {
          map.put(i, 1);
          minHeap.add(i); maxHeap.add(i);
        } 
      } else {
        if (map.size() == 0) continue;
        removeGhost();
        if (op.charAt(2) == '-') {
          int i = minHeap.peek();
          if (map.get(i) == 1) {
            map.remove(i);
            minHeap.remove();
          } else
            map.put(i, map.get(i) - 1);
        } else {
          int i = maxHeap.peek();
          if (map.get(i) == 1) {
            map.remove(i);
            maxHeap.remove();
          } else
            map.put(i, map.get(i) - 1);
        }
      }
    }
    if (map.size() == 0) return new int[] {0,0};
    removeGhost();
    return new int[] {maxHeap.peek(), minHeap.peek()};
  }

  public static void main(String[] args) {
    var sol = new Solution1();
    System.out.println(java.util.Arrays.toString(sol.solution(
      new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
      System.out.println(java.util.Arrays.toString(sol.solution(
        new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }
}