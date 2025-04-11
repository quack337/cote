package etcc.kakao.test;
public class BinaryStr1 {

    static String toBinaryString(short value) {
        StringBuilder builder = new StringBuilder();
        for (int i = 15; i >= 0; --i) {
            char c = ((value >> i) & 1) == 1 ? '1' : '0';
            builder.append(c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        for (short i = 3; i <= 3000; i *= 10) {
            String s = toBinaryString(i);
            System.out.printf("%5d %s\n", i, s);
        }
    }
}