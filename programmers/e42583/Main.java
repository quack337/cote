import java.util.ArrayDeque;

public class Main {
    static class Solution {

        public int solution(int 다리길이, int 다리_허용중량, int[] 트럭중량) {
            var 다리_큐 = new ArrayDeque<Integer>();
            int 경과시간 = 0, 현재트럭 = 0, 다리위_트럭들_중량 = 0, 건넌_트럭수 = 0;
            while (건넌_트럭수 < 트럭중량.length) {
                ++경과시간;
                if (다리_큐.size() == 다리길이) {
                    var 건넌트럭중량 = 다리_큐.remove();
                    다리위_트럭들_중량 -= 건넌트럭중량;
                    if (건넌트럭중량 > 0) ++건넌_트럭수;
                }
                if (현재트럭 < 트럭중량.length && 다리위_트럭들_중량 + 트럭중량[현재트럭] <= 다리_허용중량) {
                    다리_큐.add(트럭중량[현재트럭]);
                    다리위_트럭들_중량 += 트럭중량[현재트럭];
                    ++현재트럭;
                } else
                    다리_큐.add(0);
            }
            return 경과시간;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.solution(2, 10, new int[] {7,4,5,6}));
        System.out.println(sol.solution(100, 100, new int[] {100}));
        System.out.println(sol.solution(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}));
    }
}