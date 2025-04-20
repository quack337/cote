package programmers.p42895;
import java.util.HashSet;

public class Main1 {

    static class Solution {

        HashSet<Integer> sol(int N, int count) {
            var set = new HashSet<Integer>();
            int NN = 0;
            for (int i = 0; i < count; ++i)
                NN = NN * 10 + N;
            set.add(NN);

            if (count == 1) return set;
            for (int i = 1; i < count; ++i) {
                var set1 = sol(N, i);
                var set2 = sol(N, count - i);
                for (int value1 : set1)
                    for (int value2 : set2) {
                        set.add(value1 + value2);
                        set.add(value1 - value2);
                        set.add(value1 * value2);
                        if (value2 != 0) set.add(value1 / value2);
                    }
            }
            return set;

        }

        public int solution(int N, int number) {
            for (int count = 1; count <= 8; ++count) {
                var set = sol(N, count);
                if (set.contains(number))
                    return count;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5, 12));
        System.out.println(sol.solution(2, 11));
    }
}