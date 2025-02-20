package net.skhu.naver.a2019;

public class Example1 {

    static class Solution {
        int 필요한_회전수(int 시작숫자, int 목표숫자) {
            if (시작숫자 == 목표숫자) return 0;
            return (시작숫자 + 목표숫자 == 7) ? 2 : 1;
        }

        int 필요한_회전수_합계(int[] 주사위배열, int 목표숫자) {
            int 회전수_합계 = 0;
            for (int 주사위 : 주사위배열)
                 회전수_합계 += 필요한_회전수(주사위, 목표숫자);
            return 회전수_합계;
        }

        public int solution(int[] A) {
            int 최소_회전수 = Integer.MAX_VALUE;
            for (int 목표숫자 = 1; 목표숫자 <= 6; ++목표숫자) {
                int 회전수 = 필요한_회전수_합계(A, 목표숫자);
                if (회전수 < 최소_회전수) 최소_회전수 = 회전수;
            }
            return 최소_회전수;
        }
    }

    public static void main(String[] args) {
        int[] A1 = {1,2,3};
        int[] A2 = {1,1,6};
        int[] A3 = {1,6,2,3};
        Solution s = new Solution();
        System.out.println(s.solution(A1));
        System.out.println(s.solution(A2));
        System.out.println(s.solution(A3));
    }
}
