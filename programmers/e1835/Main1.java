public class Main1 {

    static class Solution {
        static final String 프렌즈목록 = "ACFJMNRT";

        int 완전탐색(int index, char[] 배치) {
            if (index == 배치.length) return 1;
            char 프렌즈 = 프렌즈목록.charAt(index);
            int 경우의수 = 0;
            for (int i = 0; i < 배치.length; ++i)
                if (배치[i] == 0) {
                    배치[i] = 프렌즈;
                    경우의수 += 완전탐색(index + 1, 배치);
                    배치[i] = 0;
                }
            return 경우의수;
        }

        public int solution(int n, String[] data) {
            return 완전탐색(0, new char[8]);
        }
    }

    public static void main(String[] args) {
        var s = new Solution();
        System.out.println(s.solution(0, null));
    }
}