package net.skhu.etc.sort;

import java.util.Arrays;

public class Example2c {

    static void sort(char[] a) {
        int count = 0;
        for (char c : a)
            if (c == '0') ++count;
        Arrays.fill(a, 0, count, '0');
        Arrays.fill(a, count, a.length, '1');
    }

    public static void main(String[] args) {
        char[] a = "010101110101".toCharArray();
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}