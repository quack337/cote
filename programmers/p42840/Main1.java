package programmers.p42840;
import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {

static class Solution {
    public int[] solution(int[] answers) {
        int[][] 패턴 = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] 점수 = new int[3];
        int 최대점수 = 0;
        for (int s = 0; s < 3; ++s) {
            for (int a = 0; a < answers.length; ++a)
                if (answers[a] == 패턴[s][a % 패턴[s].length])
                    ++점수[s];
            if (점수[s] > 최대점수) 최대점수 = 점수[s];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; ++i)
            if (점수[i] == 최대점수) list.add(i + 1);
        return list.stream().mapToInt(i -> i).toArray();
    }
}

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new int[] {1,2,3,4,5})));
        System.out.println(Arrays.toString(sol.solution(new int[] {1,3,2,4,2})));
    }

}