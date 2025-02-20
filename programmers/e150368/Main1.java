package programmers.e150368;

import java.util.Arrays;

public class Main1 {

    static class Solution {
        int[][] users;
        int[] emoticons, sales;
        int 최대가입자 = 0, 최대판매액 = 0;

        void 최대가입자찾기() {
            int 가입자 = 0, 판매액 = 0;
            for (var user : users) {
                int 구매금액 = 0;
                for (int i = 0; i < emoticons.length; ++i)
                    if (sales[i] >= user[0])
                        구매금액 += emoticons[i] * (100 - sales[i]) / 100;
                if (구매금액 >= user[1]) ++가입자;
                else 판매액 += 구매금액;
            }
            if (가입자 > 최대가입자) {
                최대가입자 = 가입자;
                최대판매액 = 판매액;
            } else if (가입자 == 최대가입자)
                최대판매액 = Math.max(최대판매액, 판매액);
        }

        void 완전탐색(int index) {
            if (index == sales.length) {
                최대가입자찾기();
                return;
            }
            for (int sale = 10; sale <= 40; sale += 10) {
                sales[index] = sale;
                완전탐색(index + 1);
            }
        }

        public int[] solution(int[][] users, int[] emoticons) {
            this.users = users;
            this.emoticons = emoticons;
            this.sales = new int[emoticons.length];
            완전탐색(0);
            return new int[] { 최대가입자, 최대판매액 };
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var users = new int[][] {{40, 10000}, {25, 10000}};
        var emoticons = new int[] {7000, 9000};
        System.out.println(Arrays.toString(sol.solution(users, emoticons)));
        users = new int[][] {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        emoticons = new int[] {1300, 1500, 1600, 4900};
        System.out.println(Arrays.toString(sol.solution(users, emoticons)));
    }
}
