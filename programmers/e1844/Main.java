import java.util.ArrayDeque;

public class Main {
	static class Solution {
	    public int solution(int[][] maps) {
	    	final int ROWS = maps.length, COLS = maps[0].length;
	    	var queue = new ArrayDeque<int[]>();
	    	var visited = new boolean[ROWS][COLS];
	    	queue.add(new int[] {0, 0, 1});
	    	while (queue.size() > 0) {
	    		int[] pos = queue.remove();
	    		int r = pos[0], c = pos[1], distance = pos[2];
	    		if (r == ROWS-1 && c == COLS-1) return distance;
	    		if (maps[r][c] != 1) continue;
	    		if (visited[r][c]) continue;
	    		visited[r][c] = true;
	    		if (r > 0) queue.add(new int[] {r-1, c, distance+1});
	    		if (c > 0) queue.add(new int[] {r, c-1, distance+1});
	    		if (r < ROWS-1) queue.add(new int[] {r+1, c, distance+1});
	    		if (c < COLS-1) queue.add(new int[] {r, c+1, distance+1});
	    	}
	    	return -1;
	    }
	}

	public static void main(String[] args) {
		var map1 = new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		var map2 = new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		var s = new Solution();
		System.out.println(s.solution(map1));
		System.out.println(s.solution(map2));
	}
}