package programmers.p118668;
public class Main1 {

    static class Solution {
        int maxAlp = 0, maxCop = 0;
        int[][] problems;
        long count = 0;

        int 완전탐색(int alp, int cop) {
            System.out.printf("%d: %d %d\n", ++count, alp, cop);
            if (alp >= maxAlp && cop >= maxCop) return 0;
            int cost = Integer.MAX_VALUE;
            if (alp < maxAlp) cost = Math.min(cost, 1 + 완전탐색(alp + 1, cop));
            if (cop < maxCop) cost = Math.min(cost, 1 + 완전탐색(alp, cop + 1));
            for (int[] p : problems)
                if (p[0] <= alp && p[1] <= cop)
                    cost = Math.min(cost, p[4] + 완전탐색(alp + p[2], cop + p[3]));
            return cost;
        }

        public int solution(int alp, int cop, int[][] problems) {
            this.problems = problems;
            maxAlp = maxCop = 0;
            for (int[] p : problems) {
                maxAlp = Math.max(maxAlp, p[0]);
                maxCop = Math.max(maxCop, p[1]);
            }
            return 완전탐색(alp, cop);
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        int cost = s.solution(10, 10, new int[][] {{10,15,2,1,2},{20,20,3,3,4}});
        System.out.println(cost);
        cost = s.solution(0, 0, new int[][] {{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}});
        System.out.println(cost);
    }
}