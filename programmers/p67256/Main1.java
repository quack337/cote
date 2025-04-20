package programmers.p67256;
public class Main1 {

    static class Solution {

        static String[][] 표 = {{"1","2","3"}, {"4","5","6"}, {"7","8","9"}, {"*","0","#"}};

        int[] 좌표(String key) {
            for (int r = 0; r < 4; ++r)
                for (int c = 0; c < 3; ++c)
                    if (표[r][c].equals(key)) return new int[] {r, c};
            return null;
        }

        int 거리(String key1, String key2) {
            int[] p1 = 좌표(key1), p2 = 좌표(key2);
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }

        public String solution(int[] numbers, String hand) {
            String leftHand = "*", rightHand = "#";
            StringBuilder builder = new StringBuilder();
            for (int i : numbers) {
                String key = String.valueOf(i);
                if ("147".contains(key)) { builder.append("L"); leftHand = key; }
                else if ("369".contains(key)) { builder.append("R"); rightHand = key; }
                else {
                    int 거리L = 거리(leftHand, key);
                    int 거리R = 거리(rightHand, key);
                    if (거리L < 거리R) { builder.append("L"); leftHand = key; }
                    else if (거리L > 거리R) { builder.append("R"); rightHand = key; }
                    else {
                        if (hand.equals("left")) { builder.append("L"); leftHand = key; }
                        else { builder.append("R"); rightHand = key; }
                    }
                }
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {1,3,4,5,8,2,1,4,5,9,5}, "right"));
        System.out.println(sol.solution(new int[] {7,0,8,2,8,3,1,5,7,6,2}, "left"));
        System.out.println(sol.solution(new int[] {1,2,3,4,5,6,7,8,9,0}, "right"));
    }

}