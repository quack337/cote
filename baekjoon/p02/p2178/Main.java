package baekjoon.p02.p2178;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {

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

    static int 탐색(char[][] map) {
        Location 목적지 = new Location(map.length - 1, map[0].length - 1, 0);
        Set<Location> 방문한칸 = new HashSet<Location>();
        Queue<Location> queue = new ArrayDeque<>(); // 방문할 칸 목록
        queue.add(new Location(0, 0, 1));           // 시작 위치
        while (queue.size() > 0) {
            Location 위치 = queue.remove();         // 현쟈 위치
            if (위치.행 < 0 || 위치.행 >= map.length) continue;
            if (위치.열 < 0 || 위치.열 >= map[0].length) continue;
            if (map[위치.행][위치.열] == '0') continue; // 벽
            if (방문한칸.contains(위치)) continue;      // 이미 방문한 칸인가?
            if (위치.equals(목적지)) return 위치.거리;  // 목적지 도착
            방문한칸.add(위치);
            queue.add(new Location(위치.행 - 1, 위치.열, 위치.거리 + 1)); // 위로
            queue.add(new Location(위치.행, 위치.열 - 1, 위치.거리 + 1)); // 왼쪽으로
            queue.add(new Location(위치.행 + 1, 위치.열, 위치.거리 + 1)); // 아래쪽으로
            queue.add(new Location(위치.행, 위치.열 + 1, 위치.거리 + 1)); // 오른쪽으로
        }
        return -1; // 탐색 실패
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int 행 = scanner.nextInt();
            int 열 = scanner.nextInt();
            char[][] map = new char[행][];
            for (int i = 0; i < 행; ++i)
                map[i] = scanner.next().toCharArray();
            System.out.println(탐색(map));
        }
    }
}
