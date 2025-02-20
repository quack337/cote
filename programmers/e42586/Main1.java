package programmers.e42586;

import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {

    static class Solution {
        public int[] solution(int[] progress, int[] speed) {
            ArrayList<Integer> answer = new ArrayList<>();
            // 진행중인 작업의 마감일과 작업 수
            int 마감일 = (int)Math.ceil((100.0 - progress[0]) / speed[0]), 작업수 = 1;
            for (int i = 1; i < progress.length; ++i) {
                int 현재마감일 = (int)Math.ceil((100.0 - progress[i]) / speed[i]);
                if (현재마감일 <= 마감일) ++작업수;
                else {
                    answer.add(작업수);
                    마감일 = 현재마감일;
                    작업수 = 1;
                }
            }
            answer.add(작업수);
            return answer.stream().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {
        int[][] progress = {{93, 30, 55}, {95, 90, 99, 99, 80, 99}};
        int[][] speed = {{1, 30, 5}, {1, 1, 1, 1, 1, 1}};
        Solution sol = new Solution();
        for (int i = 0; i < progress.length; ++i)
            System.out.println(Arrays.toString(sol.solution(progress[i], speed[i])));
    }
}
