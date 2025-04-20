package programmers.p60057;
public class Test1 {

    static String compress(String s) {
        StringBuilder result = new StringBuilder();
        char prev = s.charAt(0); // 첫 문자
        int count = 1; // prev와 일치하는 문자의 수
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == prev) // s[i]가 prev 문자와 일치하면
                ++count; // 출력하지 않고 count만 증가
            else { // 일치하지 않으면
                // count와 prev 문자를 출력한다
                if (count > 1) result.append(count);
                result.append(prev);

                // s[i]가 prev 문자가 된다
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