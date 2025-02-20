package net.skhu.line.e2018;

import java.util.Scanner;

public class RLE1 {

    public static void convert(String s) {
        char prev = 0; // 현재 문자
        int count = 0; // 현재 문자가 반복된 수
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == prev) // 동일한 문자를 만나면 count 증가
                ++count;
            else { // 새 문자를 만나면, 기존의 문자와 count 출력
                if (count > 0)
                    System.out.printf("%d%c", count, prev);
                prev = c;  // 문자와 count 초기화
                count = 1;
            }
        }
        System.out.printf("%d%c", count, prev); // 마지막 문자 출력
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int count = scanner.nextInt();
            for (int i = 0; i < count; ++i) {
                String s = scanner.next();
                convert(s);
            }
        }
    }
}
