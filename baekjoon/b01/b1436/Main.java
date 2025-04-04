package baekjoon.b01.b1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean 종말숫자(int i) {
        String s = String.valueOf(i);
        return s.indexOf("666") >= 0;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        reader.close();
        int count = 1, i = 666;
        while (count < N) {
            ++i;
            if (종말숫자(i)) ++count;
        }
        System.out.println(i);
    }
}