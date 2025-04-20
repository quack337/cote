package baekjoon.b14503;
import java.util.Scanner;

public class Main {
    static final int 벽 = 1, 빈칸 = 0, 청소된칸 = 2;
    static final int 북 = 0, 동 = 1, 남 = 2, 서 = 3;

    static class Location implements Cloneable {
        int 행, 열;

        public Location(int 행, int 열) {
            this.행 = 행;
            this.열 = 열;
        }

        @Override
        public Location clone() {
            return new Location(행, 열);
        }

        public void 전진하라(int 방향) {
            switch (방향) {
            case 북: --행; break;
            case 동: ++열; break;
            case 남: ++행; break;
            case 서: --열; break;
            }
        }

        public void 후진하라(int 방향) {
            switch (방향) {
            case 북: ++행; break;
            case 동: --열; break;
            case 남: --행; break;
            case 서: ++열; break;
            }
        }
    }

    static class Room {
        byte[][] 칸;

        public Room(byte[][] 칸) {
            this.칸 = 칸;
        }

        public boolean 빈칸인가(Location 위치) {
            return get칸(위치) == 빈칸;
        }

        public boolean 벽인가(Location 위치) {
            return get칸(위치) == 벽;
        }

        private byte get칸(Location 위치) {
            if (위치.행 < 0 || 위치.행 >= 칸.length) return 벽;
            if (위치.열 < 0 || 위치.열 >= 칸[0].length) return 벽;
            return 칸[위치.행][위치.열];
        }

        public void 청소하다(Location 위치) {
            칸[위치.행][위치.열] = 청소된칸;
        }
    }

    static class Robot {
        Location 현재위치;
        int 방향;
        int 청소한칸수 = 0;

        public Robot(int 행, int 열, int 방향) {
            this.현재위치 = new Location(행, 열);
            this.방향 = 방향;
        }

        public void 왼쪽으로회전() {
            switch (방향) {
            case 북: 방향 = 서; break;
            case 동: 방향 = 북; break;
            case 남: 방향 = 동; break;
            case 서: 방향 = 남; break;
            }
        }

        public void 청소하라(Room 방) {
            방.청소하다(현재위치);
            ++청소한칸수;
        }

        private Location get앞칸() {
            Location 앞칸 = 현재위치.clone();
            앞칸.전진하라(방향);
            return 앞칸;
        }

        private Location get뒷칸() {
            Location 뒷칸 = 현재위치.clone();
            뒷칸.후진하라(방향);
            return 뒷칸;
        }

        public boolean 이동하라(Room 방) {
            while (true) {
                for (int i = 0; i < 4; ++i) { // 4 방향 탐색
                    왼쪽으로회전();
                    Location 앞칸 = get앞칸();
                    if (방.빈칸인가(앞칸)) {
                        현재위치.전진하라(방향);
                        return true;
                    }
                }
                Location 뒷칸 = get뒷칸();
                if (방.벽인가(뒷칸)) return false;
                현재위치.후진하라(방향);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 행수 = scanner.nextInt();
            int 열수 = scanner.nextInt();

            int 로봇행 = scanner.nextInt();
            int 로봇열 = scanner.nextInt();
            int 로봇방향 = scanner.nextInt();
            Robot 로봇 = new Robot(로봇행, 로봇열, 로봇방향);

            byte[][] 칸 = new byte[행수][];
            for (int 행 = 0; 행 < 행수; ++행) {
                칸[행] = new byte[열수];
                for (int 열 = 0; 열 < 열수; ++열)
                    칸[행][열] = scanner.nextByte();
            }
            Room 방 = new Room(칸);

            do {
                로봇.청소하라(방);
            } while (로봇.이동하라(방));
            System.out.println(로봇.청소한칸수);;
        }
    }
}