package naver.a2020;

public class Exam1 {

    static String solution(int n, int[] 생산, int[] 주문) {
        int 가격 = 100, 재고 = 0, 매출 = 0, 일;
        for (일 = 0; 일 < n && 가격 >= 25; ++일) {
            재고 += 생산[일];
            if (재고 >= 주문[일]) {
                매출 += 주문[일] * 가격;
                재고 -= 주문[일];
                가격 = 100;
            } else
                가격 /= 2;
        }
        return String.format("%.2f", (double)매출 / 일);
    }

    public static void main(String[] args) {
        int[][] a = new int[][] {{5, 4, 7, 2, 0, 6}, {4, 6, 4, 9, 2, 3}};
        int[][] b = new int[][] {{6, 2, 1, 0, 2, 4, 3}, {3, 6, 6, 2, 3, 7, 6}};
        System.out.println(solution(a[0].length, a[0], a[1]));
        System.out.println(solution(b[0].length, b[0], b[1]));
    }
}