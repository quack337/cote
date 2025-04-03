package programmers.e92335;

public class Main1 {

    static class Solution {

        String K진수(int value, int k) {
            var builder = new StringBuilder();
            while (value > 0) {
                builder.append((char)('0' + (value % k)));
                value = value / k;
            }
            return builder.reverse().toString();
        }

        boolean 소수인가(int n) {
            if (n == 1) return false;
            double limit = Math.sqrt(n);
            for (int i = 2; i <= limit; ++i)
                if (n % i == 0) return false;
            return true;
        }

        public int solution(int value, int k) {
            int answer = 0;
            String s = K진수(value, k);
            String[] a = s.split("0+");
            for (String t : a) {
                int i = Integer.valueOf(t);
                if (소수인가(i)) ++answer;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(437674, 3));
        System.out.println(sol.solution(110011, 10));
    }

}