package programmers.p388353;
public class Main {

    static class Solution {
        void clear(char[][] map, char ch, int row, int col, boolean[][] visited) {
            if (row < 0 || col < 0 || row >= map.length || col >= map[0].length) return;
            if (visited[row][col]) return;
            visited[row][col] = true;
            if (map[row][col] == 0) {
                clear(map, ch, row - 1, col, visited);
                clear(map, ch, row + 1, col, visited);
                clear(map, ch, row, col - 1, visited);
                clear(map, ch, row, col + 1, visited);
            } else if (map[row][col] == ch)
                map[row][col] = 0;
        }

        public int solution(String[] storage, String[] requests) {
            char[][] map = java.util.Arrays.stream(storage).map(s -> s.toCharArray()).toArray(char[][]::new);
            for (String req : requests) {
                if (req.length() == 2) {
                    for (int r = 0; r < map.length; ++r)
                    for (int c = 0; c < map[0].length; ++c)
                        if (map[r][c] == req.charAt(0)) map[r][c] = 0;
                } else {
                    var visited = new boolean[map.length][map[0].length];
                    for (int r = 0; r < map.length; ++r) {
                        clear(map, req.charAt(0), r, 0, visited);
                        clear(map, req.charAt(0), r, map[0].length - 1, visited);
                    }
                    for (int c = 0; c < map[0].length; ++c) {
                        clear(map, req.charAt(0), 0, c, visited);
                        clear(map, req.charAt(0), map.length - 1, c, visited);
                    }
                }
            }
            int answer = 0;
            for (int r = 0; r < map.length; ++r)
            for (int c = 0; c < map[0].length; ++c)
                if (map[r][c] != 0) ++answer;
            return answer;
        }
    }

    public static void main(String[] args) {
        var storage = new String[] {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        var requests = new String[] {"A", "BB", "A"};
        int answer = (new Solution()).solution(storage, requests);
        System.out.println(answer);

        storage = new String[] {"HAH", "HBH", "HHH", "HAH", "HBH"};
        requests = new String[] {"C", "B", "B", "B", "B", "H"};
        answer = (new Solution()).solution(storage, requests);
        System.out.println(answer);
    }
}