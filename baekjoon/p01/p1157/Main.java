package baekjoon.p01.p1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int[] count = new int['Z' - 'A' + 1]; // 각 알파벳의 수를 세기 위한 배열
        int maxIndex = 0;                     // count 배열에서 최대값의 인덱스
        for (char c : s.toUpperCase().toCharArray())
            if (++count[c - 'A'] > count[maxIndex])
                maxIndex = c - 'A';
        int maxCount = 0;                    // count 배열에서 최대값이 몇 개인지
        for (int i = 0; i < count.length; ++i)
            if (count[i] == count[maxIndex])
                ++maxCount;
        System.out.printf("%c\n", maxCount > 1 ? '?' : 'A' + maxIndex);
    }
}
