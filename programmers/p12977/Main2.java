package programmers.p12977;
public class Main2 {

    static class Solution {

        int 소수_수 = 0; // 구할 답

        // 자기 자신이 아닌 수로 나누어 떨어지면 소수가 아니다
        boolean 소수인가(int n) {
            if (n == 1) return false;
            double limit = Math.sqrt(n);
            for (int i = 2; i <= limit; ++i)
                if (n % i == 0) return false;
            return true;
        }

        void 세개선택하기(int[] A, int index, int 합계, int 선택_수) {
            if (선택_수 == 3) {
                if (소수인가(합계)) ++소수_수;
                return;
            }
            if (index >= A.length) return;
            세개선택하기(A, index + 1, 합계, 선택_수);
            세개선택하기(A, index + 1, 합계 + A[index], 선택_수 + 1);
        }

        public int solution(int[] A) {
            소수_수 = 0;
            세개선택하기(A, 0, 0, 0);
            return 소수_수;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {1,2,3,4}));
        System.out.println(sol.solution(new int[] {1,2,7,6,4}));
    }
}