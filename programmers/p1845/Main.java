package programmers.p1845;
public class Main {

    static class Solution {
        public int solution(int[] nums) {
            var set = new java.util.HashSet<Integer>();
            for (int num : nums)
                set.add(num);
            return Math.min(nums.length / 2, set.size());
        }
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).solution(new int[]{3, 1, 2, 3})); // 2
        System.out.println((new Solution()).solution(new int[]{3, 3, 3, 2, 2, 4})); // 3
        System.out.println((new Solution()).solution(new int[]{3, 3, 3, 2, 2, 2})); // 2
    }
}