package net.skhu.nhn.e2;

import java.util.Scanner;

public class Quiz {

    static class 좌표 {
        int 행, 열;
        public 좌표(int 행, int 열) { this.행 = 행; this.열 = 열; }
    }

    static class Board {
        String[][] 전광판;
        int 회전수;
        int 판크기;

        public Board(String[][] 전광판, int 회전수) {
            this.전광판 = 전광판;
            this.회전수 = 회전수;
            this.판크기 = 전광판.length;
        }

        public int 회전사각형_크기(int 행, int 열) {
            if (판크기 % 2 == 0) {
                double 중심좌표 = (판크기 - 1) / 2.0;
                return (int)((Math.max(Math.abs(행 - 중심좌표), Math.abs(열 - 중심좌표)) + 0.5) * 2);
            } else {
                int 중심좌표 = (판크기 - 1) / 2;
                return Math.max(Math.abs(행 - 중심좌표), Math.abs(열 - 중심좌표)) * 2 + 1;
            }
        }

        public int 회전사각형_최소행값(int 행, int 열) {
            return (판크기 - 회전사각형_크기(행, 열)) / 2;
        }

        public int 회전사각형_최대행값(int 행, int 열) {
            return 판크기 - 회전사각형_최소행값(행, 열) - 1;
        }

        public int 회전사각형_칸수(int 행, int 열) {
            return Math.max(1, 회전사각형_크기(행, 열) * 4 - 4);
        }

        public 좌표 회전좌표(int 행, int 열) throws Exception {
            int 회전수 = (this.회전수 % 회전사각형_칸수(행, 열));
            int 최소값 = 회전사각형_최소행값(행, 열);
            int 최대값 = 회전사각형_최대행값(행, 열);

            if (((판크기 - 회전사각형_크기(행, 열)) / 2 % 2) == 0) {
                for (int i = 0; i < 회전수; ++i) {  // 시간 복잡도 개선 가능 : 반복문 없이 계산식으로 구현 가능할 듯
                    if (행 == 최소값 && 열 < 최대값) ++열;
                    else if (열 == 최대값 && 행 < 최대값) ++행;
                    else if (행 == 최대값 && 열 > 최소값) --열;
                    else if (열 == 최소값 && 행 > 최소값) --행;
                    else throw new Exception("오류");
                }
            } else {
                for (int i = 0; i < 회전수; ++i) {
                    if (행 == 최소값 && 열 > 최소값) --열;
                    else if (열 == 최대값 && 행 > 최소값) --행;
                    else if (행 == 최대값 && 열 < 최대값) ++열;
                    else if (열 == 최소값 && 행 < 최대값) ++행;
                    else throw new Exception("오류");
                }
            }
            return new 좌표(행, 열);
        }

        public void 회전() throws Exception {
            String[][] 새전광판 = new String[판크기][판크기];
            for (int 행 = 0; 행 < 판크기; ++행)
                for (int 열 = 0; 열 < 판크기; ++열) {
                    좌표 새좌표 = 회전좌표(행, 열);
                    새전광판[새좌표.행][새좌표.열] = 전광판[행][열];
                }
            전광판 = 새전광판;
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int 행 = 0; 행 < 판크기; ++행) {
                for (int 열 = 0; 열 < 판크기; ++열)
                    builder.append(전광판[행][열]).append(" ");
                builder.append("\n");
            }
            return builder.toString();
        }
    }


    static Board get입력() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("입력?");
            int 행수 = scanner.nextInt();
            int 회전수 = scanner.nextInt();
            String[][] 전광판 = new String[행수][행수];
            for (int 행 = 0; 행 < 행수; ++행) {
                for (int 열 = 0; 열 < 행수; ++열)
                    전광판[행][열] = scanner.next();
            }
            return new Board(전광판, 회전수);
        }
    }

    public static void main(String[] args) throws Exception {
        Board board = get입력();
        board.회전();
        System.out.println(board);
    }
}
