package baekjoon.p07.p7569;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main1 {

    static class Location {
        int 행, 열, 거리;

        public Location(int 행, int 열, int 거리) {
            this.행 = 행;
            this.열 = 열;
            this.거리 = 거리;
        }

        @Override
        public int hashCode() {
            return Objects.hash(열, 행);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Location p = (Location) obj;
            return 열 == p.열 && 행 == p.행;
        }
    }

    static List<Location> 익은토마토목록(int[][] map) {
        List<Location> list = new ArrayList<>();
        for (int r = 0; r < map.length; ++r)
            for (int c = 0; c < map[0].length; ++c)
                if (map[r][c] == 1)
                    list.add(new Location(r, c, 0));
        return list;
    }

    static int 익지않은토마토수(int[][] map) {
        int 수 = 0;
        for (int r = 0; r < map.length; ++r)
            for (int c = 0; c < map[0].length; ++c)
                if (map[r][c] == 0) ++수;
        return 수;
    }

    static int 탐색(int[][] map) {
        if (익지않은토마토수(map) == 0) return 0;
        int 최대거리 = 0;
        Set<Location> 방문한칸 = new HashSet<Location>();
        Queue<Location> queue = new ArrayDeque<>(); // 방문할 칸 목록
        queue.addAll(익은토마토목록(map));          // 시작 위치
        while (queue.size() > 0) {
            Location 위치 = queue.remove();         // 현재 위치
            if (위치.행 < 0 || 위치.행 >= map.length) continue;
            if (위치.열 < 0 || 위치.열 >= map[0].length) continue;
            if (map[위치.행][위치.열] == -1) continue;  // 빈칸
            if (방문한칸.contains(위치)) continue;      // 이미 방문한 칸인가?
            방문한칸.add(위치);
            map[위치.행][위치.열] = 1;
            최대거리 = Math.max(최대거리, 위치.거리);
            queue.add(new Location(위치.행 - 1, 위치.열, 위치.거리 + 1)); // 위로
            queue.add(new Location(위치.행, 위치.열 - 1, 위치.거리 + 1)); // 왼쪽으로
            queue.add(new Location(위치.행 + 1, 위치.열, 위치.거리 + 1)); // 아래쪽으로
            queue.add(new Location(위치.행, 위치.열 + 1, 위치.거리 + 1)); // 오른쪽으로
        }
        return 익지않은토마토수(map) == 0 ? 최대거리 : -1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int[][] map = new int[N][M];
            for (int r = 0; r < N; ++r)
                for (int c = 0; c < M; ++c)
                    map[r][c] = scanner.nextInt();
            System.out.println(탐색(map));
        }
    }
}
