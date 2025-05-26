package programmers.p1835;

import java.util.*;

// 완전탐색만 구현
public class Solution2b {
  static final String[] 프렌즈목록 = {"A","C","F","J","M","N","R","T" };

  static void 완전탐색() {
    List<String> selected = new ArrayList<>();
    for (String a : 프렌즈목록) {
      selected.add(a);
      for (String b : 프렌즈목록) {
        if (selected.contains(b)) continue;
        selected.add(b);
        for (String c : 프렌즈목록) {
          if (selected.contains(c)) continue;
          selected.add(c);
          for (String d : 프렌즈목록) {
            if (selected.contains(d)) continue;
            selected.add(d);
            for (String e : 프렌즈목록) {
              if (selected.contains(e)) continue;
              selected.add(e);
              for (String f : 프렌즈목록) {
                if (selected.contains(f)) continue;
                selected.add(f);
                for (String g : 프렌즈목록) {
                  if (selected.contains(g)) continue;
                  selected.add(g);
                  for (String h : 프렌즈목록) {
                    if (selected.contains(h)) continue;
                    selected.add(h);
                    String s = String.join("", selected);
                    System.out.print(s+" ");
                    selected.removeLast();
                  }
                  selected.removeLast();
                }
                selected.removeLast();
              }
              selected.removeLast();
            }
            selected.removeLast();
          }
          selected.removeLast();
        }
        selected.removeLast();
      }
      selected.removeLast();
    }
  }

  public static void main(String[] args) {
    완전탐색();
  }
}