package net.skhu.kakao.i2021.ex2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Test1 {

    static class Solution {
        static class Location {
            int row, col, distance;

            public Location(int row, int col, int distance) {
                this.row = row;
                this.col = col;
                this.distance = distance;
            }
        }

        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];
            for (int i = 0; i < places.length; ++i) {
                // i번째 응시장을 char[][] 2차원 배열로 만든다.
                char[][] a = new char[5][];
                for (int r = 0; r < 5; ++r)
                    a[r] = places[i][r].toCharArray();
                // i번째 응시장을 검사한다
                answer[i] = solution(a);
            }
            return answer;
        }

        int solution(char[][] a) {
            for (int r = 0; r < 5; ++r)
                for (int c = 0; c < 5; ++c)
                    if (a[r][c] == 'P') // 응시자 각각에 대해서 BFS를 반복한다.
                        if (BFS(a, r, c) == false) return 0; // 거리두기 실패
            return 1; // 거리두기 성공
        }

        boolean BFS(char[][] a, int row, int col) {
            Queue<Location> queue = new ArrayDeque<>(); // BFS 탐색을 위한 queue
            boolean[][] visited = new boolean[5][5];    // 방문한 칸인지 확인하기 위한 배열
            queue.add(new Location(row, col, 0));       // 탐색 시작 위치
            while (queue.size() > 0) {
                Location p = queue.remove();            // 다음에 방문할 칸
                if (p.row < 0 || p.row >= 5) continue;  // 응시장 범위를 벗어날 수 없다
                if (p.col < 0 || p.col >= 5) continue;
                if (a[p.row][p.col] == 'X') continue;   // 파티션 칸으로 이동할 수 없다
                if (visited[p.row][p.col]) continue;    // 이미 방문한 칸이면 무시한다
                visited[p.row][p.col] = true; // 방문한 칸으로 표시한다

                // 2를 초과하는 거리의 칸부터는 거리두기 위반을 검사할 필요 없다
                if (p.distance > 2) continue;
                // 거리 0은 출발지점이고, 거리 2 이하 칸에 응시자가 있다면
                if (p.distance > 0 && a[p.row][p.col] == 'P') // 거리두기 위반
                    return false;
                queue.add(new Location(p.row - 1, p.col, p.distance + 1)); // 윗 칸 방문 예약
                queue.add(new Location(p.row + 1, p.col, p.distance + 1)); // 아래 칸 방문 예약
                queue.add(new Location(p.row, p.col - 1, p.distance + 1)); // 왼쪽 칸 방문 예약
                queue.add(new Location(p.row, p.col + 1, p.distance + 1)); // 오른쪽 칸 방문 예약
            }
            return true; // 거리두기 준수
        }
    }

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                             {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                             {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                             {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                             {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(new Solution().solution(places)));
    }
}
