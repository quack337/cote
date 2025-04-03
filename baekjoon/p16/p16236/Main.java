package baekjoon.p16.p16236;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static class Location implements Comparable<Location> {
        int 행, 열, 거리;

        public Location(int 행, int 열, int 거리) {
            this.행 = 행;
            this.열 = 열;
            this.거리 = 거리;
        }

        @Override // 탐색 우선 순위: ORDER BY 거리, 행, 열
        public int compareTo(Location p) {
            return (this.거리 - p.거리) * 10000 + (this.행 - p.행) * 100 + (this.열 - p.열);
        }
    }

    static int 고기찾아먹기(int[][] 공간, Location 상어위치) {
        int 초 = 0;
        int 상어_먹은물고기수 = 0, 상어_크기 = 2;
        while (true) {
            Location 고기위치 = 먹을고기_찾기(공간, 상어위치, 상어_크기);
            if (고기위치 == null) return 초;
            상어위치.행 = 고기위치.행;
            상어위치.열 = 고기위치.열;
            초 += 고기위치.거리;
            상어_먹은물고기수++;
            if (상어_먹은물고기수 >= 상어_크기) {
                상어_크기++;
                상어_먹은물고기수 = 0;
            }
            공간[고기위치.행][고기위치.열] = 0;
        }
    }

    static Location 먹을고기_찾기(int[][] 공간, Location 상어위치, int 상어_크기) {
        boolean[][] 방문= new boolean[공간.length][공간.length];
        PriorityQueue<Location> queue = new PriorityQueue<>(); // 탐색 우선 순위 적용
        queue.add(상어위치);
        while (queue.size() > 0) {
            Location 위치 = queue.remove();
            int 행 = 위치.행, 열 = 위치.열, 거리 = 위치.거리;
            if (행 < 0 || 행 >= 공간.length) continue;
            if (열 < 0 || 열 >= 공간.length) continue;
            if (방문[행][열]) continue;
            방문[행][열] = true;
            if (공간[행][열] > 상어_크기) continue;
            if (공간[행][열] > 0 && 공간[행][열] < 상어_크기) return 위치;
            queue.add(new Location(행-1, 열, 거리+1));
            queue.add(new Location(행, 열-1, 거리+1));
            queue.add(new Location(행, 열+1, 거리+1));
            queue.add(new Location(행+1, 열, 거리+1));
        }
        return null;
    }

    static Location 상어찾기(int[][] 공간) {
        for (int 행 = 0; 행 < 공간.length; ++행)
            for (int 열 = 0; 열 < 공간.length; ++열)
                if (공간[행][열] == 9)
                    return new Location(행, 열, 0);
        return null;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int[][] 공간 = new int[N][N];
            for (int 행 = 0; 행 < N; ++행)
                for (int 열 = 0; 열 < N; ++열)
                    공간[행][열] = scanner.nextInt();
            Location 상어위치 = 상어찾기(공간);
            공간[상어위치.행][상어위치.열] = 0;
            System.out.println(고기찾아먹기(공간, 상어위치));
        }
    }
}