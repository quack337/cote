package programmers.p1835;

import java.util.*;

// 완전탐색만 구현
public class Solution2c {
  String[] list;
  int r;
  List<String> result, selected;

  List<String> solution(String[] list, int r) {
    this.list = list;
    this.r = r;
    this.result = new ArrayList<String>();
    this.selected = new ArrayList<String>();
    DFS();
    return result;
  }

  void DFS() {
    if (selected.size() == r) {
      result.add(String.join("", selected));
      return;
    }
    for (String ch : list)
      if (!selected.contains(ch)) {
        selected.add(ch);
        DFS();
        selected.remove(selected.size() - 1);
      }
  }

  public static void main(String[] args) {
    String[] list = {"A","C","F","J","M","N","R","T" };
    var sol = new Solution2c();
    List<String> result = sol.solution(list, 8);
    System.out.println(result.toString());
  }
}