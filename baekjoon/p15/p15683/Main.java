package baekjoon.p15.p15683;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int 감시영역 = 8, 빈칸 = 0, 벽 = 6, 북 = 0, 동 = 1, 남 = 2, 서 = 3;

    static class CCTV {
        int 행, 열, 종류, 방향;

        public CCTV(int 행, int 열, int 종류) {
            this.행 = 행;
            this.열 = 열;
            this.종류 = 종류;
        }

        public int 감시방향의수() {
            final int[] 방향의수 = {0, 4, 2, 4, 4, 1};
            return 방향의수[종류];
        }
    }

    static void 감시영역표시지우기(byte[][] 사무실) {
        for (int 행 = 0; 행 < 사무실.length; ++행)
            for (int 열 = 0; 열 < 사무실[0].length; ++열)
                if (사무실[행][열] == 감시영역) 사무실[행][열] = 빈칸;
    }

    static int 빈칸수(byte[][] 사무실) {
        int 수 = 0;
        for (int 행 = 0; 행 < 사무실.length; ++행)
            for (int 열 = 0; 열 < 사무실[0].length; ++열)
                if (사무실[행][열] == 빈칸) ++수;
        return 수;
    }

    static void 감시영역표시(byte[][] 사무실, int 시작행, int 시작열, int 방향) {
        switch (방향) {
        case 북:
            for (int 행 = 시작행 - 1; 행 >= 0; --행)
                if (사무실[행][시작열] == 빈칸) 사무실[행][시작열]= 감시영역;
                else if (사무실[행][시작열] == 벽) break;
            break;
        case 남:
            for (int 행 = 시작행 + 1; 행 < 사무실.length; ++행)
                if (사무실[행][시작열] == 빈칸) 사무실[행][시작열]= 감시영역;
                else if (사무실[행][시작열] == 벽) break;
            break;
        case 서:
            for (int 열 = 시작열 - 1; 열 >= 0; --열)
                if (사무실[시작행][열] == 빈칸) 사무실[시작행][열]= 감시영역;
                else if (사무실[시작행][열] == 벽) break;
            break;
        case 동:
            for (int 열 = 시작열 + 1; 열 < 사무실[0].length; ++열)
                if (사무실[시작행][열] == 빈칸) 사무실[시작행][열]= 감시영역;
                else if (사무실[시작행][열] == 벽) break;
            break;
        }
    }

    static void 감시영역표시(byte[][] 사무실, CCTV 카메라) {
        감시영역표시(사무실, 카메라.행, 카메라.열, 카메라.방향);
        switch (카메라.종류) {
        case 2:
            감시영역표시(사무실, 카메라.행, 카메라.열, 카메라.방향 + 2);
            break;
        case 3:
            감시영역표시(사무실, 카메라.행, 카메라.열, (카메라.방향 + 1) % 4);
            break;
        case 4:
            감시영역표시(사무실, 카메라.행, 카메라.열, (카메라.방향 + 1) % 4);
            감시영역표시(사무실, 카메라.행, 카메라.열, (카메라.방향 + 3) % 4);
            break;
        case 5:
            감시영역표시(사무실, 카메라.행, 카메라.열, (카메라.방향 + 1) % 4);
            감시영역표시(사무실, 카메라.행, 카메라.열, (카메라.방향 + 2) % 4);
            감시영역표시(사무실, 카메라.행, 카메라.열, (카메라.방향 + 3) % 4);
            break;
        }
    }

    static void 감시영역표시(byte[][] 사무실, List<CCTV> 카메라목록) {
        for (CCTV 카메라 : 카메라목록)
            감시영역표시(사무실, 카메라);
    }

    static int 사각지역수(byte[][] 사무실, List<CCTV> 카메라목록) {
        감시영역표시(사무실, 카메라목록);
        int 사각지역수 = 빈칸수(사무실);
        감시영역표시지우기(사무실);
        return 사각지역수;
    }

    static int 카메라설정(byte[][] 사무실, List<CCTV> 카메라목록, int 카메라인덱스) {
        if (카메라인덱스 >= 카메라목록.size())
            return 사각지역수(사무실, 카메라목록);
        int 최소값 = Integer.MAX_VALUE;
        CCTV 카메라 = 카메라목록.get(카메라인덱스);
        for (int 방향 = 0; 방향 < 카메라.감시방향의수(); ++방향) {
            카메라.방향 = 방향;
            int 사각지역수 = 카메라설정(사무실, 카메라목록, 카메라인덱스 + 1);
            if (사각지역수 < 최소값) 최소값 = 사각지역수;
        }
        return 최소값;
    }

    static List<CCTV> get카메라목록(byte[][] 사무실) {
        List<CCTV> 카메라목록 = new ArrayList<>();
        for (int 행 = 0; 행 < 사무실.length; ++행)
            for (int 열 = 0; 열 < 사무실[0].length; ++열)
                if (사무실[행][열] >= 1 && 사무실[행][열] <= 5)
                    카메라목록.add(new CCTV(행, 열, 사무실[행][열]));
        return 카메라목록;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 행수 = scanner.nextInt();
            int 열수 = scanner.nextInt();
            byte[][] 사무실 = new byte[행수][];
            for (int 행 = 0; 행 < 행수; ++행) {
                사무실[행] = new byte[열수];
                for (int 열 = 0; 열 < 열수; ++열)
                    사무실[행][열] = scanner.nextByte();
            }

            List<CCTV> 카메라목록 = get카메라목록(사무실);
            System.out.println(카메라설정(사무실, 카메라목록, 0));
        }
    }
}