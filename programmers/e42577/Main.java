import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    static class Solution {
        public boolean solution(String[] phone_book) {
            ArrayList<String>[] list = new ArrayList[21];
            for (int size = 1; size <= 20; ++size)
                list[size] = new ArrayList<String>();
            for (var no : phone_book)
                list[no.length()].add(no);
            var set = new HashSet<String>();
            for (int size = 1; size <= 20; ++size)
                for (var no : list[size]) {
                    for (int i = 1; i < size; ++i)
                        if (set.contains(no.substring(0, i)))
                            return false;
                    set.add(no);
                }
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