package etcc.codility.binarygap;
public class Solution1 {

    public int solution(int N) {
        int count = 0, maxCount = 0;
        String binaryString = Integer.toBinaryString(N);

        for (int i = 0; i < binaryString.length(); ++i) {
            char c = binaryString.charAt(i);
            if (c == '0')
                ++count;
            else {
                if (count > maxCount) maxCount = count;
                count = 0;
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int n = sol.solution(1041);
        System.out.println(n);
    }
}