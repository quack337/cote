package programmers.p60058;
public class Test1 {

    static boolean balanced(String s) {
        int count = 0;
        for (char c : s.toCharArray())
            count += (c == '(') ? 1 : -1;
        return count == 0;
    }

    static boolean wellFormed(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += (c == '(') ? 1 : -1;
            if (count < 0) return false;
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String[] a = { "(()())()", ")(", "()", "()))((()", "()(())()", "(("};
        for (String s : a)
            System.out.printf("%s %s %s\n", s, balanced(s), wellFormed(s));
    }

}