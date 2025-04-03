package etc.net.skhu.st11;

// 2020-09-29
package net.skhu.st11;

public class Exam3d {

    // O(N)
    public static int solution1(int[] A) {
        int maxValue = A.length + 1;
        int[] count = new int[maxValue+1]; // maxValue+1 개의 count가 필요함.
        for (int i = 0; i < A.length; ++i)
            ++count[A[i]]; // a[i] 값 count 증가

        int answer = 0;
        int index = 0; // A 배열의 현재 위치 index
        for (int i = 0; i < count.length; ++i)
            for (int j = 0; j < count[i]; ++j) {
                int value = index + 1; // 이 위치에 있어야 할 값
                answer += Math.abs(i - value); // 이 만큼 조정해야 함
                if (answer > 1000000000) return -1;
                index++;
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