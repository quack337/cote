package baekjoon.b15.p15685;

import java.util.Scanner;

public class Main {

    static class Location {
        int 행, 열;
        public Location(int 행, int 열) {
            this.행 = 행;
            this.열 = 열;
        }

        @Override
        public Location clone() {
            return new Location(행, 열);
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", 행, 열);
        }
    }

    static Location[] 드래곤커브생성(Location[] 커브) {
        Location[] 새커브 = new Location[커브.length * 2 - 1]; // 이전 세대 드래곤커브 복사
        for (int i = 0; i < 커브.length; ++i)
            새커브[i] = 커브[i].clone();
        Location 끝 = 커브[커브.length - 1];    // 90도 회전하여 끝에 추가함
        for (int i = 1; i < 커브.length; ++i) {
            int i0 = 커브.length - 1 - i;
            int i1 = 커브.length - 1 + i;
            새커브[i1] = new Location(끝.행 - (끝.열 - 커브[i0].열), 끝.열 - (커브[i0].행 - 끝.행));
        }
        return 새커브;
    }

    static Location[] 드래곤커브생성(Location[] 커브, int 세대) {
        for (int i = 0; i < 세대; ++i)
            커브 = 드래곤커브생성(커브);
        return 커브;
    }

    static void 격자에_드래곤커브_출력(char[][] 격자, int 시작행, int 시작열, Location[] 커브) {
        for (Location 꼭지점 : 커브) {
            int 행 = 시작행 + 꼭지점.행;
            int 열 = 시작열 + 꼭지점.열;
            if (행 < 0 || 행 >= 격자.length) continue;
            if (열 < 0 || 열 >= 격자[0].length) continue;
            격자[행][열] = '#';
        }
    }

    static int 정사각형수(char[][] 격자) {
        int 수 = 0;
        for (int 행 = 0; 행 < 격자.length - 1; ++행)
            for (int 열 = 0; 열 < 격자[0].length - 1; ++열)
                if (격자[행][열] == '#' && 격자[행+1][열] == '#' &&
                    격자[행][열+1] == '#' && 격자[행+1][열+1] == '#')
                    ++수;
        return 수;
    }

    public static void main(String[] args) {
        char[][] 격자 = new char[101][];
        for (int i = 0; i <= 100; ++i)
            격자[i] = new char[101];

        Location[][] 시작커브 = new Location[][] {
            new Location[] { new Location(0,0), new Location(0,1) },
            new Location[] { new Location(0,0), new Location(-1,0) },
            new Location[] { new Location(0,0), new Location(0,-1) },
            new Location[] { new Location(0,0), new Location(1,0) }
        };

        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            for (int i = 0; i < N; ++i) {
                int 열 = scanner.nextInt();
                int 행 = scanner.nextInt();
                int 방향 = scanner.nextInt();
                int 세대 = scanner.nextInt();
                Location[] 커브 = 드래곤커브생성(시작커브[방향], 세대);
                격자에_드래곤커브_출력(격자, 행, 열, 커브);
            }
            System.out.println(정사각형수(격자));
        }
    }
}