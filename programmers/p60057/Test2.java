package programmers.p60057;

public class Test2 {

    static String compress(String s, int n) {
        StringBuilder result = new StringBuilder();
        String prev = s.substring(0, n);
        int count = 1;
        for (int i = n; i <= s.length() - n; i += n) {
            if (s.substring(i, i + n).equals(prev))
                ++count;
            else {
                if (count > 1) result.append(count);
                result.append(prev);
                prev = s.substring(i, i + n);
                count = 1;
            }
        }
        if (count > 1) result.append(count);
        result.append(prev);
        int tail = s.length() % n;
        if (tail > 0) result.append(s.substring(s.length() - tail));
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abcabcabcabcdededededede";
        System.out.println(compress(s, 2));
        System.out.println(compress(s, 3));
        System.out.println(compress(s, 4));
        System.out.println(compress(s, 6));

        System.out.println(compress("aabbaccc", 1));
        System.out.println(compress("ababcdcdababcdcd", 8));
        System.out.println(compress("abcabcdede", 3));
        System.out.println(compress("xababcdcdababcdcd", 2));
    }
}