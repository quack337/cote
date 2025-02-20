package net.skhu.kakao.test;

public class BinaryStr3 {

    static String toBinaryString(int value) {
        StringBuilder builder = new StringBuilder();
        while (value != 0) {
            int digit = value & 1;
            builder.append((char)('0' + digit));
            value = value >> 1;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        for (int i = 3; i <= 3000; i *= 10) {
            String s = toBinaryString(i);
            System.out.printf("%5d %s\n", i, s);
        }
    }
}
