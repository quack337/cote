package net.skhu.etc.sort;

import java.util.Arrays;

public class Example2b {

    static void sort(char[] a) {
        int[] count = new int[26];
        for (int i = 0; i < a.length; ++i)
            count[a[i] - 'a']++;
        int index = 0;
        for (int i = 0; i < count.length; ++i) {
            char c = (char)('a' + i);
            for (int j = 0; j < count[i]; ++j)
                a[index++] = c;
        }
    }

    public static void main(String[] args) {
        char[] a = "helloworld".toCharArray();
        sort(a);
        System.out.println(Arrays.toString(a));
    }
}