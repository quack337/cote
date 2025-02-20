package baekjoon.p17.p17142;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Location {
        int 행, 열, 거리;
        public Location(int 행, int 열, int 거리) {
            this.행 = 행;
            this.열 = 열;
            this.거리 = 거리;
        }
    }

    static final int 빈칸 = 0, 벽 = 1, 바이러스 = 2;
    static int N, 바이러스_선택수, 빈칸수;
    static int[][] 연구소;
    static List<Location> 바이러스목록;

    static List<Location> 바이러스찾기() {
        List<Location> 목록 = new ArrayList<>();
        for (int 행 = 0; 행 < N; ++행)
            for (int 열 = 0; 열 < N; ++열)
                if (연구소[행][열] == 바이러스)
                    목록.add(new Location(행, 열, 0));
        return 목록;
    }

    static int 바이러스선택(List<Location> 바이러스선택목록, int index) {
        if (바이러스선택목록.size() >= 바이러스_선택수) // 선택 완료
            return 바이러스전파(바이러스선택목록);
        if (index >= 바이러스목록.size()) // 바이러스_선택수 만큼 선택 실패
            return Integer.MAX_VALUE;
        int 전파시간1 = 바이러스선택(바이러스선택목록, index + 1);
        바이러스선택목록.add(바이러스목록.get(index));
        int 전파시간2 = 바이러스선택(바이러스선택목록, index + 1);
        바이러스선택목록.remove(바이러스선택목록.size() - 1);
        return Math.min(전파시간1, 전파시간2);
    }

    static int 바이러스전파(List<Location> 바이러스선택목록) {
        boolean[][] 방문한칸 = new boolean[N][N];
        Queue<Location> queue = new LinkedList<>();
        for (Location 위치 : 바이러스선택목록)
            queue.add(위치);
        int 전파수 = 0;
        while (queue.size() > 0) {
            Location 위치 = queue.remove();
            int 행 = 위치.행, 열 = 위치.열, 거리 = 위치.거리;
            if (행 < 0 || 행 >= N) continue;
            if (열 < 0 || 열 >= N) continue;
            if (연구소[행][열] == 벽 || 방문한칸[행][열]) continue;
            방문한칸[행][열] = true;
            if (연구소[행][열] == 빈칸) ++전파수;
            if (전파수 == 빈칸수) return 거리;
            queue.add(new Location(행+1, 열, 거리+1));
            queue.add(new Location(행-1, 열, 거리+1));
            queue.add(new Location(행, 열+1, 거리+1));
            queue.add(new Location(행, 열-1, 거리+1));
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            N = scanner.nextInt();
            바이러스_선택수 = scanner.nextInt();
            연구소 = new int[N][N];
            for (int 행 = 0; 행 < N; ++행)
                for (int 열 = 0; 열 < N; ++열) {
                    연구소[행][열] = scanner.nextInt();
                    if (연구소[행][열] == 빈칸) ++빈칸수;
                }
            바이러스목록 = 바이러스찾기();
            int 전파시간 = 바이러스선택(new ArrayList<Location>(), 0);
            if (전파시간 == Integer.MAX_VALUE) 전파시간 = -1;
            System.out.println(전파시간);
        }
    }
}


