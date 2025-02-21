package programmers.unknown;

public class BorderCount {

    // 경계선 찾기 재귀호출
    static int DFS(int[][] map, int r, int c) {
        // 현재 칸이 1이 아니라면, 즉 범위를 벗어났거나 0인 칸이라면,
        // 부모 칸 주변의 경계선 하나를 넘어간 것이니 1을 리턴한다
        if (r < 0 || r >= map.length) return 1;
        if (c < 0 || c >= map[0].length) return 1;
        if (map[r][c] == 0) return 1;

        if (map[r][c] == 2) return 0; // 이미 방문한 칸이면 그냥 나간다
        map[r][c] = 2; // 방문한 칸 표시하기

        // 위, 아래, 좌, 우 칸들에 대한 재귀호출
        return DFS(map, r-1, c) + DFS(map, r+1, c) + DFS(map, r, c-1) + DFS(map, r, c+1);
    }

    static int solution(int[][] map) {
        int answer = 0;
        for (int r = 0; r < map.length; ++r)
        for (int c = 0; c < map[0].length; ++c)
            // 아직 방문하지 않은 칸이면 방문한다
            // 이미 방문한 칸이면, map[r][c] 값이 2로 바뀌어 잇다
            if (map[r][c] == 1)
                answer += DFS(map, r, c);
        return answer;
    }

    public static void main(String[] args) {
        var map1 = new int[][] {{0,0,1,0,0},{0,1,1,0,1},{0,0,1,0,1},{1,1,1,0,1}};
        System.out.println(solution(map1));

        var map2 = new int[][] {{1,0,1,1},{0,0,1,1},{1,1,0,1},{1,1,0,0}};
        System.out.println(solution(map2));
    }
}