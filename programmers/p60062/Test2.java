package programmers.p60062;
import java.io.PrintStream;
import java.util.Arrays;

public class Test2 {

    static class Solution {
        int 외벽길이;
        int[] 친구목록, 취약점목록;

        void cover(int 출발index, int 친구거리, boolean[] covered2) {
            for (int j = 출발index; j < 취약점목록.length; ++j) {
                int 거리 = 취약점목록[j] - 취약점목록[출발index];
                if (거리 <= 친구거리) covered2[j] = true;
                else break;
            }
            if (취약점목록[출발index] + 친구거리 >= 외벽길이) {
                int 남은거리 = (취약점목록[출발index] + 친구거리) - 외벽길이;
                for (int j = 0; j < 취약점목록.length; ++j) {
                    int 거리 = 취약점목록[j];
                    if (거리 <= 남은거리) covered2[j] = true;
                    else break;
                }
            }
        }

        int 남은취약점수(boolean[] covered2) {
            int count = 0;
            for (boolean f : covered2)
                if (!f) ++count;
            return count;
        }

        int solution(int 친구index, boolean[] covered) {
            if (친구index < 0) return Integer.MAX_VALUE;
            int 최소값 = Integer.MAX_VALUE;
            int 친구거리 = 친구목록[친구index];
            for (int i = 0; i < covered.length; ++i) {
                if (covered[i]) continue;
                boolean[] covered2 = Arrays.copyOf(covered, covered.length);
                cover(i, 친구거리, covered2);
                if (남은취약점수(covered2) == 0)
                    return 친구목록.length - 친구index;
                else {
                    int r = solution(친구index - 1, covered2);
                    if (r < 최소값) 최소값 = r;
                }
            }
            return 최소값;
        }

        public int solution(int n, int[] weak, int[] dist) {
            외벽길이 = n; 취약점목록 = weak; 친구목록 = dist;
            Arrays.sort(친구목록);
            int r = solution(친구목록.length - 1, new boolean[취약점목록.length]);
            return r == Integer.MAX_VALUE ? -1 : r;
        }
    }

    public static void main(String[] args) {
        PrintStream o = System.out;
        Solution s= new Solution();
        o.println(s.solution(12, new int[] { 1, 5, 6, 10 }, new int[] { 1, 2, 3, 4 })); // 2
        o.println(s.solution(12, new int[] {1, 3, 4, 9, 10}, new int[] {3, 5, 7}));  // 1
        o.println(s.solution(1, new int[] {0}, new int[] {1}));     // 1
        o.println(s.solution(1, new int[] {0}, new int[] {3}));     // 1
        o.println(s.solution(2, new int[] {0,1}, new int[] {1}));   // 1
        o.println(s.solution(2, new int[] {1}, new int[] {1}));     // 1
        o.println(s.solution(3, new int[] {0,1,2}, new int[] {1})); // -1
        o.println(s.solution(3, new int[] {1,2}, new int[] {1}));   // 1
        o.println(s.solution(3, new int[] {0,2}, new int[] {1}));   // 1
        o.println(s.solution(3, new int[] {0,2}, new int[] {1}));   // 1
    }
}