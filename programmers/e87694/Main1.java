public class Main1 {

/* 실패
    static class Solution {
        static final int EMPTY = 0, VISITED = 1,
                         NW = 2, N = 3, NE = 4,
                         W = 5, IN = 6, E = 7,
                         SW = 8, S = 9, SE = 10;

        boolean 가장자리인가(char[][] map, int x, int y) {
            int value = map[x][y];
            return value != IN && NW <= value && value <= SE;
        }

        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            char[][] map = new char[50][50];
            for (int[] r : rectangle) {
                int x1 = r[0]-1, y1 = r[1]-1, x2 = r[2]-1, y2 = r[3]-1;
                for (int x = x1; x <= x2; ++x)
                    for (int y = y1; y <= y2; ++y)
                        map[x][y] = RECT;
            }
            var queue = new ArrayDeque<int[]>();
            queue.add(new int[] { characterX-1, characterY-1, 0 });
            while (queue.size() > 0) {
                int[] current = queue.remove();
                int x = current[0], y = current[1], distance = current[2];
                if (x == itemX-1 && y == itemY-1) return distance;
                if (x < 0 || x >= 50 || y < 0 || y >= 50) continue;
                if (map[x][y] == VISITED) continue;
                if (가장자리인가(map, x, y) == false) continue;
                System.out.printf("%d %d %d\n", x+1, y+1, distance);
                map[x][y] = VISITED;
                queue.add(new int[] { x - 1, y, distance + 1});
                queue.add(new int[] { x + 1, y, distance + 1});
                queue.add(new int[] { x, y - 1, distance + 1});
                queue.add(new int[] { x, y + 1, distance + 1});
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        int[][] rectangles1 = new int[][] {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        System.out.println(sol.solution(rectangles1, 1, 3, 7, 8));
        //int[][] rectangles2 = new int[][] {{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}};
        //System.out.println(sol.solution(rectangles2, 9, 7, 6, 1));
    }
*/
}