package ebay.e2019;

public class Ex2b {

    static int 최대공약수(int a, int b){
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    static boolean solution1(String s1, String s2) {
        final int N1 = s1.length(), N2 = s2.length();
        int gcd = 최대공약수(N1, N2);
        for (int i = 0; i < N1; ++i)
            if (s1.charAt(i) != s2.charAt(i % gcd)) return false;
        for (int i = 0; i < N1; ++i)
            if (s2.charAt(i) != s1.charAt(i % gcd)) return false;
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
            System.out.println(solution1(s[0], s[1]));
    }
}
