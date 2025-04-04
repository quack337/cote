package programmers.p381364;

public class Main1 {

    static class Solution {

        int 비트1갯수(int value) {
            int result = 0;
            while (value > 0) {
                int 나머지 = value % 2;
                int 몫 = value / 2;
                if (나머지 == 1) ++result;
                value = 몫;
            }
            return result;
        }

        public int solution(int n) {
            int count1 = 비트1갯수(n);
            for (int i = n + 1; i <= Integer.MAX_VALUE; ++i)
                if (count1 == 비트1갯수(i))
                    return i;
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        System.out.println(s.solution(78));
        System.out.println(s.solution(15));
    }

}