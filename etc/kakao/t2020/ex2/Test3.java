package net.skhu.kakao.t2020.ex2;

public class Test3 {
    static boolean wellFormed(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += (c == '(') ? 1 : -1;
            if (count < 0) return false;
        }
        return count == 0;
    }

    static String solution(String s) {
        if (s.length() == 0) return s;               // 1
        int count = 0, i;                            // 1
        for (i = 0; i < s.length(); ++i) {           // 2
            count += (s.charAt(i) == '(') ? 1 : -1;  // 2
            if (count == 0) break;                   // 2
        }
        String u = s.substring(0, i + 1);            // 2
        String v = s.substring(i + 1);               // 2
        if (wellFormed(u)) return u + solution(v);   // 3, 3-1
        var r = "(" + solution(v) + ")" +            // 4-2, 4-3
               u.substring(1, u.length()-1).replace('(', '_') // 4-4
                .replace(')', '(').replace('_', ')');         // 4-4
        return r;   // 4-5
    }

    public static void main(String[] args) {
        String[] a = { "(()())()", ")(", "()", "()))((()", "()(())()", "))(("};
        for (String s : a)
            System.out.printf("%s => %s\n", s, solution(s));
    }
}
