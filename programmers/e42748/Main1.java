import java.util.ArrayList;
import java.util.Arrays;

public class Main1 {

    static class Solution {
    public int[] solution(int[] array, int[][] cmd) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < cmd.length; ++i) {
            int from = cmd[i][0] - 1, to = cmd[i][1], index = cmd[i][2] - 1;
            int[] a = Arrays.copyOfRange(array, from, to);
            Arrays.sort(a);
            answer.add(a[index]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] cmd = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(array, cmd)));
    }
}