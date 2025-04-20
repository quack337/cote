package programmers.p81305;
import java.util.Arrays;

public class Test1 {

    static class Solution {

        void solution(boolean[] selected, int selectedCount, int index, int k) {
            if (selectedCount == k - 1) {
                System.out.println(Arrays.toString(selected));
                return;
            }
            if (index == selected.length) return;
            solution(selected, selectedCount, index + 1, k);

            boolean[] selected1 = selected.clone();
            selected1[index] = true;
            solution(selected1, selectedCount + 1, index + 1, k);
        }

        public int solution(int k, int[] num, int[][] links) {
            solution(new boolean[num.length], 0, 0, k);
            int answer = 0;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution(3, new int[] {12,30,1,8,8,6,20,7,5,10,4,1},
                     new int[][] {{-1,-1},{-1,-1},{-1,-1},{-1,-1},{8,5},
                                  {2,10},{3,0},{6,1},{11,-1},{7,4},{-1,-1},{-1,-1}});
    }
}