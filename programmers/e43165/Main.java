public class Main {
    static class Solution {

        int sol(int[] numbers, int target, int index, int sum) {
            if (index == numbers.length) return sum == target ? 1 : 0;
            int answer = 0;
            answer += sol(numbers, target, index + 1, sum + numbers[index]);
            answer += sol(numbers, target, index + 1, sum - numbers[index]);
            return answer;
        }

        public int solution(int[] numbers, int target) {
            return sol(numbers, target, 0, 0);
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(new int[]{1,1,1,1,1}, 3));
        System.out.println(sol.solution(new int[]{4,1,2,1}, 4));
    }
}