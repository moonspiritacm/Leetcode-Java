package com.moonspirit.leetcode.p0523;

import java.util.HashMap;
import java.util.Map;

/**
 * 哈希表+同余定理。O(n) O(n)
 * 根据同余定理，(prefix[j]-prefix[i])%k=0 等价于 prefix[j]%k=prefix[i]%k；
 * 问题转化为，是否存在索引i, j，满足 prefix[j]%k=prefix[i]%k 并且 j-i>=2。
 */
class SolutionB {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int prefix = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefix = (prefix + nums[i - 1]) % k;
            if (map.containsKey(prefix)) {
                if (i - map.get(prefix) >= 2) {
                    return true;
                }
            } else {
                map.put(prefix, i);
            }
        }
        return false;
    }
}
