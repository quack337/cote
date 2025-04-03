package programmers.e42889;

import java.util.Arrays;

public class Test1 {

    static class Failure implements Comparable<Failure> {
        double 실패율;
        int 스테이지;

        public Failure(double 실패율, int 스테이지) {
            this.실패율 = 실패율;
            this.스테이지 = 스테이지;
        }

        @Override
        public int compareTo(Failure obj) {
            int r = (int)Math.signum(obj.실패율 - this.실패율);
            return (r != 0) ? r : this.스테이지 - obj.스테이지;
        }
    }

    static class Solution {
        public int[] solution(int N, int[] stages) {
            int[] 멈춤 = new int[N+1];
            for (int s : stages)
                멈춤[s - 1]++;
            int[] 도달 = new int[N+1];
            도달[N] = 멈춤[N];
            for (int i = N-1; i >= 0; --i)
                도달[i] = 도달[i+1] + 멈춤[i];
            Failure[] 실패율 = new Failure[N];
            for (int i = 0; i < N; ++i)
                실패율[i] = new Failure((double)멈춤[i] / 도달[i], i + 1);
            Arrays.sort(실패율);
            int[] result = new int[N];
            for (int i = 0; i < N; ++i)
                result[i] = 실패율[i].스테이지;
            return result;
        }
    }

    public static void main(String[] args) {
        int[] a1 = {2, 1, 2, 6, 2, 4, 3, 3}; // [3,4,2,1,5]
        int[] a2 = {4,4,4,4,4};              // [4,1,2,3]
        System.out.println(Arrays.toString(new Solution().solution(5, a1)));
        System.out.println(Arrays.toString(new Solution().solution(4, a2)));
    }

}