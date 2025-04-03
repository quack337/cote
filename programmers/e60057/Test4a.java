package programmers.e60057;

public class Test4a {

    static int compress(String s, int n) {
        int result = 0;
        String prev = s.substring(0, n);
        int count = 1;
        for (int i = n; i <= s.length() - n; i += n) {
            if (s.substring(i, i + n).equals(prev))
                ++count;
            else {
                if (count > 1) result += String.valueOf(count).length();
                result += n;
                prev = s.substring(i, i + n);
                count = 1;
            }
        }
        if (count > 1) result += String.valueOf(count).length();
        result += n;
        result += s.length() % n;
        return result;
    }

    static int solution(String s) {
        int min = Integer.MAX_VALUE;
        for (int n = 1; n <= s.length() / 2; ++n) {
            int length = compress(s, n);
            if (length < min) min = length;
        }
        return min == Integer.MAX_VALUE ? s.length() : min;
    }

    public static void main(String[] args) {
        String[] a = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede",
                "abcabcabcabcdededededede", "xababcdcdababcdcd", "ab", "aa", "a" };
        for (String s : a)
            System.out.println(solution(s));
    }
}