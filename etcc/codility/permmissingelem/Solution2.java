package etcc.codility.permmissingelem;
public class Solution2 {

    public static int solution(int[] A) {
        // A 배열에 빠진 값이 없을 경우 등차 수열의 합
        int N = A.length + 1;
        long sum = N * (1L + N) / 2L;

        // sum에서 배열의 모든 항목을 빼기
        for (int i = 0; i < A.length; ++i)
            sum = sum - A[i];

        // 남은 값 리턴
        return (int)sum;
    }

    public static void main(String[] args) {
        int[] A = { 2, 3, 1, 5 };
        System.out.println(solution(A));
    }

}