package programmers.p388352;
public class Main2 {

    static class Solution {

        boolean check(int[][] q, int[] ans, int a, int b, int c, int d, int e) {
            for (int i = 0; i < q.length; ++i) {
                int count = 0;
                for (int j = 0; j < 5; ++j) {
                    int v = q[i][j];
                    if (v == a || v == b || v == c || v == d || v == e)
                        ++count;
                }
                if (count != ans[i]) return false;
            }
            return true;
        }

        public int solution(int n, int[][] q, int[] ans) {
            int answer = 0;
            for (int a = 1; a <= n - 4; ++a)
            for (int b = a + 1; b <= n - 3; ++b)
            for (int c = b + 1; c <= n - 2; ++c)
            for (int d = c + 1; d <= n - 1; ++d)
            for (int e = d + 1; e <= n; ++e)
                if (check(q, ans, a, b, c, d, e))
                    ++answer;
            return answer;
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10}, {2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2, 3, 4, 3, 3};
        int answer = (new Solution()).solution(n, q, ans);
        System.out.println(answer);

        n = 15;
        q = new int[][] {{2, 3, 9, 12, 13}, {1, 4, 6, 7, 9}, {1, 2, 8, 10, 12}, {6, 7, 11, 13, 15}, {1, 4, 10, 11, 14}};
        ans = new int[] {2, 1, 3, 0, 1};
        answer = (new Solution()).solution(n, q, ans);
        System.out.println(answer);
    }
}