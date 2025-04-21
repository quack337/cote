package programmers.p42626;
import java.util.PriorityQueue;

public class Main {

    static class Solution {
        public int solution(int[] scoville, int K) {
            var minHeap = new PriorityQueue<Integer>();
            for (int i : scoville) minHeap.add(i);
            while (minHeap.peek() < K) {
                if (minHeap.size() < 2) return -1;
                minHeap.add(minHeap.remove() + minHeap.remove() * 2);
            }
            return scoville.length - minHeap.size();
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.solution(new int[] {1,2,3,9,10,12}, 7));
    }
}