package baekjoon.p07.p7576.old;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main1 {

    static class Location {
        int y, x, z, distance;

        public Location(int z, int y, int x, int distance) {
            this.z = z;
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    static List<Location> 익은토마토목록(byte[][][] map) {
        List<Location> list = new ArrayList<>();
        for (int z = 0; z < map.length; ++z)
            for (int y = 0; y < map[0].length; ++y)
                for (int x = 0; x < map[0][0].length; ++x)
                if (map[z][y][x] == 1) {
                    list.add(new Location(z, y, x, 0));
                    map[z][y][x] = 0;
                }
        return list;
    }

    static int 익지않은토마토수(byte[][][] map) {
        int 수 = 0;
        for (int z = 0; z < map.length; ++z)
            for (int y = 0; y < map[0].length; ++y)
                for (int x = 0; x < map[0][0].length; ++x)
                if (map[z][y][x] == 0) ++수;
        return 수;
    }

    static int 탐색(byte[][][] map) {
        if (익지않은토마토수(map) == 0) return 0;
        int 최대거리 = 0;
        Queue<Location> queue = new ArrayDeque<>(); // 방문할 칸 목록
        queue.addAll(익은토마토목록(map));          // 시작 위치
        while (queue.size() > 0) {
            Location 위치 = queue.remove();         // 현재 위치
            if (위치.z < 0 || 위치.z >= map.length) continue;
            if (위치.y < 0 || 위치.y >= map[0].length) continue;
            if (위치.x < 0 || 위치.x >= map[0][0].length) continue;
            if (map[위치.z][위치.y][위치.x] == -1) continue;  // 빈칸
            if (map[위치.z][위치.y][위치.x] == 1) continue;  // 이미 방문한 칸인가?
            map[위치.z][위치.y][위치.x] = 1;
            최대거리 = Math.max(최대거리, 위치.distance);
            queue.add(new Location(위치.z - 1, 위치.y, 위치.x, 위치.distance + 1));
            queue.add(new Location(위치.z + 1, 위치.y, 위치.x, 위치.distance + 1));
            queue.add(new Location(위치.z, 위치.y - 1, 위치.x, 위치.distance + 1));
            queue.add(new Location(위치.z, 위치.y + 1, 위치.x, 위치.distance + 1));
            queue.add(new Location(위치.z, 위치.y, 위치.x - 1, 위치.distance + 1));
            queue.add(new Location(위치.z, 위치.y, 위치.x + 1, 위치.distance + 1));
        }
        return 익지않은토마토수(map) == 0 ? 최대거리 : -1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int H = scanner.nextInt();
            byte[][][] map = new byte[H][N][M];
            for (int z = 0; z < H; ++z)
                for (int r = 0; r < N; ++r)
                    for (int c = 0; c < M; ++c)
                        map[z][r][c] = (byte)scanner.nextInt();
            System.out.println(탐색(map));
        }
    }
}