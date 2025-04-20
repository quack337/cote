package programmers.p81305;
public class Test3b {

    static class Solution {
        int groupCount;

        int DFS(int[] values, int[][] links, int index, int 기준) {
            if (index == -1) return 0;
            int leftValue = DFS(values, links, links[index][0], 기준);
            int rightValue = DFS(values, links, links[index][1], 기준);
            while (true) {
                int sum = leftValue + rightValue + values[index];
                if (sum <= 기준) return sum;
                ++groupCount;
                if (leftValue > rightValue) leftValue = 0;
                else rightValue = 0;
            }
        }

        public int solution(int k, int[] values, int[][] links) {
            int root = (links.length - 1) * links.length / 2;
            for (int i = 0; i < links.length; ++i)
                for (int j = 0; j <= 1; ++j)
                    if (links[i][j] > 0) root -= links[i][j];
            int begin = 0, end = 0, answer = 0;
            for (int value : values) {
                begin = Math.max(begin, value);
                end += value;
            }
            while (begin <= end) {
                int middle = (begin + end) / 2;
                groupCount = 1;
                DFS(values, links, root, middle);
                if (groupCount > k) {
                    begin = middle + 1;
                } else {
                    end = middle - 1;
                    answer = middle;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int answer = sol.solution(3, new int[] {12,30,1,8,8,6,20,7,5,10,4,1},
                         new int[][] {{-1,-1},{-1,-1},{-1,-1},{-1,-1},{8,5},{2,10},{3,0},
                                      {6,1},{11,-1},{7,4},{-1,-1},{-1,-1}});
        System.out.println(answer);
        answer = sol.solution(1, new int[] {6,9,7,5}, new int[][] {{-1,-1}, {-1,-1}, {-1,0}, {2,1}});
        System.out.println(answer);
        answer = sol.solution(2, new int[] {6,9,7,5}, new int[][] {{-1,-1}, {-1,-1}, {-1,0}, {2,1}});
        System.out.println(answer);
        answer = sol.solution(4, new int[] {6,9,7,5}, new int[][] {{-1,-1}, {-1,-1}, {-1,0}, {2,1}});
        System.out.println(answer);
    }
}