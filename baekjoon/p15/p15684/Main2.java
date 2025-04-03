package baekjoon.p15.p15684;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    static boolean[][] 복제(boolean[][] 가로선) {
        boolean[][] 복제 = new boolean[가로선.length][];
        for (int i = 0; i < 가로선.length; ++i)
            복제[i] = Arrays.copyOf(가로선[i], 가로선[i].length);
        return 복제;
    }

    static boolean 확인(int 세로선_수, int 가로위치_수, boolean[][] 가로선) {
        for (int 세로 = 0; 세로 < 세로선_수; ++세로) {
            int 선 = 세로;
            for (int 가로 = 0; 가로 < 가로위치_수; ++가로) {
                if (선 < 가로선.length && 가로선[선][가로]) ++선;
                else if (선 > 0 && 가로선[선-1][가로]) --선;
            }
            if (선 != 세로) return false;
        }
        return true;
    }

    static int 탐색(int 세로선_수, int 가로위치_수, boolean[][] 가로선, int 인덱스, int 추가한_가로선수) {
        if (추가한_가로선수 == 3 || 인덱스 >= (세로선_수 - 1) * 가로위치_수) return Integer.MAX_VALUE;
        int 결과1 = 탐색(세로선_수, 가로위치_수, 가로선, 인덱스 + 1, 추가한_가로선수);
        int 세로 = 인덱스 / 가로위치_수;
        int 가로 = 인덱스 % 가로위치_수;
        if (가로선[세로][가로]) return 결과1;

        boolean[][] 복제_가로선 = 복제(가로선);
        복제_가로선[세로][가로] = true;
        if (확인(세로선_수, 가로위치_수, 복제_가로선)) return Math.min(결과1, 추가한_가로선수 + 1);
        int 결과2 = 탐색(세로선_수, 가로위치_수, 복제_가로선, 인덱스 + 1, 추가한_가로선수 + 1);
        return Math.min(결과1, 결과2);
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 세로선_수 = scanner.nextInt();
            int 가로선_수 = scanner.nextInt();
            int 가로위치_수 = scanner.nextInt();

            boolean[][] 가로선 = new boolean[세로선_수 - 1][];
            for (int i = 0; i < 세로선_수 - 1; ++i)
                가로선[i] = new boolean[가로위치_수];

            for (int i = 0; i < 가로선_수; ++i) {
                int 가로번호 = scanner.nextInt() - 1;
                int 세로번호 = scanner.nextInt() - 1;
                가로선[세로번호][가로번호] = true;
            }
            int 결과;
            if (확인(세로선_수, 가로위치_수, 가로선)) 결과 = 0;
            else 결과 = 탐색(세로선_수, 가로위치_수, 가로선, 0, 0);
            if (결과 == Integer.MAX_VALUE) 결과 = -1;
            System.out.println(결과);
        }
    }
}