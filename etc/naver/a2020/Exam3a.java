package net.skhu.naver.a2020;

public class Exam3a {

    // 0..9 에 필요한 성냥 수
    static final int[] DIGIT = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

    // 파라미터: k = 주어진 성냥 수, first = 첫 자리인가?
    static int solution(int k, boolean first) {
        if (k == 0) return 1; // 남은 성냥이 1개 이하이면 끝. 조합 1개 완성함.
        int result = 0; // 모든 경우의 수
        for (int i = 0; i < DIGIT.length; ++i) {
            if (first && i == 0) continue; // 첫 자리 0은 안됨
            if (k >= DIGIT[i])
                result += solution(k - DIGIT[i], false);
        }
        return result;
    }

    // 파라미터: k = 주어진 성냥
    static int solution(int k) {
        if (k <= 1) return 0;
        if (k == 6) return 1 + solution(k, true); // 1의 자리는 0은 첫 자리라도 가능
        return solution(k, true);
    }


    public static void main(String[] args) {
        int[] TESTS = { 5, 6, 11, 1 }; // 답: 5, 7, 99, 0
        for (int t : TESTS)
            System.out.println(solution(t));

        System.out.println(solution(50)); // 너무 느리다. 그리고 결과값은 int 범위를 넘는다.
    }

}
