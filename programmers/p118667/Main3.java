package programmers.p118667;

import java.util.Arrays;

public class Main3 {

    static class Solution {

        public int solution(int[] queue1, int[] queue2) {
            int[] A = new int[queue1.length + queue2.length];
            System.arraycopy(queue1, 0, A, 0, queue1.length);
            System.arraycopy(queue2, 0, A, queue1.length, queue2.length);
            long 전체합계 = Arrays.stream(A).mapToLong(i -> i).sum();
            if (전체합계 % 2 == 1) return -1;
            int index1 = 0, index2 = queue1.length, 작업횟수 = 0;
            long 큐1합계 = Arrays.stream(queue1).mapToLong(i -> i).sum();
            while (true) {
                if (큐1합계 == 전체합계/2) return 작업횟수;
                else if (큐1합계 < 전체합계/2) {
                    큐1합계 += A[index2];
                    index2 = (index2 + 1) % A.length;
                }
                else if (큐1합계 > 전체합계/2) {
                    큐1합계 -= A[index1];
                    index1 = (index1 + 1) % A.length;
                }
                ++작업횟수;
                if (작업횟수 > A.length * 2) return -1;
            }
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.solution(new int[] {3,2,7,2}, new int[] {4,6,5,1}));
        System.out.println(s.solution(new int[] {1,2,1,2}, new int[] {1,10,1,2}));
        System.out.println(s.solution(new int[] {1,1}, new int[] {1,5}));

        System.out.println(s.solution(new int[] {1}, new int[] {1}));
        System.out.println(s.solution(new int[] {1}, new int[] {3}));
    }

}