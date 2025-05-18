package programmers.p1835;

import java.util.*;

// 완전탐색만 구현
public class Solution2d {
  char[] list;
  int r, result;
  List<Character> selected;

  int solution(char[] list, int r) {
    this.list = list;
    this.r = r;
    this.result = 0;
    this.selected = new ArrayList<Character>();
    DFS();
    return result;
  }

  void DFS() {
    if (selected.size() == r) {
      ++result;
      return;
    }
    for (Character ch : list)
      if (!selected.contains(ch)) {
        selected.add(ch);
        DFS();
        selected.remove(selected.size() - 1);
      }
  }

  public static void main(String[] args) {
    char[] list = {'A','C','F','J','M','N','R','T' };
    var sol = new Solution2d();
    int result = sol.solution(list, 8);
    System.out.println(result);
  }
}