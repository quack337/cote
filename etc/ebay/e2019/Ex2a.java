package ebay.e2019;

public class Ex2a {

    static int 최대공약수(int a, int b){
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static boolean solution(String s1, String s2) {
        final int N1 = s1.length(), N2 = s2.length();
        int 최소공배수 = N1 * N2 / 최대공약수(N1, N2);
        for (int i = 0; i < 최소공배수; ++i) {
            int i1 = i % N1;
            int i2 = i % N2;
            if (s1.charAt(i1) != s2.charAt(i2)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] a = new String[][] {
            {"a", "a"},
            {"a", "aa"},
            {"ab", "abab"},
            {"abab", "ababab"},
            {"a", "b"},
            {"a", "bb"},
            {"ab", "aba"},
            {"abab", "abaab"},
        };
        for (String[] s : a)
            System.out.println(solution(s[0], s[1]));
    }
}