package naver.b2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exam2a {

    static int[][] 피라미드;

    static void 왼쪽열채우기(int 행, int 열) {
        if (열 < 0) return;
        피라미드[행][열] = 피라미드[행-1][열] - 피라미드[행][열+1];
        왼쪽열채우기(행, 열-1);
    }

    static void 오른쪽열채우기(int 행, int 열) {
        if (열 > 행) return;
        피라미드[행][열] = 피라미드[행-1][열-1] - 피라미드[행][열-1];
        오른쪽열채우기(행, 열+1);
    }

    static int[] solution(int[][] blocks) {
        피라미드 = new int[blocks.length][blocks.length];
        for (int 행 = 0; 행 < blocks.length; ++행) {
            int 열 = blocks[행][0], 값 = blocks[행][1];
            피라미드[행][열] = 값;
            왼쪽열채우기(행, 열-1);
            오른쪽열채우기(행, 열+1);
        }
        List<Integer> 결과 = new ArrayList<>();
        for (int 행 = 0; 행 < 피라미드.length; ++행)
            for (int 열 = 0; 열 <= 행; ++열)
                결과.add(피라미드[행][열]);
        return 결과.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[][] a1 = {{0, 50}, {0, 22}, {2, 10}, {1, 4}, {4, -13}};
        System.out.println(Arrays.toString(solution(a1)));

        int[][] a2 = {{0, 92}, {1, 20}, {2, 11}, {1, -81}, {3, 98}};
        System.out.println(Arrays.toString(solution(a2)));
    }
}