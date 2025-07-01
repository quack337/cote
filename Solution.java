import java.util.ArrayList;
import java.util.List;

public class Solution {
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
      result.add(selected.toString().replaceAll("[^A-Z]", ""));
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
    String[] list = {"A","B","C","D"};
    Solution sol = new Solution();
    List<String> result = sol.solution(list, 3);
    System.out.println(result.toString());
  }
}
