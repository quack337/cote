package leetcode.p15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main2 {

    static class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            var count = new HashMap<Integer, Integer>();
            for (int i : nums)
                count.put(i, 1 + count.getOrDefault(i, 0));
            for (int i = 0; i < nums.length - 1 && nums[i] < 0; ++i) {
                if (i > 0 && nums[i - 1] == nums[i]) continue;
                for (int j = i + 1; j < nums.length - 1; ++j) {
                    if (j > i + 1 && nums[j - 1] == nums[j]) continue;
                    int s = 0 - (nums[i] + nums[j]);
                    if (s > nums[j]) {
                        if (count.getOrDefault(s, 0) > 0)
                            result.add(List.of(nums[i], nums[j], s));
                    }
                    else if (s == nums[j]) {
                        if (count.get(s) >= 2)
                            result.add(List.of(nums[i], nums[j], s));
                    }
                    else break;
                }
            }
            if (count.getOrDefault(0, 0) >= 3) result.add(List.of(0, 0, 0));
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

