package net.skhu.kakao.test;

public class DecimalStr2 {

    // value가 음수일 때에도 작동하도록 코드 추가
    static String toDecimalString(int value) {
        StringBuilder builder = new StringBuilder();
        boolean minus = (value < 0);
        if (minus) value = value * -1;
        while (value > 0) {
            int i = value % 10;
            builder.append((char)('0' + i));
            value = value / 10;
        }
        if (minus) builder.append('-');
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        for (int i = 1; Math.abs(i) <= 100000000; i *= -9) {
            String s = toDecimalString(i);
            System.out.printf("%9d %9s\n", i, s);
        }
    }
}