package net.skhu.kakao.test;

public class HexStr2 {

    static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    static String toHexStr1(int value) {
        StringBuilder builder = new StringBuilder();
        for (int i = 28; i >= 0; i -= 4) {
            int t = (value >> i);
            if (t == 0) continue;
            int d = t & 0xF;
            builder.append(HEX_DIGITS[d]);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100000000; i *= 10) {
            String s = toHexStr1(i);
            System.out.printf("%9d %s\n", i, s);
        }
    }
}
