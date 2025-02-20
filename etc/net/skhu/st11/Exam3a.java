// 2020-09-29
package net.skhu.st11;

import java.util.Arrays;

public class Exam3a {

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
        // 문제의 예제
        int[] A1 = { 1, 2, 1 }; // 2
        int[] A2 = { 2, 1, 4, 4 }; // 1
        int[] A3 = { 6, 2, 3, 5, 6, 3 }; // 4
        System.out.println(solution1(A1));
        System.out.println(solution1(A2));
        System.out.println(solution1(A3));

        // 좀 더 꼼꼼한 예제
        int[] A4 = { 2, 2, 2 }; // 2
        int[] A5 = { 1, 4, 3, 4, 5, 5, 7 }; // 3
        System.out.println(solution1(A4));
        System.out.println(solution1(A5));
    }
}
