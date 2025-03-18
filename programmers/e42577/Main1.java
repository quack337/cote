import java.util.ArrayList;

public class Main1 {

    static class Solution {
        public boolean solution(String[] phone_book) {
            ArrayList<String>[] list = new ArrayList[21];
            for (int size = 1; size <= 20; ++size)
                list[size] = new ArrayList<String>();
            for (var no : phone_book)
                list[no.length()].add(no);
            for (int size1 = 1; size1 <= 20; ++size1)
            for (String s1 : list[size1])
                for (int size2 = size1 + 1; size2 <= 20; ++size2)
                for (String s2 : list[size2])
                    if (s2.startsWith(s1)) 
                        return false;
            return true;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(new String[] {"119", "97674223", "1195524421"}));
        System.out.println(sol.solution(new String[] {"123","456","789"}));
        System.out.println(sol.solution(new String[] {"12","123","1235","567","88"}));
    }
}