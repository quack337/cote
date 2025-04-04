package programmers.p42891;

public class Test1 {

    static class Solution {

        int nextFood(int[] foods, int index) {
            for (int i = 0; i < foods.length; ++i) {
                index = (index < foods.length-1) ? index + 1 : 0;
                if (foods[index] > 0) return index;
            }
            return -1;
        }

        public int solution(int[] foods, long k) {
            int index = 0;
            for (long i = 0; i < k; ++i) {
                --foods[index];
                index = nextFood(foods, index);
                if (index == -1) return -1;
            }
            return index + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[] {3,1,2}, 5));
        System.out.println(new Solution().solution(new int[] {9,2,5,13,15}, 39));
    }

}