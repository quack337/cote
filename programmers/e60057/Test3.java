package programmers.e60057;

public class Test3 {

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