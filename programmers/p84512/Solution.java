package programmers.p84512;

import java.util.*;

public class Solution {
  public int solution(String word) {
    final String[] list = {"A", "E", "I", "O", "U"};
    List<String> dic = new ArrayList<>();
    for (String a : list) {
      dic.add(a);
      for (String b : list) {
        dic.add(a + b);
        for (String c : list) {
          dic.add(a + b + c);
          for (String d : list) {
            dic.add(a + b + c + d);
            for (String e : list)
              dic.add(a + b + c + d + e);
          }
        }
      }
    }
    return dic.indexOf(word) + 1;
  }

  public static void main(String[] args) {
    var sol = new Solution();
    System.out.println(sol.solution("AAAAE"));
    System.out.println(sol.solution("AAAE"));
    System.out.println(sol.solution("I"));
    System.out.println(sol.solution("EIO"));
  }
}
