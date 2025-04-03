package programmers.e60058;

public class Test2 {

    static boolean wellFormed(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += (c == '(') ? 1 : -1;
            if (count < 0) return false;
        }
        return count == 0;
    }

    static String solution(String s) {
        if (s.length() == 0) return s; // 1
        int count = 0, i;                            // 1
        for (i = 0; i <= s.length(); ++i) {          // 2
            count += (s.charAt(i) == '(') ? 1 : -1;  // 2
            if (count == 0) break;                   // 2
        }
        String u = s.substring(0, i + 1);            // 2
        String v = s.substring(i + 1);               // 2
        if (wellFormed(u)) return u + solution(v);   // 3, 3-1
        var r = new StringBuilder("(")               // 4-1
            .append(solution(v)).append(")")         // 4-2, 4-3
            .append(new StringBuilder(u)             // 4-4
                         .deleteCharAt(u.length() - 1).deleteCharAt(0)                       // 4-4
                         .toString().replace('(', '_').replace(')', '(').replace('_', ')')); // 4-4
        return r.toString();                         // 4-5
    }

    public static void main(String[] args) {
        String[] a = { "(()())()", ")(", "()", "()))((()", "()(())()", "))((" };
        for (String s : a)
            System.out.printf("%s => %s\n", s, solution(s));
    }
}