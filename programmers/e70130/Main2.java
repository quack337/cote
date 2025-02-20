package programmers.e70130;

import java.util.ArrayList;
import java.util.Collections;

public class Main2 {

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
            while (i < A.length && A[i] != 공통수) // index 위치 뒤의 공통 수 찾기
                ++i;
            if (i >= A.length) { // 더 이상 공통 수가 없다면, 스타수열 한 개 완성
                if (길이 > 최대길이) 최대길이 = 길이; // 최대 값을 구한다.
                return;
            }
            if (i > index && A[i - 1] != A[i]) // {i - 1, i} 한쌍을 수열에 추가하고
                스타수열찾기(A, i + 1, 공통수, 길이 + 2); // 다음 쌍 찾기 재귀호출
            if (i + 1 < A.length && A[i] != A[i + 1]) // {i, i + 1} 한쌍을 수열에 추가하고
                스타수열찾기(A, i + 2, 공통수, 길이 + 2); // 다음 쌍 찾기 재귀호출
            스타수열찾기(A, i + 1, 공통수, 길이); // 현재 위치 수를 무시하고 다음 쌍 찾기 재귀호출
        }

        public int solution(int[] A) {
            최대길이 = 0; // 구할 답

            // 출현 빈도 수 구하기
            int[] count = new int[A.length];
            for (int i : A) count[i]++;

            // 출현 빈도 수 내림차순 정렬
            ArrayList<Entry> list = new ArrayList<>();
            for (int i = 0; i < count.length; ++i)
                if (count[i] > 0)
                    list.add(new Entry(i, count[i]));
            Collections.sort(list, (a, b) -> b.count - a.count);

            // 공통 수 각각에 대해서, 스타수열 찾기
            for (Entry entry : list) {
                // 지금까지 찾은 스타수열 최대값 보다 (출현 빈도 수 * 2)가 작은 공통 수는 시도할 필요 없다.
                if (entry.count * 2 <= 최대길이) break;

                스타수열찾기(A, 0, entry.number, 0);
            }
            return 최대길이;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {0})); // 0
        System.out.println(sol.solution(new int[] {5,2,3,3,5,3})); // 4
        System.out.println(sol.solution(new int[] {0,3,3,0,7,2,0,2,2,0})); // 8

        System.out.println(sol.solution(new int[] {1, 1})); // 0
        System.out.println(sol.solution(new int[] {1, 2, 1})); // 2
        System.out.println(sol.solution(new int[] {1, 2, 1, 2})); // 4
        System.out.println(sol.solution(new int[] {0, 1, 1, 2, 1, 2, 1})); // 6
    }
}
