package net.skhu.kakao.t2020.ex1;

public class Test1 {

    static String compress(String s) {
        StringBuilder result = new StringBuilder();
        char prev = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == prev)
                ++count;
            else {
                if (count > 1) result.append(count);
                result.append(prev);
                prev = s.charAt(i);
                count = 1;
            }
        }
        if (count > 1) result.append(count);
        result.append(prev);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(compress("aaabbbcdee"));
        System.out.println(compress("aabbaccc"));
        System.out.println(compress("abbcdde"));
        System.out.println(compress("a"));
    }
}
