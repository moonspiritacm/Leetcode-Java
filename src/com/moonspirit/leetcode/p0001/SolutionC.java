package com.moonspirit.leetcode.p0001;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表+前向搜索。O(n) O(n)
 * 预处理哈希表无法解决元素多次使用的问题，需要额外判断是否重复。
 * 转换思路，哈希表存储 nums[i] 之前元素的映射关系，对于每轮循环，在前序元素中寻找 target-nums[i] 位置，既能避免重复，又可以同时构建哈希表。
 */
class SolutionC {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{i, map.get(tmp)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
