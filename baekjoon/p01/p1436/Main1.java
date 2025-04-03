package baekjoon.p01.p1436;

import java.io.IOException;

public class Main1 {
    static boolean 종말숫자1(int i) {
        String s = String.valueOf(i);
        return s.indexOf("666") >= 0;
    }

    static boolean 종말숫자2(int i) {
        while (i >= 666) {
            if (i % 1000 == 666) return true;
            i /= 10;
        }
        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        for (int i = 0; i < 1000000000; ++i)
            if (종말숫자1(i) != 종말숫자2(i))
                System.out.println(i);
    }
}