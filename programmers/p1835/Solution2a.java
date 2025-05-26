package programmers.p1835;

// 완전탐색만 구현
public class Solution2a {
  static final char[] 프렌즈목록 = {'A','C','F','J','M','N','R','T' };

  static void 완전탐색() {
    for (char a : 프렌즈목록) {
      for (char b : 프렌즈목록) {
        if (a==b) continue;
        for (char c : 프렌즈목록) {
          if (a==c || b==c) continue;
          for (char d : 프렌즈목록) {
            if (a==d || b==d || c==d) continue;
            for (char e : 프렌즈목록) {
              if (a==e || b==e || c==e || d==e)
                continue;
              for (char f : 프렌즈목록) {
                if (a==f || b==f || c==f || d==f || e==f)
                  continue;
                for (char g : 프렌즈목록) {
                  if (a==g || b==g || c==g || d==g || e==g || f==g)
                    continue;
                  for (char h : 프렌즈목록) {
                    if (a==h || b==h || c==h || d==h || e==h || f==h || g==h)
                      continue;
                    System.out.print(""+a+b+c+d+e+f+g+h+" ");
                  }
                }
              }
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    완전탐색();
  }
}