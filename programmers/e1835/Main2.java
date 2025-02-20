package programmers.e1835;

import java.util.HashMap;

public class Main2 {

    static class Solution {
        static final String 프렌즈목록 = "ACFJMNRT";
        String[] 조건목록;

        boolean 조건을_만족하나(char[] 배치) {
            var 위치 = new HashMap<Character, Integer>();
            for (int i = 0; i < 배치.length; ++i)
                위치.put(배치[i], i);

            for (String 조건 : 조건목록) {
                char 프렌즈1 = 조건.charAt(0), 프렌즈2 = 조건.charAt(2);
                Integer 위치1 = 위치.get(프렌즈1), 위치2 = 위치.get(프렌즈2);
                if (위치1 == null || 위치2 == null) continue;
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

        int 완전탐색(int index, char[] 배치) {
            if (index == 배치.length)
                return 조건을_만족하나(배치) ? 1 : 0;
            char 프렌즈 = 프렌즈목록.charAt(index);
            int 경우의수 = 0;
            for (int i = 0; i < 배치.length; ++i)
                if (배치[i] == 0) {
                    배치[i] = 프렌즈;
                    경우의수 += 완전탐색(index + 1, 배치);
                    배치[i] = 0;
                }
            return 경우의수;
        }

        public int solution(int n, String[] data) {
            조건목록 = data;
            return 완전탐색(0, new char[8]);
        }
    }

    public static void main(String[] args) {
        var s = new Solution();

        var 조건목록1 = new String[] {"N~F=0", "R~T>2"};
        System.out.println(s.solution(2, 조건목록1));

        var 조건목록2 = new String[] {"M~C<2", "C~M>1"};
        System.out.println(s.solution(2, 조건목록2));
    }
}
