public class Main1 {

    static class Solution {
        int highCount(int[] count, int priority) {
            int result = 0;
            for (int i = priority + 1; i < count.length; ++i)
                result += count[i];
            return result;
        }

        public int solution(int[] priorities, int location) {
            int[] count = new int[10];
            for (int p : priorities)
                count[p]++;

            priorities[location] *= -1;
            var queue = new java.util.ArrayDeque<Integer>();
            for (int p : priorities)
                queue.add(p);
            int answer = 1;
            while (true) {
                int p = queue.remove();
                if (p < 0) {
                    if (highCount(count, -p) == 0) break;
                    else queue.add(p);
                }
                else {
                    if (highCount(count, p) == 0) {
                        ++answer;
                        count[p]--;
                    } else queue.add(p);
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[] {2,1,3,2}, 2));
        System.out.println(sol.solution(new int[] {1,1,9,1,1,1}, 0));
    }
}