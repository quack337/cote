package nhn.e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz2 {

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

        List<좌표> get좌표목록(int 최소좌표, int 최대좌표) {
            List<좌표> 좌표목록 = new ArrayList<좌표>();
            for (int 열 = 최소좌표; 열 <= 최대좌표; ++열)
                좌표목록.add(new 좌표(최소좌표, 열));
            for (int 행 = 최소좌표 + 1; 행 <= 최대좌표; ++행)
                좌표목록.add(new 좌표(행, 최대좌표));
            for (int 열 = 최대좌표 - 1; 열 >= 최소좌표; --열)
                좌표목록.add(new 좌표(최대좌표, 열));
            for (int 행 = 최대좌표 - 1; 행 > 최소좌표; --행)
                좌표목록.add(new 좌표(행, 최소좌표));
            return 좌표목록;
        }

        List<String> get값목록(int 최소좌표, int 최대좌표) {
            List<String> 값목록 = new ArrayList<String>();
            for (int 열 = 최소좌표; 열 <= 최대좌표; ++열)
                값목록.add(전광판[최소좌표][열]);
            for (int 행 = 최소좌표 + 1; 행 <= 최대좌표; ++행)
                값목록.add(전광판[행][최대좌표]);
            for (int 열 = 최대좌표 - 1; 열 >= 최소좌표; --열)
                값목록.add(전광판[최대좌표][열]);
            for (int 행 = 최대좌표 - 1; 행 > 최소좌표; --행)
                값목록.add(전광판[행][최소좌표]);
            return 값목록;
        }

        void 회전(int 최소좌표, int 최대좌표, int 방향, String[][] 새전광판) {
            if (최대좌표 < 최소좌표) return;
            if (최대좌표 == 최소좌표) { 새전광판[최대좌표][최대좌표] = 전광판[최대좌표][최대좌표]; return; }

            List<좌표> 좌표목록 = get좌표목록(최소좌표, 최대좌표);
            List<String> 값목록 = get값목록(최소좌표, 최대좌표);
            int 칸수 = 좌표목록.size();
            int 거리 = (회전수 % 칸수) * 방향;
            for (int i = 0; i < 값목록.size(); ++i) {
                int j = i + 거리;
                if (j >= 칸수) j -= 칸수; else if (j < 0) j += 칸수;
                좌표 새좌표 = 좌표목록.get(j);
                새전광판[새좌표.행][새좌표.열] = 값목록.get(i);
            }
            회전(++최소좌표, --최대좌표, -방향, 새전광판);
        }

        public void 회전() {
            String[][] 새전광판 = new String[판크기][판크기];
            회전(0, 판크기-1, 1, 새전광판);
            this.전광판 = 새전광판;
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