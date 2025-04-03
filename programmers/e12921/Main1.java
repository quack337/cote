package programmers.e12921;

public class Main1 {

    static class Solution {

        boolean isPrimeNumber(int value) {
            if (value == 1) return false;
            if (value == 2) return true;
            double limit = Math.sqrt(value);
            for (int i = 2; i <= limit; ++i)
                if (value % i == 0) return false;
            return true;
        }

        public int solution(int n) {
            int count = 0;
            for (int i = 2; i <= n; ++i)
                if (isPrimeNumber(i)) ++count;
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10));
        System.out.println(sol.solution(5));
        System.out.println(sol.solution(2));
    }

}