package net.skhu.line.e2021fintech;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Main2 {

    static class 기록 {
        int 가격, 수량;

        public 기록(int 가격, int 수량) {
            this.가격 = 가격;
            this.수량 = 수량;
        }
    }

    static int 매출원가계산(String[] record, boolean 선입) {
        int 매출원가 = 0;
        ArrayDeque<기록> 구입 = new ArrayDeque<>();
        for (String r : record) {
            String[] a = r.split(" ");
            int 가격 = Integer.valueOf(a[1]);
            int 수량 = Integer.valueOf(a[2]);
            if (a[0].equals("P")) { // if 구입이면
                if (선입) 구입.addLast(new 기록(가격, 수량)); // 선입선출
                else 구입.addFirst(new 기록(가격, 수량)); // 후입선출
            }
            else { // else if 판매기록이면
                while (수량 > 0) {
                    if (구입.getFirst().수량 >= 수량) {
                        매출원가 += (수량 * 구입.getFirst().가격);
                        구입.getFirst().수량 -= 수량;
                        수량 = 0;
                    } else {
                        매출원가 += (구입.getFirst().수량 * 구입.getFirst().가격);
                        수량 -= 구입.getFirst().수량;
                        구입.getFirst().수량 = 0;
                    }
                    if (구입.getFirst().수량 == 0) 구입.removeFirst();
                }
            }
        }
        return 매출원가;
    }

    static int[] solution(String[] record) {
        return new int[] { 매출원가계산(record, true), 매출원가계산(record, false) };
    }

    public static void main(String[] args) {
        String[][] records = {{"P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"},
                {"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"},
                {"P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"}};
        for (String[] record : records)
            System.out.println(Arrays.toString(solution(record)));
    }

}
