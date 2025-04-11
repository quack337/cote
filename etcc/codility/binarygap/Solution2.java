package etcc.codility.binarygap;
public class Solution2 {

    public int solution(int N) {
        int count = 0, maxCount = 0, i = 0;

        while (i < 32) {
            int c = N & (1 << i);
            ++i;
            if (c != 0) break;
        }
        while (i < 32) {
            int c = N & (1 << i);
            ++i;
            if (c == 0)
                ++count;
            else {
                if (count > maxCount)
                    maxCount = count;
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int n = sol.solution(42);
        System.out.println(n);
    }
}