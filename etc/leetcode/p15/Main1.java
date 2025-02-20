package leetcode.p15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1 {

    static class Solution {
        List<List<Integer>> result;

        void 탐색(int[] nums, int index, ArrayList<Integer> list, int sum) {
            if (list.size() == 3 && sum == 0) {
                var list2 = new ArrayList<Integer>(list);
                Collections.sort(list2); // 3 수를 정렬한다
                if (!result.contains(list2)) result.add(list2);
                return;
            }
            if (index == nums.length) return;
            탐색(nums, index + 1, list, sum);
            list.add(nums[index]);
            탐색(nums, index + 1, list, sum + nums[index]);
            list.remove(list.size() - 1);
        }

        public List<List<Integer>> threeSum(int[] nums) {
            result = new ArrayList<>();
            탐색(nums, 0, new ArrayList<Integer>(), 0);
            result.sort((a, b) -> { // result 목록을 정렬한다.
                for (int i = 0; i < 3; ++i) {
                    int r = a.get(i) - b.get(i);
                    if (r != 0) return r;
                }
                return 0;
            });
            return result;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution();
        System.out.println(sol.threeSum(new int[] {-1,0,1,2,-1,-4}));
        System.out.println(sol.threeSum(new int[] {}));
        System.out.println(sol.threeSum(new int[] {0}));
    }
}
