package programmers.p42626;

import java.util.PriorityQueue;

public class Main {

    static class Solution {
        public int solution(int[] scoville, int K) {
            var queue = new PriorityQueue<Integer>();
            for (int i : scoville) queue.add(i);
            while (queue.peek() < K) {
                if (queue.size() < 2) return -1;
                queue.add(queue.remove() + queue.remove() * 2);
            }
            return scoville.length - queue.size();
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.solution(new int[] {1,2,3,9,10,12}, 7));
    }

}