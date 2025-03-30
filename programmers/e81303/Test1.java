package programmers.e81303;

import java.util.LinkedList;

public class Test1 {

  static class Solution {
    public String solution(int 크기, int 현재, String[] 명령목록) {
      LinkedList<Integer> 삭제목록 = new LinkedList<>();
      for (String s : 명령목록) {
        int 이동 = s.length() < 2 ? 0 : Integer.valueOf(s.substring(2));
        int index = 0;
        switch (s.charAt(0)) {
        case 'U': 현재 = Math.max(0, 현재 - 이동); break;
        case 'D': 현재 = Math.min(현재 + 이동, 크기 - 1); break;
        case 'C': 삭제목록.push(현재);
                  --크기;
                  if (현재 == 크기) --현재;
                  break;
        case 'Z': index = 삭제목록.pop();
                  if (index <= 현재) ++현재;
                  ++크기;
                  break;
        }
      }
      StringBuilder builder = new StringBuilder();
      for (int i = 0; i < 크기; ++i)
        builder.append('O');
      while (삭제목록.size() > 0) {
        int index = 삭제목록.pop();
        builder.insert(index, 'X');
      }
      return builder.toString();
    }
  }

  public static void main(String[] args) {
    String[] s1 = new String[] { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z" };
    System.out.println(new Solution().solution(8, 2, s1));
    String[] s2 = new String[] { "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C" };
    System.out.println(new Solution().solution(8, 2, s2));
  }
}
