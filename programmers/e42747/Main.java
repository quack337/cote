import java.util.Arrays;

public class Main {
    static class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);
            for (int h = citations.length; h > 0; --h)
              if (citations[citations.length - h] >= h)
                return h;
            return 0;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(new int[] {3,0,6,1,5}));
        System.out.println(sol.solution(new int[] {3,3}));
        System.out.println(sol.solution(new int[] { }));
    }
}