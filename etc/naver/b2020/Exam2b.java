package naver.b2020;

import java.util.Arrays;

public class Exam2b {

    static int[] 피라미드;

    static int 인덱스(int 행, int 열) {
        return 행 * (행 + 1) / 2 + 열;
    }

    static void 왼쪽열채우기(int 행, int 열) {
        if (열 < 0) return;
        피라미드[인덱스(행, 열)] = 피라미드[인덱스(행-1, 열)] - 피라미드[인덱스(행, 열+1)];
        왼쪽열채우기(행, 열-1);
    }

    static void 오른쪽열채우기(int 행, int 열) {
        if (열 > 행) return;
        피라미드[인덱스(행, 열)] = 피라미드[인덱스(행-1, 열-1)] - 피라미드[인덱스(행, 열-1)];
        오른쪽열채우기(행, 열+1);
    }

    static int[] solution(int[][] blocks) {
        피라미드 = new int[인덱스(blocks.length, 0)];
        for (int 행 = 0; 행 < blocks.length; ++행) {
            int 열 = blocks[행][0], 값 = blocks[행][1];
            피라미드[인덱스(행, 열)] = 값;
            왼쪽열채우기(행, 열-1);
            오른쪽열채우기(행, 열+1);
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