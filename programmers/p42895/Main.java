package programmers.p42895;

import java.util.HashSet;

@SuppressWarnings("unchecked")
public class Main {

    static class Solution {
        HashSet<Integer>[] DP = new HashSet[8 + 1];

        public int solution(int N, int number) {
            if (N == number) return 1;
            DP[1] = new HashSet<Integer>();
            DP[1].add(N);
            int NN = N;
            for (int i = 2; i <= 8; ++i) {
                DP[i] = new HashSet<Integer>();
                NN = NN * 10 + N;
                DP[i].add(NN);
                for (int j = 1; j < i; ++j) {
                    var DP1 = DP[j];
                    var DP2 = DP[i - j];
                    for (int value1 : DP1) {
                        for (int value2 : DP2) {
                            DP[i].add(value1 + value2);
                            DP[i].add(value1 - value2);
                            DP[i].add(value1 * value2);
                            if (value2 != 0) DP[i].add(value1 / value2);
                        }
                        if (DP[i].contains(number)) return i;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, 12));
        System.out.println(sol.solution(2, 11));
    }
}