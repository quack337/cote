import java.util.Arrays;

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

  public static void main(String[] args) {
    String p = "ababc";
    int[] pi = preprocessing(p);
    System.out.println(Arrays.toString(pi));
  }
}
