package programmers.e12953;

public class Main {

    static class Solution {

        int 최대공약수(int a, int b){
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            return a;
        }

        int 최소공배수(int a, int b) {
            return a * b / 최대공약수(a, b);
        }

        public int solution(int[] a) {
            int result = a[0];
            for (int i = 1; i < a.length; ++i)
                result = 최소공배수(result, a[i]);
            return result;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(new int[] {2,6,8,14}));
        System.out.println(sol.solution(new int[] {1,2,3}));
    }

}