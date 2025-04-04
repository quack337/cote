package programmers.p77485;

import java.util.Arrays;

public class Main1 {

	static class Solution {
		int[][] A;

		int rotate(int r1, int c1, int r2, int c2) {
			int r = r1, c = c1, value = A[r][c], min = A[r][c];

			while (true) {
				// 한 칸 전진
				if (r == r1 && c < c2) ++c; // 윗쪽 테두리
				else if (c == c2 && r < r2) ++r; // 오른쪽 테두리
				else if (r == r2 && c > c1) --c; // 아래쪽 테두리
				else if (c == c1 && r > r1) --r; // 왼쪽 테두리

				// 값 이동
				int temp = A[r][c]; // 현재 칸의 값 보관
				A[r][c] = value; // 이전 칸의 값 대입
				value = temp; // 보관했던 값이 다음 칸에 대입할 값이다
				if (value < min) min  = value;

				// 한 바퀴 돌았으면 끝
				if (r == r1 && c == c1) break;
			}
			return min;
		}

	    public int[] solution(int rows, int columns, int[][] queries) {
	    	A = new int[rows][columns];
	    	for (int r = 0; r < rows; ++r)
	    		for (int c = 0; c < columns; ++c)
	    			A[r][c] = (r * columns) + c + 1;
	    	int[] answer = new int[queries.length];
	        for (int i = 0; i < queries.length; ++i)
	        	answer[i] = rotate(queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
	        return answer;
	    }
	}

	public static void main(String[] args) {
		var s = new Solution();
		int[] a = s.solution(6, 6, new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}});
		System.out.println(Arrays.toString(a));

		a = s.solution(3, 3, new int[][] {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}});
		System.out.println(Arrays.toString(a));

		a = s.solution(100, 97, new int[][] {{1,1,100,97}});
		System.out.println(Arrays.toString(a));
	}

}