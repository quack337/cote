package programmers.e118668;

import java.util.Arrays;

public class Main6 {

    static class Solution {
        int maxAlp, maxCop;
        int[][] problems;
        Integer[][] visited;

            void DFS(int alp, int cop, int distance) {
            if (alp > maxAlp) alp = maxAlp;
            if (cop > maxCop) cop = maxCop;
            if (visited[alp][cop] != null && visited[alp][cop] <= distance) return;
            visited[alp][cop] = distance;
            if (alp < maxAlp) DFS(alp + 1, cop, distance + 1);
            if (cop < maxCop) DFS(alp, cop + 1, distance + 1);
            for (int[] p : problems)
                if (p[0] <= alp && p[1] <= cop)
                    DFS(alp + p[2], cop + p[3], distance + p[4]);
        }

        public int solution(int alp, int cop, int[][] problems) {
            this.problems = problems;
            maxAlp = Arrays.stream(problems).mapToInt(p -> p[0]).max().getAsInt();
            maxCop = Arrays.stream(problems).mapToInt(p -> p[1]).max().getAsInt();
            visited = new Integer[maxAlp + 1][maxCop + 1];
            DFS(alp, cop, 0);
            return visited[maxAlp][maxCop];
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        int cost = s.solution(10, 10, new int[][] {{10,15,2,1,2},{20,20,3,3,4}});
        System.out.println(cost);
        cost = s.solution(0, 0, new int[][] {{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}});
        System.out.println(cost);
        cost = s.solution(0, 0, new int[][] {{0,0,0,2,2},{10,10,2,2,2}});
        System.out.println(cost);
    }
}