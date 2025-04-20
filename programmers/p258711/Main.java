package programmers.p258711;
import java.util.Arrays;

public class Main {

    static class Solution {
        static final int 생성 = 0, 도넛 = 1, 막대 = 2, 팔자 = 3;
        int[] answer = new int[4];
        boolean[] visited;
        int[] out, in;
        int[][] children;
        int start;

        void DFS(int i, boolean first, int maxOut) {
            if (first) start = i;
            if (visited[i]) {
                if (i == start && maxOut == 1)
                    answer[도넛]++;
                return;
            }
            visited[i] = true;
            if (out[i] > maxOut) maxOut = out[i];
            if (out[i] == 0) answer[막대]++;
            else if (out[i] == 2) answer[팔자]++;
            for (int child : children[i])
                if (child != 0) DFS(child, false, maxOut);
        }

        public int[] solution(int[][] edges) {
            int N = 0;
            for (int[] edge : edges) {
                if (edge[0] > N) N = edge[0];
                if (edge[1] > N) N = edge[1];
            }
            visited = new boolean[N + 1];
            out = new int[N + 1];
            in = new int[N + 1];
            children = new int[N + 1][2];
            for (int[] edge : edges) {
                int from = edge[0], to = edge[1];
                if (out[from] >= 2) continue;
                children[from][out[from]] = to;
                out[from]++;
                in[to]++;
            }
            for (int i = 1; i <= N; ++i) {
                if (visited[i]) continue;
                if (out[i] >= 2 && in[i] == 0) answer[생성] = i;
                else DFS(i, true, 0);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(
          new int[][]{{2, 3}, {4, 3}, {1, 1}, {2, 1}})));
        System.out.println(Arrays.toString(new Solution().solution(
          new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11},
          {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1},
          {5, 3}, {11, 9}, {3, 8}})));
    }
}