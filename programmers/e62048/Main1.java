public class Main1 {

    static class Solution {

        static int GCD(int a, int b){
            while (b != 0) {
                int t = a % b;
                a = b;
                b = t;
            }
            return a;
        }

        public long solution(int w, int h) {
            return (long)w * h - (w + h - GCD(w, h));
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(8, 12));
    }

}