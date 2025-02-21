import java.util.Arrays;

public class Main2 {

    static class Solution {

        int n;
        boolean[] isPrimeNumber;

        void excludeMultiples(int value) {
            for (int i = value * 2; i <= n; i += value)
                isPrimeNumber[i] = false;
        }

        int getCount() {
            int count = 0;
            for (int i = 2; i <= n; ++i)
                if (isPrimeNumber[i]) ++count;
            return count;
        }

        public int solution(int n) {
            this.n = n;
            isPrimeNumber = new boolean[n + 1];
            isPrimeNumber[1] = isPrimeNumber[0] = false;
            Arrays.fill(isPrimeNumber, true);
            for (int i = 2; i <= n/2; ++i) {
                if (isPrimeNumber[i])
                    excludeMultiples(i);
            }
            return getCount();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(10));
        System.out.println(sol.solution(5));
        System.out.println(sol.solution(2));
    }

}