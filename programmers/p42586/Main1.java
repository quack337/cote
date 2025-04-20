package programmers.p42586;
import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {

    static class Solution {
        public int[] solution(int[] progress, int[] speed) {
            ArrayList<Integer> answer = new ArrayList<>();
            int 배포일 = (int)Math.ceil((100.0 - progress[0]) / speed[0]);
            int 배포작업수 = 1;
            for (int i = 1; i < progress.length; ++i) {
                int 마감일 = (int)Math.ceil((100.0 - progress[i]) / speed[i]);
                if (마감일 <= 배포일) ++배포작업수;
                else {
                    answer.add(배포작업수);
                    배포일 = 마감일;
                    배포작업수 = 1;
                }
            }
            answer.add(배포작업수);
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