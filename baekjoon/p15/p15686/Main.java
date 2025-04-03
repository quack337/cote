package baekjoon.p15.p15686;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int 빈칸 = 0, 집 = 1, 치킨집 = 2;
    static int[][] 도시;
    static List<Location> 치킨집목록;

    static class Location {
        int 행, 열;
        public Location(int 행, int 열) {
            this.행 = 행;
            this.열 = 열;
        }
    }

    static List<Location> 치킨집찾기(int[][] 도시) {
        List<Location> 치킨집목록 = new ArrayList<Location>();
        for (int 행 = 0; 행 < 도시.length; ++행)
            for (int 열 = 0; 열 < 도시.length; ++열)
                if (도시[행][열] == 치킨집)
                    치킨집목록.add(new Location(행, 열));
        return 치킨집목록;
    }

    static int 집의_치킨거리(int 집행, int 집열, int[] 치킨집선택목록) {
        int 최소값 = Integer.MAX_VALUE;
        for (int i : 치킨집선택목록) {
            Location 치킨집좌표 = 치킨집목록.get(i);
            int 거리 = Math.abs(집행 - 치킨집좌표.행) + Math.abs(집열 - 치킨집좌표.열);
            if (거리 < 최소값) 최소값 = 거리;
        }
        return 최소값;
    }

    static int 치킨거리_합계(int[] 치킨집선택목록) {
        int 합계 = 0;
        for (int 행 = 0; 행 < 도시.length; ++행)
            for (int 열 = 0; 열 < 도시[0].length; ++열)
                if (도시[행][열] == 집)
                    합계 += 집의_치킨거리(행, 열, 치킨집선택목록);
        return 합계;
    }

    static int 치킨집선택(int[] 치킨집선택목록, int index) {
        if (index >= 치킨집선택목록.length)
            return 치킨거리_합계(치킨집선택목록);
        int 시작인덱스 = (index == 0) ? 0 : 치킨집선택목록[index - 1] + 1;
        int 끝인덱스 = 치킨집목록.size() - 치킨집선택목록.length + index;
        int 치킨거리_최소값 = Integer.MAX_VALUE;
        for (int i = 시작인덱스; i <= 끝인덱스; ++i) {
            치킨집선택목록[index] = i;
            int 치킨거리 = 치킨집선택(치킨집선택목록, index + 1);
            if (치킨거리 < 치킨거리_최소값) 치킨거리_최소값 = 치킨거리;
        }
        return 치킨거리_최소값;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            도시 = new int[N][];
            for (int 행 = 0; 행 < N; ++행) {
                도시[행] = new int[N];
                for (int 열 = 0; 열 < N; ++열)
                    도시[행][열] = scanner.nextInt();
            }
            치킨집목록 = 치킨집찾기(도시);
            System.out.println(치킨집선택(new int[M], 0));
        }
    }
}