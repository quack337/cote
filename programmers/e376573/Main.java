package programmers.e376573;

public class Main {

    static class Solution1 {

        public int solution(int n) {
            int result = 0;
            while (n > 0) {
                int 몫 = n / 3;
                int 나머지 = n % 3;
                n = 몫;
                result = result * 3 + 나머지;
            }
            return result;
        }
    }

    static class Solution2 {
        public int solution(int[] a, int[] b) {
            int answer = 0;
            for (int i = 0; i < a.length; ++i)
                answer += a[i] * b[i];
            return answer;
        }
    }

    public static void main(String[] args) {
        var s1 = new Solution1();
        System.out.println(s1.solution(45));
        System.out.println(s1.solution(125));

        var s2 = new Solution2();
        System.out.println(s2.solution(new int[] {1,2,3,4}, new int[] {-3,-1,0,2}));
        System.out.println(s2.solution(new int[] {-1,0,1}, new int[] {1,0,-1}));
    }
}