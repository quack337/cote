package baekjoon.b14.p14499;

import java.util.Scanner;

public class Main {
    static final int 동 = 1, 서 = 2, 북 = 3, 남 = 4;


    static void 주사위_회전(int[] 주사위면, int 방향) {
        int 주사위1 = 주사위면[1];
        switch (방향) {
        case 동:
            주사위면[1] = 주사위면[4];
            주사위면[4] = 주사위면[6];
            주사위면[6] = 주사위면[3];
            주사위면[3] = 주사위1;
            break;
        case 서:
            주사위면[1] = 주사위면[3];
            주사위면[3] = 주사위면[6];
            주사위면[6] = 주사위면[4];
            주사위면[4] = 주사위1;
            break;
        case 북:
            주사위면[1] = 주사위면[5];
            주사위면[5] = 주사위면[6];
            주사위면[6] = 주사위면[2];
            주사위면[2] = 주사위1;
            break;
        case 남:
            주사위면[1] = 주사위면[2];
            주사위면[2] = 주사위면[6];
            주사위면[6] = 주사위면[5];
            주사위면[5] = 주사위1;
            break;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 행수 = scanner.nextInt();
            int 열수 = scanner.nextInt();
            int 주사위_행 = scanner.nextInt();
            int 주사위_열 = scanner.nextInt();
            int 명령_수 = scanner.nextInt();
            int[][] 지도 = new int[행수][];
            for (int 행 = 0; 행 < 행수; ++행) {
                지도[행] = new int[열수];
                for (int 열 = 0; 열 < 열수; ++열)
                    지도[행][열] = scanner.nextInt();
            }
            int[] 주사위면 = {0, 1, 2, 3, 4, 5, 6};
            int[] 주사위면_숫자 = {0, 0, 0, 0, 0, 0, 0};
            for (int i = 0; i < 명령_수; ++i) {
                int 방향 = scanner.nextInt();
                switch (방향) {
                case 서: --주사위_열; break;
                case 동: ++주사위_열; break;
                case 북: --주사위_행; break;
                case 남: ++주사위_행; break;
                }
                if (주사위_열 < 0) { 주사위_열 = 0; continue; }
                if (주사위_행 < 0) { 주사위_행 = 0; continue; }
                if (주사위_열 >= 열수) { 주사위_열 = 열수 - 1; continue; }
                if (주사위_행 >= 행수) { 주사위_행 = 행수 - 1; continue; }

                주사위_회전(주사위면, 방향);
                int 주사위_윗면 = 주사위면[1];
                int 주사위_아랫면 = 주사위면[6];

                if (지도[주사위_행][주사위_열] == 0)
                    지도[주사위_행][주사위_열] = 주사위면_숫자[주사위_아랫면];
                else {
                    주사위면_숫자[주사위_아랫면] = 지도[주사위_행][주사위_열];
                    지도[주사위_행][주사위_열] = 0;
                }
                System.out.println(주사위면_숫자[주사위_윗면]);
            }
        }
    }
}