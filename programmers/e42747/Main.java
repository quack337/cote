package programmers.e42747;

import java.util.Arrays;

public class Main {
    static class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);
            for (int i = 0; i < citations.length; ++i)
                if (citations.length - i <= citations[i])
                    return citations.length - i;
            return 0;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(new int[] {3,0,6,1,5}));
        System.out.println(sol.solution(new int[] {3,3}));
    }
}
