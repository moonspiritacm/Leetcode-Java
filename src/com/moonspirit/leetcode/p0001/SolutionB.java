package com.moonspirit.leetcode.p0001;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表。O(n) O(n)
 * 使用哈希表存储 <数值,位置> 映射，实现在 O(1) 时间复杂度内找到 target-nums[i] 位置。
 */
class SolutionB {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && map.get(tmp) != i) {
                return new int[]{i, map.get(tmp)};
            }
        }
        return new int[0];
    }
}
