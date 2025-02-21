import java.util.HashMap;

public class Main {

    static class Solution {
        public int solution(String[] friends, String[] gifts) {
            int N = friends.length;
            var map = new HashMap<String, Integer>(); // key: 이름, value: 인덱스
            for (int i = 0; i < friends.length; ++i)
                map.put(friends[i], i);
            var 선물횟수 = new int[N][N]; // 선물을 준 횟수
            for (String s : gifts) {
                String[] a = s.split(" ");
                int from = map.get(a[0]), to = map.get(a[1]);
                선물횟수[from][to]++;
            }
            var 선물지수 = new int[N];
            for (int 나 = 0; 나 < N; ++나) {
                int 준_수 = 0, 받은_수 = 0;
                for (int 친구 = 0; 친구 < N; ++친구) {
                    준_수 += 선물횟수[나][친구];
                    받은_수 += 선물횟수[친구][나];
                }
                선물지수[나] = 준_수 - 받은_수;
            }
            var 받을선물 = new int[N]; // 받을 선물의 수
            for (int a = 0; a < N; ++a)
                for (int b = a + 1; b < N; ++b)
                    if (선물횟수[a][b] > 선물횟수[b][a]) 받을선물[a]++;
                    else if (선물횟수[a][b] < 선물횟수[b][a]) 받을선물[b]++;
                    else if (선물지수[a] > 선물지수[b]) 받을선물[a]++;
                    else if (선물지수[a] < 선물지수[b]) 받을선물[b]++;
            int max = 0;
            for (int i : 받을선물)
                if (i > max) max = i;
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(
            new String[] {"muzi", "ryan", "frodo", "neo"},
            new String[] {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi",
                    "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
        System.out.println(new Solution().solution(
                new String[] {"joy", "brad", "alessandro", "conan", "david"},
                new String[] {"alessandro brad", "alessandro joy", "alessandro conan",
                        "david alessandro", "alessandro david"}));
        System.out.println(new Solution().solution(
                new String[] {"a", "b", "c"},
                new String[] {"a b", "b a", "c a", "a c", "a c", "c a"}));
    }
}