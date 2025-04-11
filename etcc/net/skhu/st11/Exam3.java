package etcc.net.skhu.st11;
// 2020-09-29


import java.util.Arrays;

public class Exam3 {

    // O(N * logN)
    public static int solution1(int[] A) {
        Arrays.sort(A); // 정렬함
        int answer = 0;
        for (int i = 0; i < A.length; ++i) {
            int value = i + 1; // 이 위치에 있어야 할 값
            answer += Math.abs(A[i] - value); // 이 만큼 조정해야 함
            if (answer > 1000000000) return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] A1 = { 1, 2, 1 };
        int[] A2 = { 2, 1, 4, 4 };
        int[] A3 = { 6, 2, 3, 5, 6, 3 };
        System.out.println(solution1(A1));
        System.out.println(solution1(A2));
        System.out.println(solution1(A3));
    }

}