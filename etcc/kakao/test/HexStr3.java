package etcc.kakao.test;
public class HexStr3 {

    static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    static String toHexStr1(int value) {
        StringBuilder builder = new StringBuilder();
        while (value != 0) {
            int digit = value & 0xF;
            builder.append(HEX_DIGITS[digit]);
            value = value >> 4;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100000000; i *= 10) {
            String s = toHexStr1(i);
            System.out.printf("%9d %s\n", i, s);
        }
    }
}