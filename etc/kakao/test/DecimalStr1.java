package kakao.test;

public class DecimalStr1 {

    // value가 양의 정수일 때만 작동함.
    static String toDecimalString(int value) {
        StringBuilder builder = new StringBuilder();
        while (value > 0) {
            int i = value % 10;
            builder.append((char)('0' + i));
            value = value / 10;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100000000; i *= 9) {
            String s = toDecimalString(i);
            System.out.printf("%9d %9s\n", i, s);
        }
    }
}