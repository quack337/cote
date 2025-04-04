package programmers.p42839;

import java.util.Arrays;

public class Main1 {

    static class Solution {

        int[] getDigitCount(String s) {
            var count = new int[10];
            for (int i = 0; i < s.length(); ++i)
                count[s.charAt(i) - '0']++;
            return count;
        }

        boolean compare(int[] a, int[] b) {
            for (int i = 0; i < a.length; ++i)
                if (a[i] > b[i]) return false;
            return true;
        }

        public int solution(String numbers) {
            int N = (int)Math.pow(10, numbers.length());
            var prime = new boolean[N];
            Arrays.fill(prime, true);
            prime[0] = prime[1] = false;
            for (int i = 2; i <= Math.sqrt(prime.length); ++i)
                if (prime[i])
                    for (int j = i + i; j < prime.length; j += i)
                        prime[j] = false;
            int answer = 0;
            int[] count1 = getDigitCount(numbers);
            for (int i = 2; i < prime.length; ++i)
                if (prime[i] && compare(getDigitCount(String.valueOf(i)), count1))
                    ++answer;
            return answer;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution("17"));
        System.out.println(sol.solution("011"));
    }
}