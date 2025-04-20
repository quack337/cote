package programmers.p81302;
import java.util.Arrays;

public class Test2 {

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
                    if (a[r][c] == 'P') { // 응시자 각각에 대해서 DFS를 반복한다.
                        boolean[][] visited = new boolean[5][5];  // 방문한 칸인지 확인하기 위한 배열
                        if (DFS(a, visited, r, c, 0) == false) return 0; // 거리두기 실패
                    }
            return 1; // 거리두기 성공
        }

        boolean DFS(char[][] a, boolean[][] visited, int row, int col, int distance) {
            if (distance > 2) return true; // 거리 2 초과 칸들은 검사할 필요 없다
            if (row < 0 || row >= 5) return true; // 응시장 범위를 벗어날 수 없다
            if (col < 0 || col >= 5) return true;
            if (a[row][col] == 'X') return true;  // 파티션 칸으로 이동할 수 없다
            if (visited[row][col]) return true;  // 이미 방문한 칸이면 무시한다
            visited[row][col] = true; // 방문한 칸으로 표시한다
            if (distance > 0 && a[row][col] == 'P') return false; // 거리두기 위반
            if (DFS(a, visited, row - 1, col, distance + 1) == false) return false;
            if (DFS(a, visited, row + 1, col, distance + 1) == false) return false;
            if (DFS(a, visited, row, col - 1, distance + 1) == false) return false;
            if (DFS(a, visited, row, col + 1, distance + 1) == false) return false;
            return true;
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