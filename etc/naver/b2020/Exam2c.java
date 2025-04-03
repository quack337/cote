package naver.b2020;

import java.util.Arrays;

public class Exam2c {

    static int[] solution(int[][] blocks) {
        final int[] 인덱스 = {0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136 };
        int[] 피라미드 = new int[인덱스[blocks.length]];
        for (int 행 = 0; 행 < blocks.length; ++행) {
            int 열 = blocks[행][0], 값 = blocks[행][1];
            피라미드[인덱스[행] + 열] = 값;
            for (int c = 열-1; c >= 0; --c)          // 왼쪽 열들 채우기
                피라미드[인덱스[행] + c] = 피라미드[인덱스[행-1] + c] - 피라미드[인덱스[행] + c+1];
            for (int c = 열+1; c <= 행; ++c)         // 오른쪽 열들 채우기
                피라미드[인덱스[행] + c] = 피라미드[인덱스[행-1] + c-1] - 피라미드[인덱스[행] + c-1];
        }
        return 피라미드;
    }

    public static void main(String[] args) {
        int[][] a1 = {{0, 50}, {0, 22}, {2, 10}, {1, 4}, {4, -13}};
        System.out.println(Arrays.toString(solution(a1)));

        int[][] a2 = {{0, 92}, {1, 20}, {2, 11}, {1, -81}, {3, 98}};
        System.out.println(Arrays.toString(solution(a2)));
    }
}