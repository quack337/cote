package net.skhu.brother;

public class Exam03 {

    static boolean isLowerCase(char c) { return 'a' <= c && c <= 'z'; }
    static boolean isUpperCase(char c) { return 'A' <= c && c <= 'Z'; }

    static boolean isAlphabetic(char c) {
        return isLowerCase(c) || isUpperCase(c);
    }

    static char convert(char c) {
        if (isLowerCase(c)) return (char)('z' - (c - 'a'));
        if (isUpperCase(c)) return (char)('Z' - (c - 'A'));
        return c;
    }

    public static String solution(String word) {
        char[] a = word.toCharArray();
        for (int i = 0; i < a.length; ++i)
            a[i] = convert(a[i]);
        return new String(a);
    }

    public static void main(String[] args) {
        System.out.println(solution("I love you"));
    }
}
