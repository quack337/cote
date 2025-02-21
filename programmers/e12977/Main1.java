public class Main1 {

    static class Solution {

        void 세개선택하기(int[] A, int index, int 합계, int 선택_수) {
            if (선택_수 == 3) { // 3개를 선택했다면, 합계를 출력하고 리턴
                System.out.println(합계);
                return;
            }
            if (index >= A.length) return; // 더 선택할 수가 없다면 리턴
            세개선택하기(A, index + 1, 합계, 선택_수); // 현재 수를 선택하지 않고, 재귀호출
            세개선택하기(A, index + 1, 합계 + A[index], 선택_수 + 1); // 현재 수를 선택하고, 재귀호출
        }

        public int solution(int[] A) {
            세개선택하기(A, 0, 0, 0);
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //sol.solution(new int[] {1,2,3,4});
        //System.out.println("");
        sol.solution(new int[] {1,2,7,6,4});
    }
}