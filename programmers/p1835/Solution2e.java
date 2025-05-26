package programmers.p1835;

import java.util.*;

// 답
public class Solution2e {
  final char[] list = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
  int r = list.length, result = 0;
  List<Character> selected = new ArrayList<Character>();
  String[] 조건목록;

  boolean 조건을_만족하나(List<Character> 배치) {
    var 위치 = new HashMap<Character, Integer>();
    for (int i = 0; i < 배치.size(); ++i)
      위치.put(배치.get(i), i);

    for (String 조건 : 조건목록) {
      char 프렌즈1 = 조건.charAt(0), 프렌즈2 = 조건.charAt(2);
      Integer 위치1 = 위치.get(프렌즈1), 위치2 = 위치.get(프렌즈2);
      int 실제간격 = Math.abs(위치1 - 위치2) - 1;
      int 조건간격 = 조건.charAt(4) - '0';
      switch (조건.charAt(3)) {
        case '=': if (실제간격 == 조건간격) continue; else return false;
        case '>': if (실제간격 > 조건간격) continue; else return false;
        case '<': if (실제간격 < 조건간격) continue; else return false;
      }
    }
    return true;
  }

  int solution(int n, String[] data) {
    this.조건목록 = data;
    DFS();
    return result;
  }

  void DFS() {
    if (selected.size() == r) {
      if (조건을_만족하나(selected))
        ++result;
      return;
    }
    for (char ch : list)
      if (!selected.contains(ch)) {
        selected.add(ch);
        DFS();
        selected.remove(selected.size() - 1);
      }
  }

  public static void main(String[] args) {
    var sol = new Solution2e();
    int result = sol.solution(2, new String[] {"N~F=0", "R~T>2"});
    System.out.println(result);
  }
}