package programmers.p70130;
import java.util.ArrayList;
import java.util.Collections;

public class Main1 {

    static class Solution {

        static class Entry {
            int number, count;

            public Entry(int number, int count) {
                this.number = number;
                this.count = count;
            }
        }

       static int 최대길이 = 0;

        static void 스타수열찾기(int[] A, int index, int 공통수, int 길이) {
            int i = index;
            while (i < A.length && A[i] != 공통수)
                ++i;
            if (i >= A.length) {
                if (길이 > 최대길이) 최대길이 = 길이;
                return;
            }
            if (i > index && A[i - 1] != A[i])
                스타수열찾기(A, i + 1, 공통수, 길이 + 2);
            if (i + 1 < A.length && A[i] != A[i + 1])
                스타수열찾기(A, i + 2, 공통수, 길이 + 2);
        }

        public int solution(int[] A) {
            최대길이 = 0;
            int[] count = new int[A.length];
            for (int i : A) count[i]++;
            ArrayList<Entry> list = new ArrayList<>();
            for (int i = 0; i < count.length; ++i)
                list.add(new Entry(i, count[i]));
            Collections.sort(list, (a, b) -> b.count - a.count);
            for (Entry entry : list)
                if (entry.count * 2 > 최대길이)
                    스타수열찾기(A, 0, entry.number, 0);
            return 최대길이;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {0}));
        System.out.println(sol.solution(new int[] {5,2,3,3,5,3}));
        System.out.println(sol.solution(new int[] {0,3,3,0,7,2,0,2,2,0}));
    }
}