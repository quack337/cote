package programmers.p72410;

public class Test1 {

    static class Solution {

        public String solution(String id) {
            id = id.toLowerCase();                     // 1
            id = id.replaceAll("[^a-z0-9_.-]+", "");   // 2
            id = id.replaceAll("\\.{2,}", ".");        // 3
            id = id.replaceAll("(^\\.)|(\\.$)", "");   // 4
            if (id.isEmpty()) id = "a";                // 5
            if (id.length() >= 16) {                   // 6
                id = id.substring(0, 15);
                id = id.replaceAll("\\.$", "");
            }
            while (id.length() <= 2)                   // 7
                id += id.charAt(id.length() - 1);
            return id;
        }
    }

    public static void main(String[] args) {
        String[] a = { "!@BaT#*..y.abcdefghijklm", "z-+.^.", "=.=",
                "123_.def", "abcdefghijklmn.p", "." };
        Solution sol = new Solution();
        for (String s : a)
            System.out.println(sol.solution(s));
    }

}