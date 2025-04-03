
public class Test {

    static int[] preprocessing(String P) {
        int[] pi = new int[P.length() + 1];
        int j = 0, k = -1;
        pi[0] = -1;
        while (j < P.length()) {
            if (k == -1 || P.charAt(j) == P.charAt(k)) {
                ++j; ++k;
                pi[j] = k;
            } else
                k = pi[k];
        }
        return pi;
    }

    // s 문자열에서 p 부분 문자열을 찾아서 인덱스를 리턴한다.
    static int findIndex(String A, String P) {
      int n = A.length(), m = P.length();
      int[] pi = preprocessing(P);
      int i = 0, j = 0;
      while (i < n) {
          if (j == -1 || A.charAt(i) == P.charAt(j)) {
              ++i; ++j;
          } else
              j = pi[j];
          if (j == m)
              return i - m; // 매칭 발견
      }
      return -1; // 일치하는 문자열을 찾지 못한 경우에 -1을 리턴
  }

    public static void main(String[] args) {
        String s = "abcabababcaababcdabcababcfabababcabab";
        String p = "ababc";
        System.out.println(findIndex(s, p));
    }
}