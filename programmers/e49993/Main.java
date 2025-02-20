package programmers.e49993;

public class Main {

    static class Solution {

        int[] 스킬순서찾기(String skill) {
            int[] order = new int['Z' - 'A' + 1];
            int no = 1;
            for (char ch : skill.toCharArray()) {
                order[ch - 'A'] = no;
                ++no;
            }
            return order;
        }

        boolean 가능한스킬트리인가(int[] order, String s) {
            int no = 1;
            for (char ch : s.toCharArray()) {
                if (order[ch - 'A'] == 0) continue;
                if (order[ch - 'A'] != no) return false;
                ++no;
            }
            return true;
        }

        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            int[] order = 스킬순서찾기(skill);
            for (String 스킬트리 : skill_trees)
                if (가능한스킬트리인가(order, 스킬트리))
                    ++answer;
            return answer;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution("CBD", new String[] {"BACDE", "CBADF", "AECB", "BDA"}));
    }

}
