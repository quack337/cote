package baekjoon.p14.p14500;

import java.util.Scanner;

public class Main {

    static final int[][][] 테트로미노목록 = {
        // ####
        {{0,0}, {0,1}, {0,2}, {0,3} },
        // #
        // #
        // #
        // #
        {{0,0}, {1,0}, {2,0}, {3,0}},
        // ##
        // ##
        {{0,0}, {0,1}, {1,0}, {1,1}},
        // ###
        //   #
        {{0,0}, {0,1}, {0,2}, {1,2}},
        // ###
        // #
        {{0,0}, {0,1}, {0,2}, {1,0}},
        //   #
        // ###
        {{1,0}, {1,1}, {1,2}, {0,2}},
        // #
        // ###
        {{1,0}, {1,1}, {1,2}, {0,0}},
        // ##
        // #
        // #
        {{0,0}, {1,0}, {2,0}, {0,1}},
        // ##
        //  #
        //  #
        {{0,0}, {0,1}, {1,1}, {2,1}},
        // #
        // #
        // ##
        {{0,0}, {1,0}, {2,0}, {2,1}},
        //  #
        //  #
        // ##
        {{0,1}, {1,1}, {2,1}, {2,0}},
        //  #
        // ##
        // #
        {{0,1}, {1,1}, {1,0}, {2,0}},
        // #
        // ##
        //  #
        {{0,0}, {1,0}, {1,1}, {2,1}},
        // ##
        //  ##
        {{0,0}, {0,1}, {1,1}, {1,2}},
        //  ##
        // ##
        {{0,1}, {0,2}, {1,0}, {1,1}},
        // #
        // ##
        // #
        {{0,0}, {1,0}, {1,1}, {2,0}},
        //  #
        // ##
        //  #
        {{0,1}, {1,0}, {1,1}, {2,1}},
        // ###
        //  #
        {{0,0}, {0,1}, {0,2}, {1,1}},
        //  #
        // ###
        {{1,0}, {1,1}, {1,2}, {0,1}}
    };

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 행수 = scanner.nextInt();
            int 열수 = scanner.nextInt();
            int[][] 게임판 = new int[행수][];
            for (int 행 = 0; 행 < 행수; ++행) {
                게임판[행] = new int[열수];
                for (int 열 = 0; 열 < 열수; ++열)
                    게임판[행][열] = scanner.nextInt();
            }
            int 최대값 = 0;
            for (int[][] 테트로미노 : 테트로미노목록) {
                for (int 행 = 0; 행 < 행수; ++행)
                    for (int 열 = 0; 열 < 열수; ++열) {
                        int 합계 = 0;
                        for (int i = 0; i < 4; ++i) {
                            int 사각형_행 = 행 + 테트로미노[i][0];
                            int 사각형_열 = 열 + 테트로미노[i][1];
                            if (사각형_행 >= 행수) break;
                            if (사각형_열 >= 열수) break;
                            합계 += 게임판[사각형_행][사각형_열];
                        }
                        if (합계 > 최대값) 최대값 = 합계;
                    }
            }
            System.out.println(최대값);
        }
    }
}