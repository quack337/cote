package naver.a2020;

public class Exam3b {

    // 0..9 에 필요한 성냥 수
    static final int[] DIGIT = { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6 };

    static final int[][] DP = new int[51][2];

    // 파라미터: k = 주어진 성냥 수, first = 첫 자리인가?
    static int solution(int k, int first) {
        if (k == 0) return 1; // 남은 성냥이 없으면 끝. 조합 1개 완성함.
        if (DP[k][first] > 0) return DP[k][first];
        int result = 0; // 모든 경우의 수
        for (int i = 0; i < DIGIT.length; ++i) {
            if (first == 1 && i == 0) continue; // 첫 자리 0은 안됨
            if (k >= DIGIT[i])
                result += solution(k - DIGIT[i], 0);
        }
        return DP[k][first] = result;
    }

    // 파라미터: k = 주어진 성냥
    static int solution(int k) {
        if (k <= 0) return 0;
        if (k == 6) return 1 + solution(k, 1); // 1의 자리는 0은 첫 자리라도 가능
        return solution(k, 1);
    }


    public static void main(String[] args) {
        int[] TESTS = { 5, 6, 11, 1 }; // 답: 5, 7, 99, 0
        for (int t : TESTS)
            System.out.println(solution(t));

        System.out.println(solution(50));
    }

}
